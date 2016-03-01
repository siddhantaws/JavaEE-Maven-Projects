package com.restfully.shop.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
@Provider
@PreMatching
public class HttpMethodOverride implements ContainerRequestFilter 
{

	@Override
	public void filter(ContainerRequestContext requestContext)throws IOException 
	{
		System.out.println("HttpMethodOverride");
		String methodname=requestContext.getHeaderString("X-Http-Method-Override");
		System.out.println("X-Http-Method-Override:"+methodname);
		if(methodname!=null)
			requestContext.setMethod(methodname);
	}

}
