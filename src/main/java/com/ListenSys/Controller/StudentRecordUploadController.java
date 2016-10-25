package com.ListenSys.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ListenSys.Dao.Impl.FolderDaoImpl;
import com.ListenSys.Dao.Impl.SoundDaoImpl;
import com.ListenSys.Entity.Folder;
import com.ListenSys.Entity.Sound;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/student/{studentId}/recordUpload")
public class StudentRecordUploadController {
	@Autowired
	private SoundDaoImpl soundDaoImpl;
	@Autowired
	private FolderDaoImpl folderDaoImpl;
	
	@RequestMapping(method=RequestMethod.GET )
	public String show(@PathVariable String studentId){
		//TODO 登陆验证
		return "student/stu_recordUpload";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String recordUpload(@PathVariable String studentId,@RequestParam(value="record") MultipartFile record,
			HttpServletRequest request,HttpSession session,RedirectAttributes redirectAttributes){
		//TODO 登陆验证
		Student student=(Student)session.getAttribute("student");
		String folderId=request.getParameter("folder");
		if(folderId==null){
			redirectAttributes.addFlashAttribute("error","未选择文件夹");
			return "redirect:recordUpload";
		}else if(!folderId.matches("^[0-9]+$")){
			redirectAttributes.addFlashAttribute("error","文件夹ID不正确");
			return "redirect:recordUpload";
		}else if(!isAudio(record.getOriginalFilename())){
			redirectAttributes.addFlashAttribute("error","上传文件不是音频文件");
			return "redirect:recordUpload";
		}
		Folder folder=folderDaoImpl.getFolderById(Integer.valueOf(folderId));
		if(folder.getFolderName()==null){
			redirectAttributes.addFlashAttribute("error","所选文件夹无效");
			return "redirect:recordUpload";
		}
		String path = request.getSession().getServletContext().getRealPath("/stu_record");
		StringBuilder sb=new StringBuilder();
		sb.append(student.getStudentId());
		sb.append("+").append(folderId).append("+");
		sb.append(record.getOriginalFilename());
        File targetFile = new File(path, sb.toString());
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
		try {
			record.transferTo(targetFile);
		} catch (IllegalStateException | IOException e) {
			//TODO 加入日志
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error","服务器原因，文件上传失败");
			return "redirect:recordUpload";
		}
		Sound sound=new Sound();
		sound.setStudentId(student.getId());
		sound.setFolderId(Integer.valueOf(folderId));
		sb.insert(0, "\\").insert(0, path);//更改了sb，增长前缀，为了储存时加入文件路径
		sound.setPath(sb.toString());
		if(!soundDaoImpl.addSound(sound)){
			redirectAttributes.addFlashAttribute("error","服务器原因，文件上传失败");
			return "redirect:recordUpload";
		}
		return "student/stu_recordUpload";
	}
	private boolean isAudio(String name){
		String [] str=name.split("\\.");
		String suffix=str[str.length-1];
		String AUDIO="mp3|mp2|wav|aac|ogg|au|wma|flac|m4a|ac3";
		if(suffix.matches(AUDIO)) return true;
		else return false;
	}
}
