package com.restfully.shop.services;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

@Path("/header")
public class HeaderResources 
{
	@GET
	@Path("/{id}")
	@Produces("text/html")
	public Response getHeaders(@HeaderParam("Reffer") String reffer,@PathParam("id") String id,@CookieParam("customerid") int customerid)
	{
		System.out.println(reffer+"\t"+customerid);
		return Response.status(Status.ACCEPTED).entity(reffer).cookie(new NewCookie("name", "siddhanta")).build();
	}
}
