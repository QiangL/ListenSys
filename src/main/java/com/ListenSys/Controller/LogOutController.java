package com.ListenSys.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogOutController {
	@RequestMapping(method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session.removeAttribute("roles");
		session.removeAttribute("teacher");
		session.removeAttribute("student");
		Cookie []cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				cookie.setMaxAge(0);
				cookie.setPath("/LinstenSys/");
				response.addCookie(cookie);
			}
		}
		return "redirect:login";
	}
	
}
