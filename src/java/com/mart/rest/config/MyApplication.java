package com.mart.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.mart.rest.service.CustomerRestServices;
import com.mart.rest.service.MerchantRestServices;

@Component
public class MyApplication extends Application implements ApplicationContextAware{
	private static final Logger log = Logger.getLogger(MyApplication.class);
	private static Set<Object> singletons = new HashSet<Object>();
	private static CustomerRestServices cust;
	private static MerchantRestServices merch;

	public MyApplication(){
		singletons = new HashSet<Object>();
		singletons.add(cust);
		singletons.add(merch);
	}
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		cust = (CustomerRestServices) context.getBean("customerRestServices");
		merch = (MerchantRestServices) context.getBean("merchantRestServices");
	}

}
