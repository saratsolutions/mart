package com.mart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HomeServlet extends HttpServlet {
	private Logger log = Logger.getLogger(HomeServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.info("landed  "+req.getRequestURI());
		if(!req.getRequestURI().contains(".png"))
		req.getRequestDispatcher("/index.htm").forward(req,resp);
	}

}
