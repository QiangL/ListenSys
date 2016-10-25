package com.ListenSys.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;

public class StudentLoginCheck implements HandlerInterceptor{
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	/*
	 * 作为/student/路径的登陆验证
	 * 在关闭浏览器，session清除时通过cookie验证登陆，如果存在session，优先使用session验证
	 * teacher和student的session和cookie不会混用
	 * teacher和student的cookie同时存在时，会删除另一个
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object studentId) throws Exception {
		String rolesId=null;
		Cookie [] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie :cookies){
				if(cookie.getName().equals("student")){
					rolesId=cookie.getValue();
				}else if(cookie.getName().equals("teacher")){
					cookie.setMaxAge(0);
					cookie.setPath("/ListenSys/");
					response.addCookie(cookie);
				}
			}
		}
		HttpSession session=request.getSession();
		String sessionRoles=(String)session.getAttribute("roles");
		if(sessionRoles!=null){//只有一种情况return true，所以嵌套起来写
			if(sessionRoles.equals("student")){
				Student student=(Student)session.getAttribute("student");
				if(student!=null){
					String [] paths=request.getServletPath().split("/");
					if(paths[2].equals(student.getStudentId())){
						return true;
					}else{
						response.sendRedirect("../../html/common/forbiden.html");
						return false;
					}
				}
			}
		}else if(rolesId!=null){
			Student student=studentDaoImpl.getStudentById(Integer.parseInt(rolesId));
			session.setAttribute("student", student);
			return true;
		}
		response.sendRedirect("../../login");
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

}
