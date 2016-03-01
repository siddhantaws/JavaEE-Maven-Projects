package com.restfully.shop.filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import com.restfully.shop.security.MySecurityContext;
import com.restfully.shop.security.User;

@Provider
@PreMatching
public class MyRequestFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException 
	{
		String autherization=requestContext.getHeaderString("Autherization");
		StringTokenizer stringTokenizer=new StringTokenizer(autherization,":");
		int i=0;
		String usename=null;
		String password;
		while(stringTokenizer.hasMoreTokens())
		{
			if(i==0)
			{
				usename=stringTokenizer.nextToken();
			}else {
				password=stringTokenizer.nextToken();
			}	
		}
		requestContext.setSecurityContext(new MySecurityContext(new User(usename)));
		System.out.println("In MyRequestFilter "+requestContext.getMethod());
	}

}
