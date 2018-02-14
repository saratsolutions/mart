package com.mart.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mart.utilities.SessionManager;

public class SessionManagementFilter implements Filter {
	private Logger log = Logger.getLogger(SessionManagementFilter.class);
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("session filter : starting");
		boolean flag = true;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		if(request.getRequestURI().contains("admin/")){
			if(SessionManager.userRoles.get(request.getSession())==null || !SessionManager.userRoles.get(request.getSession()).equalsIgnoreCase("ADMIN")){
				flag = false;
				((HttpServletResponse)(servletResponse)).sendRedirect(request.getContextPath()+"/index.htm");
			}
		}else if(request.getRequestURI().contains("merchant/")){
			if(SessionManager.userRoles.get(request.getSession())==null || !SessionManager.userRoles.get(request.getSession()).equalsIgnoreCase("MERCHANT")){
				flag = false;
				((HttpServletResponse)(servletResponse)).sendRedirect(request.getContextPath()+"/index.htm");
			}
		}
		System.out.println("session filter : ending");
		if(flag)
		chain.doFilter(request, servletResponse);
	}

	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}