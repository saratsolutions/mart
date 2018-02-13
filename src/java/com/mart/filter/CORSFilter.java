package com.mart.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mart.aspect.ViewResolverUrlPaddingAspect;

public class CORSFilter implements Filter {
	private Logger log = Logger.getLogger(CORSFilter.class);
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// log.info("Request: " + request.getMethod());

		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "GET,POST");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");

		log.info("in filter : " + request.getRequestURI()
				+ "\nauth header:" + request.getHeader("auth") + "\nip:"
				+ request.getRemoteHost());
/*
 * 
 * 
 
		// here new user came
		if (request.getRequestURI().equalsIgnoreCase("/ExamExpertz/")) {
			String plaintext = request.getRemoteHost() + "#G#" + new Date();
			log.info("new User Request :set plainText:" + plaintext);
			String key = trippleDes.encrypt(plaintext);
			log.info("new User Request :set cypherText" + key);

			cache.put(request.getRemoteHost() + "#G", key);
			resp.addHeader("auth", key);
			log.info("in cache :: key:"
					+ (request.getRemoteHost() + "#G") + "  ::value :" + key);
		} else {
			try {
				log.info("gvk :"
						+ request.getHeader("auth").split(",")[0]);
				String givenKey = trippleDes.decrypt(request.getHeader("auth")
						.split(",")[0]);
				log.info("given Key1 : " + givenKey);
				String[] tokens = givenKey.split("#");
				String ip = tokens[0];
				String user = tokens[1];
				String date = tokens[2];
				
				givenKey = ip+"#"+user;
				
				log.info("given Key : " + givenKey);
				if (cache.contains(givenKey)&&cache.get(givenKey).equalsIgnoreCase(request.getHeader("auth").split(",")[0])) {
					Date d = new Date();
					log.info("new key ::"+givenKey+"#"+ d);
					String key = trippleDes.encrypt(givenKey+"#"+ d);
					log.info("after encryption:newkey:"+key);
					cache.put(request.getRemoteHost() + "#G", key);
					resp.addHeader("auth", key);
				} else {
					log.info("invalid Key:: \noldkey:"+cache.get(givenKey)+"\nNew Key:"+request.getHeader("auth").split("auth")[0]);
					cache.remove(givenKey);
					throw new ServletException("Invalid Key");
				}
			} catch (Exception e) {
				log.info("Exception::"+e.getMessage());
				throw new ServletException("Invalid Key");
			}

		}
 * 
 * */

		// Just ACCEPT and REPLY OK if OPTIONS
		if (request.getMethod().equals("OPTIONS")) {
			resp.setStatus(HttpServletResponse.SC_OK);
			return;
		}
		chain.doFilter(request, servletResponse);
	}

	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}