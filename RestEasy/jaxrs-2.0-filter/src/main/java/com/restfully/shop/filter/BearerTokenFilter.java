package com.restfully.shop.filter;

import java.io.IOException;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
@Provider
@PreMatching
public class BearerTokenFilter implements ContainerRequestFilter
{

	@Override
	public void filter(ContainerRequestContext requestContext)throws IOException 
	{
		System.out.println("BearerTokenFilter");
		String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authHeader == null) throw new NotAuthorizedException("Bearer");
	}

}
