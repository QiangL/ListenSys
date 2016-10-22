package com.ListenSys.Service;

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
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object studentId) throws Exception {
		HttpSession session=request.getSession();
		String roles=(String)session.getAttribute("roles");
		if(roles!=null){//只有一种情况return true，所以嵌套起来写
			if(roles.equals("student")){
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
