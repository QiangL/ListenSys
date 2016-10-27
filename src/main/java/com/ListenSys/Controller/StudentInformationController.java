package com.ListenSys.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/student/{studentId}/information")
public class StudentInformationController {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	//修改信息的控制器
	@RequestMapping(method=RequestMethod.GET)
	public String showInformation(@PathVariable String studentId){
		return "student/stu_userCenter";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String checkInformation(@PathVariable String studentId,Student s,String password2,String passwordComfir,
			RedirectAttributes redirectAttributes,HttpSession session){
		Student student=(Student) session.getAttribute("student");
		if(!student.getStudentPwd().equals(s.getStudentPwd())){
			redirectAttributes.addFlashAttribute("error","原始密码错误");
			return "redirect:information";
		}
		if(!password2.equals(passwordComfir)){
			redirectAttributes.addFlashAttribute("error","两次更改的密码不一致");
			return "redirect:information";
		}
		if(!password2.equals("")){//TODO验证密码格式
			if(password2.matches("^[a-zA-Z]\\w{5,17}$")){
				student.setStudentPwd(password2);
			}else {
				redirectAttributes.addFlashAttribute("error","新密码格式不正确");
				return "redirect:information";
			}
			
		}
		student.setClassesId(s.getClassesId());
		student.setStudentEmail(s.getStudentEmail());
		student.setStudentName(s.getStudentName());
		if(!studentDaoImpl.updateStudent(student)){
			redirectAttributes.addFlashAttribute("error","修改失败");
			return "redirect:information";
		}
		session.removeAttribute("student");
		session.setAttribute("student", student);
		redirectAttributes.addFlashAttribute("success","修改成功");
		return "redirect:information";
	}

}
