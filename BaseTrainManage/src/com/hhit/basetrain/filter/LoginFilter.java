/**
 * 
 */
package com.hhit.basetrain.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jiya
 * @date 2016-5-27t上午08:38:23
 * 登录过滤
 */
public class LoginFilter implements Filter{

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setContentType("text/html");
		String currentUrl = request.getRequestURI();
		System.out.println(currentUrl);
		String username = "";
		boolean flag = false;
		
		if(currentUrl.indexOf("index.jsp")>-1 || currentUrl.equalsIgnoreCase("/BaseTrainManage/")
				||
				currentUrl.equalsIgnoreCase("/BaseTrainManage")){//是不是首页
			flag = true;
			
		}else{
			Cookie[] cookies = request.getCookies();
			System.out.println(cookies.length);
			for(int i = 0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equalsIgnoreCase("username")){
					username = cookie.getValue();
				}
			}
		}
		
		
		if(!flag && (username == "" || username == null)){
			response.sendRedirect("/BaseTrainManage/index.jsp");
		}
		chain.doFilter(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
