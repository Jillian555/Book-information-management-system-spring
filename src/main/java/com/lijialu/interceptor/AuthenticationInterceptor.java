package com.lijialu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import edu.abc.pojo.User;

public class AuthenticationInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("杩欐槸鎵цpreHandle鏂规硶");
		System.out.println("preHandle涓殑handler鏄�"+handler.getClass());
		HttpSession se=  request.getSession();
		Object obj= se.getAttribute("OnlineUser");
		if(obj!=null) {
			return true;
		}
		response.sendRedirect("/WebDemo0912/log");
		return false;
	}

	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,ModelAndView modelAndView) 
			throws Exception {
		System.out.println("杩欐槸鎵цpostHandle鏂规硶");		
	}

	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("杩欐槸鎵цafterCompletion鏂规硶");
	}

}
