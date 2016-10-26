package com.ListenSys.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Teacher;

public class TeacherLoginCheck implements HandlerInterceptor{

	@Autowired
	TeacherDaoImpl teacherDaoImpl;
	
	/*
	 * 作为/teacher/路径的登陆验证
	 * 在关闭浏览器，session清除时通过cookie验证登陆，如果存在session，优先使用session验证
	 * teacher和student的session和cookie不会混用
	 * teacher和student的cookie同时存在时，会删除另一个
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		Cookie [] cookies=request.getCookies();
		String rolesId=null;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("teacher")){
					rolesId=cookie.getValue();
				}else if(cookie.getName().equals("student")){
					cookie.setMaxAge(0);
					cookie.setPath("/ListenSys/");
					response.addCookie(cookie);
				}
			}
		}
		HttpSession session=request.getSession();
		String roles=(String)session.getAttribute("roles");
		if(roles!=null){//只有一种情况return true，所以嵌套起来写
			if(roles.equals("teacher")){
				Teacher teacher=(Teacher)session.getAttribute("teacher");
				if(teacher!=null){
					String []path=request.getServletPath().split("/");
					if(path[2].equals(teacher.getTeacherId())){
						return true;
					}else {
						response.sendRedirect("../../html/common/forbiden.html");
						return false;
					}
				}
			}
		}else if(rolesId!=null){
			Teacher teacher=teacherDaoImpl.getTeacherById(Integer.parseInt(rolesId));
			session.setAttribute("teacher", teacher);
			session.setAttribute("roles", "teacher");
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
