package com.mart.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mart.controller.AdminController;
import com.mart.model.Customer;
import com.mart.rest.exception.MartServiceException;
import com.mart.service.UserService;

@Path("/customer")
@Controller
public class CustomerRestServices {
	@Autowired
	private UserService userService;
	private static final Logger log = Logger.getLogger(CustomerRestServices.class);

	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response customerLogin(Customer customer) {
		Object result = null;
		log.info(customer);
		result = userService.save(customer);
		return Response.status(200).entity(result).build();
	}

}
