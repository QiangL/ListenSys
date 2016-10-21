package com.ListenSys.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String LoginCheck(String userId,String password,String roles,ModelMap modelMap,HttpSession session,
			RedirectAttributes redirectAttributes,HttpServletResponse response){
		//TODO Model里要放进去出错信息，重定向需要错误提示
		StringBuilder sb=new StringBuilder();
		if(roles.equals("student")){
			Student student=studentDaoImpl.getStudentByStudentId(userId);
			if(student.getStudentId()==null){
				redirectAttributes.addFlashAttribute("error","指定学生不存在");
			}else if(!student.getStudentPwd().equals(password)){
				redirectAttributes.addFlashAttribute("error", "密码不正确");
			}else{
				sb.append("redirect:student/");
				sb.append(student.getStudentId());
				sb.append("/recordUpload");
				session.removeAttribute("teacher");//移除以前的老师登陆记录，学生的会覆盖掉
				session.setAttribute("student", student);
				Cookie cookie=new Cookie("student", student.getId()+"");
				cookie.setMaxAge(172800);
				cookie.setPath("/");
				response.addCookie(cookie);
				return sb.toString();
			}
		}else if(roles.equals("teacher")){
			Teacher teacher=teacherDaoImpl.getTeacherByTeacherId(userId);
			if(teacher.getTeacherId()==null){
				redirectAttributes.addFlashAttribute("error", "指定教师不存在");
			}else if(!teacher.getTeacherPwd().equals(password)){
				redirectAttributes.addFlashAttribute("error", "密码不正确");
			}else{
				sb.append("redirect:teacher/");
				sb.append(teacher.getTeacherId());
				sb.append("/folderList");
				session.removeAttribute("student");
				session.setAttribute("teacher", teacher);
				return sb.toString();
			}
		}
		return "redirect:login";
	}
}
