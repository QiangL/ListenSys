package com.ListenSys.Service;

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
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
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
		}
		response.sendRedirect("../../login");
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
