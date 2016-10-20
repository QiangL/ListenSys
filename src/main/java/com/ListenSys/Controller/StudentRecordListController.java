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
import com.ListenSys.Entity.Sound;
import com.ListenSys.Entity.Student;

@Controller
@RequestMapping("/student/{studentId}/recordList")
public class StudentRecordListController {
	@Autowired
	SoundDaoImpl soundDaoImpl;

	//录音记录的控制器
	@RequestMapping(method=RequestMethod.GET)
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
}
