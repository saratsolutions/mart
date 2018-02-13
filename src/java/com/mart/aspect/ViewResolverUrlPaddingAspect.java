package com.mart.aspect;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
public class ViewResolverUrlPaddingAspect {
	private Logger log = Logger.getLogger(ViewResolverUrlPaddingAspect.class);

	@AfterReturning(pointcut = "execution(* com.mart.controller.*Controller.*(..))", returning = "result")
	public void adminUrlPadding(JoinPoint joinPoint, Object result) {
		log.info("In Appender : " + joinPoint.toShortString());
		String apender = "";
		if (joinPoint.toShortString().toString().toLowerCase().contains(
				"merchant")) {
			apender = "merchant/";
		} else if (joinPoint.toShortString().toString().toLowerCase().contains(
				"admin")) {
			apender = "admin/";
		}
		if (result instanceof ModelAndView) {
			((ModelAndView) result).setViewName(apender + "/"
					+ ((ModelAndView) result).getViewName());
		} else if (result instanceof String) {
			result = apender + result;
		}
	}

}