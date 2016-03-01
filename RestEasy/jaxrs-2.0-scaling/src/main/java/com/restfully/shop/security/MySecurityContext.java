package com.restfully.shop.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class MySecurityContext implements SecurityContext {

	private User user;
	
	public MySecurityContext(User user)
	{
		this.user=user;
	}
	
	@Override
	public Principal getUserPrincipal() {
		return user;
	}

	@Override
	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return role.contains("SIDD_ROLE");
	}

	@Override
	public boolean isSecure() 
	{
		return false;
	}

	@Override
	public String getAuthenticationScheme() 
	{
		return SecurityContext.BASIC_AUTH;
	}

}
