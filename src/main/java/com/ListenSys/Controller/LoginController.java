package com.ListenSys.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Student;
import com.ListenSys.Entity.Teacher;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	TeacherDaoImpl teacherDaoImpl;
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public String LoginInit(){
		return "common/login";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String LoginCheck(String userId,String password,String roles,ModelMap modelMap,HttpSession session){
		//TODO Model里要放进去出错信息，重定向需要错误提示
		if(roles.equals("student")){
			Student student=studentDaoImpl.getStudentByStudentId(userId);
			if(student.getStudentId()==null){
				modelMap.put("error","指定学生不存在");
			}else if(!student.getStudentPwd().equals(password)){
				modelMap.put("error", "密码不正确");
			}else{
				session.setAttribute("student", student);
				return "redirect:student/"+student.getStudentId()+"/recordList";
			}
		}else if(roles.equals("teacher")){
			Teacher teacher=teacherDaoImpl.getTeacherByTeacherId(userId);
			if(teacher.getTeacherId()==null){
				modelMap.put("error", "指定教师不存在");
			}else if(!teacher.getTeacherPwd().equals(password)){
				modelMap.put("error", "密码不正确");
			}else{
				session.setAttribute("teacher", teacher);
				return "redirect:teacher/"+teacher.getTeacherId()+"/folderList";
			}
		}
		return "redirect:login";
	}
}
