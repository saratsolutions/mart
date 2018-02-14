package com.mart.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

@Path("/merchant")
@Controller
public class MerchantRestServices {

	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response dummy() {
		return Response.status(200).entity("sarat").build();
	}
	

}
