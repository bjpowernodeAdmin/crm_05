package com.bjpowernode.crm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crm.settings.domain.User;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("验证是否已经登录的过滤器");
		
		/*
		 * 从request中取session
		 * 从session中取user
		 * 
		 * 判断user是否为null
		 * 
		 * 	如果user不为null，说明已经登录过，将请求放行
		 * 
		 *  如果user为null，说明没有登录国，重定向到登录页
		 * 
		 */
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//应该将登录页和验证登录的请求自动放行
		String path = request.getServletPath();
		if("/login.jsp".equals(path) || "/settings/user/login.do".equals(path)){
			
			chain.doFilter(req, resp);
			
		//其他请求，正常判断有没有登录过	
		}else{
			
			User user = (User)request.getSession().getAttribute("user");
			
			//如果user不为null，说明已经登录过，将请求放行
			if(user!=null){
				
				chain.doFilter(req, resp);
			
			//如果user为null，说明没有登录国，重定向到登录页	
			}else{
				
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				
			}
			
		}
		
		
		
		
	}

}















































