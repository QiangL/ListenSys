package com.ListenSys.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.FolderDaoImpl;
import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Folder;
import com.ListenSys.Entity.Teacher;

@Controller
@RequestMapping("/teacher/{teacherId}")
public class TeacherFolderListController {
	@Autowired
	TeacherDaoImpl teacherDapImpl;
	@Autowired
	FolderDaoImpl folderDaoImpl;
	
	@RequestMapping(value="/folderList",method=RequestMethod.GET)
	public String home(@PathVariable String teacherId,ModelMap modelMap,HttpSession session){
		//TODO 拦截器 是否是登陆状态访问这个网页
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		if(teacher==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(teacher.getTeacherId().equals(teacherId)){
			List<Folder> folderList=folderDaoImpl.getAllFoldersByTeacherId(teacher.getId());
			modelMap.put("folderList",folderList);
			return "teacher/tea_folderList";
		}else{
			modelMap.put("error","禁止访问");
			return "redirect:/login";
		}
	}
}
