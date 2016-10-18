package com.ListenSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/regsiter")
public class RegisterController {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public String registerInit(){
		return "html/student/stu_regsiter.html";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String registerCheck(Student s,ModelMap modelMap){
		System.out.println(s);
		//TODO 数据验证 Model里放入错误信息
		//do something
		if(studentDaoImpl.addStudent(s)){
			return "success";
		}else{
			//TODO Model里放入错误信息
			modelMap.put("error","");
			return "redirect:register";
		}
	}
}
