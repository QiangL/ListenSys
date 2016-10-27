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
		if(roles.equals("student")){
			Student student=studentDaoImpl.getStudentByStudentId(userId);
			if(student.getStudentId()==null){
				redirectAttributes.addFlashAttribute("error","指定学生不存在");
			}else if(!student.getStudentPwd().equals(password)){
				redirectAttributes.addFlashAttribute("error", "密码不正确");
			}else{
				return directStudentPath(student,session,response);
			}
		}else if(roles.equals("teacher")){
			Teacher teacher=teacherDaoImpl.getTeacherByTeacherId(userId);
			if(teacher.getTeacherId()==null){
				redirectAttributes.addFlashAttribute("error", "指定教师不存在");
			}else if(!teacher.getTeacherPwd().equals(password)){
				redirectAttributes.addFlashAttribute("error", "密码不正确");
			}else{
				return directTeacherPath(teacher, session, response);
			}
		}
		return "redirect:login";
	}
	/**
	 * 封装增加Cookie的操作
	 * 默认设置时间为172800秒（2天）,路径为/ListenSys/
	 * @return 设置好的Cookie
	 */
	private Cookie addCookie(String name,String value){
		Cookie cookie=new Cookie(name,value);
		cookie.setMaxAge(172800);
		cookie.setPath("/ListenSys/");
		return cookie;
	}
	/**
	 * 封装跳转到Student/下目录的操作
	 * 包括session设置，cookie设置
	 * @return 要跳转的student/{id}/recordUpload 地址
	 */
	private String directStudentPath(Student student,HttpSession session,HttpServletResponse response){
		StringBuilder sb=new StringBuilder();
		session.removeAttribute("teacher");//移除以前的老师登陆记录，学生的会覆盖掉
		session.setAttribute("student", student);
		session.setAttribute("roles", "student");
		
		response.addCookie(addCookie("student",student.getId()+""));
		
		sb.append("redirect:student/");
		sb.append(student.getStudentId());
		sb.append("/recordUpload");
		return sb.toString();
	}
	/**
	 * 封装跳转到teacher/下目录的操作
	 * 包括session设置，cookie设置
	 * @return 要跳转的teacher/{id}/folderList 地址
	 */
	private String directTeacherPath(Teacher teacher,HttpSession session,HttpServletResponse response){
		StringBuilder sb=new StringBuilder();
		session.removeAttribute("student");
		session.setAttribute("teacher", teacher);
		session.setAttribute("roles", "teacher");
		
		response.addCookie(addCookie("teacher", teacher.getId()+""));
		
		sb.append("redirect:teacher/");
		sb.append(teacher.getTeacherId());
		sb.append("/folderList");
		return sb.toString();
	}
}
