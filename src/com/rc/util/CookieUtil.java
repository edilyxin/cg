package com.rc.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 


public class CookieUtil {
	
	public static final String COOKIE_KEY = "username";
	
	/**
	 * 判断cookie值是否存在，如果不存在返回null
	 */
	public static Cookie isCookieExist(String name, HttpServletRequest request){
		Cookie[] cookieList = request.getCookies();
		//firefox浏览时如果cookie不存在返回null而不是空数组
		if(cookieList != null){
			for(Cookie cookie : cookieList){
				if(cookie.getName().equals(name)){
					return cookie;
				}
			}
		}
		return null;
	}
	
	/**
	 * 移除Cookie
	 */
	public static void removeCookie(String name, HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookieList = request.getCookies();
		//firefox浏览时如果cookie不存在返回null而不是空数组
		if(cookieList != null){
			for(Cookie cookie : cookieList){
				if(cookie.getName().equals(name)){
					cookie.setMaxAge(0);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
				}
			}
		}
	}
	
	/**
	 * 验证cookie中的用户名和密码，如果验证成功返回用户名、否则返回null
	 */
//	public static String validateCookieLoginIdAndPassword(Cookie cookie){
//		 UserInfoService userInfoService = new UserInfoServiceImpl();
//		String cookieStr = cookie.getValue();
//		
//		if(cookieStr != null){
//			String[] values = cookieStr.split(",");
//			if(values.length == 2){
//				UserForm userform = new UserForm();
//				userform.setUs_sLoginName(values[0]);
//				userform.setUs_sLoginPwd(values[1]);
//				boolean flag = userInfoService.findUser(userform);
//				if(flag == true){
//					return values[0];
//				}
//			}
//		}
//		
//		return null;
//	}
}
