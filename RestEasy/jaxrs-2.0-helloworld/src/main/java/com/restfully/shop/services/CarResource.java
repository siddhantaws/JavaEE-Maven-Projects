package com.restfully.shop.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.restfully.shop.domain.Car;
import com.restfully.shop.domain.Days;

@Path("/cars")
public class CarResource 
{

	@GET
	@Path("{days}")
	public Response add(@PathParam("days") Days  c)
	{
		System.out.println("Date Type:"+c.getDate());
		return Response.ok(c.toString()).build();
	}
}
