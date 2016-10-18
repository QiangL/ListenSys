package com.ListenSys.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherHomeController {
	@Autowired
	TeacherDaoImpl teacherDapImpl;
	
	@RequestMapping(value="/{teacherId}",method=RequestMethod.GET)
	public String home(@PathVariable String teacherId,ModelMap modelMap
			,HttpServletRequest req
			){
		//TODO 拦截器 是否是登陆状态访问这个网页
		Teacher teacher=teacherDapImpl.getTeacherByTeacherId(teacherId);
		if(teacher.getTeacherName()==null){
			return "Forbiden";
		}
		req.setAttribute("teacher", teacher);
		modelMap.put("teacher", teacher);
		return "teacherHome";
	}

}
