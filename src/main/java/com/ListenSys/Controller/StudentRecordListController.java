package com.ListenSys.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.FolderDaoImpl;
import com.ListenSys.Dao.Impl.SoundDaoImpl;
import com.ListenSys.Entity.Folder;
import com.ListenSys.Entity.Sound;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/student/{studentId}/recordList")
public class StudentRecordListController {
	@Autowired
	SoundDaoImpl soundDaoImlp;
	@Autowired
	FolderDaoImpl folderDaoImpl;
	// 录音记录的控制器
	@RequestMapping(method = RequestMethod.GET)
	public String home(@PathVariable String studentId, ModelMap modelMap,
			HttpSession session) {
		Student student = (Student) session.getAttribute("student");
		modelMap.put("recordMap",getRecordMapByStudentId(student.getId()));
		return "student/stu_recordList";
	}
	private Map<Folder,List<Sound>> getRecordMapByStudentId(int studentId){
		Map<Folder,List<Sound>> recordMap=new HashMap<Folder, List<Sound>>();
		List<Folder> folderList=folderDaoImpl.getFoldersByStudentId(studentId);
		List<Sound> soundList=null;
		for(Folder f:folderList){
			soundList=soundDaoImlp.getSoundsByFolderAndStudent(f.getId(), studentId);
			recordMap.put(f, soundList);
		}
		return recordMap;
	}
}
