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
	@RequestMapping(value="/information",method=RequestMethod.GET)
	public String showInformation(@PathVariable String teacherId,ModelMap modelMap,HttpSession session){
		Teacher teacher=(Teacher) session.getAttribute("teacher");
		if(teacher==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(teacher.getTeacherId().equals(teacherId)){
			modelMap.put("teacher",teacher);//存放teacher,之后在jsp上显示
			return "teacher/tea_userCenter";
		}else{
			modelMap.put("error","禁止访问");
			return "redirect:/login";
		}
	}
	@RequestMapping(value="/information",method=RequestMethod.POST)
	public String checkInformation(@PathVariable String teacherId,Teacher s,String password2,String passwordComfir,ModelMap modelMap,HttpSession session){
		Teacher teacher=(Teacher) session.getAttribute("teacher");
		if(teacher==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(!teacher.getTeacherId().equals(teacherId)){
			modelMap.put("error","禁止访问");
			return "redirect:/login";
		}
		if(!teacher.getTeacherPwd().equals(s.getTeacherPwd())){
			modelMap.put("error","原始密码错误");
			return "redirect:information";
		}
		if(!password2.equals(passwordComfir)){
			modelMap.put("error","两次更改的密码不一致");
			return "redirect:information";
		}
		teacher.setTeacherEmail(s.getTeacherEmail());
		teacher.setTeacherName(s.getTeacherName());
		teacher.setTeacherPwd(password2);
		if(!teacherDapImpl.updateTeacher(teacher)){
			modelMap.put("error","修改失败");
			return "redirect:information";
		}
		session.removeAttribute("teacher");
		session.setAttribute("teacher", teacher);
		modelMap.put("success","修改成功");
		return "student/stu_userCenter";
	}
}
