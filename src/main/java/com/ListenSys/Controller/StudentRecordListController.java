package com.ListenSys.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.SoundDaoImpl;
import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Sound;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/student/{studentId}")
public class StudentRecordListController {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	@Autowired
	SoundDaoImpl soundDaoImpl;
	
	@RequestMapping(value="/recordList",method=RequestMethod.GET)
	public String home(@PathVariable String studentId,ModelMap modelMap,HttpSession session){
		//TODO 写个拦截器 确保登陆情况下访问，将多个验证登录整合
		Student student=(Student) session.getAttribute("student");
		if(student==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(student.getStudentId().equals(studentId)){
			List<Sound> recordList=soundDaoImpl.getAllSoundsByStudentId(student.getId());
			modelMap.put("recordList",recordList);
			return "student/stu_recordList";
		}else{
			modelMap.put("error","禁止访问");
			return "redirect:/login";
		}
	}
	@RequestMapping(value="/information",method=RequestMethod.GET)
	public String showInformation(@PathVariable String studentId,ModelMap modelMap,HttpSession session){
		Student student=(Student) session.getAttribute("student");
		if(student==null){
			modelMap.put("error","未登陆");
			return "redirect:/login";
		}
		if(student.getStudentId().equals(studentId)){
			modelMap.put("student",student);
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
