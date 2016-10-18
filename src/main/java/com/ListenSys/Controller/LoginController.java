package com.ListenSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Student;
import com.ListenSys.Entity.Teacher;

@Controller
public class LoginController {
	@Autowired
	TeacherDaoImpl teacherDaoImpl;
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@RequestMapping(value="/teacher/login",method=RequestMethod.GET)
	public String teacherLoginInti(){
		return "teacherLogin";
	}
	@RequestMapping(value="/student/login",method=RequestMethod.GET)
	public String studentLoginInit(){
		return "studentLogin";
	}
	@RequestMapping(value="/teacher/login",method = RequestMethod.POST)
	public String LoginCheck(Teacher t){
		//TODO Model里要放进去出错信息，重定向需要错误提示
		Teacher teacher=teacherDaoImpl.getTeacherByTeacherId(t.getTeacherId());
		if(teacher.getTeacherPwd().equals(t.getTeacherPwd())){
			return "redirect:teacher/"+teacher.getTeacherId();
		}else return "redirect:teacher/login";
	}
	@RequestMapping(value="/student/login",method = RequestMethod.POST)
	public String LoginCheck(Student s){
		//TODO Model里要放进去出错信息，重定向需要错误提示
		Student student=studentDaoImpl.getStudentByStudentId(s.getStudentId());
		if(student.getStudentPwd().equals(s.getStudentPwd())){
			return "redirect:student/"+student.getStudentId();
		}else return "redirect:student/login";
	}
}
