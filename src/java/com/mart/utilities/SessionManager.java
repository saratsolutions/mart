package com.mart.utilities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionManager implements HttpSessionListener{
	public static Map<HttpSession,String> dataMap = new ConcurrentHashMap<HttpSession,String>();
	public static Map<HttpSession,String> userRoles = new ConcurrentHashMap<HttpSession,String>();
	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		dataMap.remove(se.getSession());
		userRoles.remove(se.getSession());
	}

}
