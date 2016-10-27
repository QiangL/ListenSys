package com.ListenSys.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	/**
	 * 得到一个Cookie数组中一个Cookie的value
	 * @param cookieName 需要得到的Cookie的名字
	 * @param cookies 一个Cookie数组
	 * @return 需要的Cookie的值
	 */
	public static String getCookieValue(String cookieName,Cookie []cookies){
		String cookieValue=null;
		for(Cookie c:cookies){
			if(c.getName().equals("cookieName")){
				cookieValue=c.getValue();
			}
		}
		return cookieValue;
	}
	/**
	 * 移除特定的Cookie
	 * @param cookieName 需要移除的Cookie的名字
	 * @param cookies 需要筛选的Cookie数组
	 * @param response 为了移除Cookie需要一个respose
	 */
	public static void removeCookie(String cookieName,Cookie[]cookies,HttpServletResponse response){
		for(Cookie c:cookies){
			if(c.getName().equals("cookieName")){
				c.setMaxAge(0);
				c.setPath("/ListenSys/");
				response.addCookie(c);
			}
		}
	}

}
