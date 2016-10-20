package com.ListenSys.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/student/{studentId}")
public class StudentInformationController {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	//修改信息的控制器
	@RequestMapping(value="/information",method=RequestMethod.GET)
	public String showInformation(@PathVariable String studentId,ModelMap modelMap,HttpSession session){
		Student student=(Student) session.getAttribute("student");
		if(student==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(student.getStudentId().equals(studentId)){
			modelMap.put("student",student);//存放student,之后在jsp上显示
			return "student/stu_userCenter";
		}else{
			modelMap.put("error","禁止访问");
			return "redirect:/login";
		}
	}
	@RequestMapping(value="/information",method=RequestMethod.POST)
	public String checkInformation(@PathVariable String studentId,Student s,String password2,String passwordComfir,ModelMap modelMap,HttpSession session){
		Student student=(Student) session.getAttribute("student");
		if(student==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(!student.getStudentId().equals(studentId)){
			modelMap.put("error","禁止访问");
			return "redirect:/login";
		}
		if(!student.getStudentPwd().equals(s.getStudentPwd())){
			modelMap.put("error","原始密码错误");
			return "redirect:information";
		}
		if(!password2.equals(passwordComfir)){
			modelMap.put("error","两次更改的密码不一致");
			return "redirect:information";
		}
		student.setClassesId(s.getClassesId());
		student.setStudentEmail(s.getStudentEmail());
		student.setStudentName(s.getStudentName());
		student.setStudentPwd(password2);
		if(!studentDaoImpl.updateStudent(student)){
			modelMap.put("error","修改失败");
			return "redirect:information";
		}
		session.removeAttribute("student");
		session.setAttribute("student", student);
		modelMap.put("success","修改成功");
		return "student/stu_userCenter";
	}

}
