package com.ListenSys.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("student")
public class StudentHomeController {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@RequestMapping(value="/{studentId}",method=RequestMethod.GET)
	public String home(@PathVariable String studentId,ModelMap modelMap
			,HttpServletRequest req
			){
		//TODO 拦截器 确保登陆情况下访问
		Student student=studentDaoImpl.getStudentByStudentId(studentId);
		if(student.getStudentName()==null){
			return "Forbiden";
		}
		modelMap.put("student",student);
		req.setAttribute("student", student);
		return "studentHome";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String test(){
		return "html/stu_userCenter";
	}

}
