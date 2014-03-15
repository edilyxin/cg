package com.rc.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;   
		  HttpServletResponse response = (HttpServletResponse) arg1;   
		   
		  String requestedWith = request.getHeader("x-requested-with");
		  String type = request.getContentType();   
		  if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)   
		  && null != type   
		  && ("application/x-www-form-urlencoded".equals(type)||"application/x-www-form-urlencoded; charset=GBK".equals(type))) {   
		    
		  request.setCharacterEncoding("UTF-8");   
		  response.setCharacterEncoding("UTF-8");   
		  request.getParameterMap();   
		  } 
		  arg2.doFilter(request, response);   

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
