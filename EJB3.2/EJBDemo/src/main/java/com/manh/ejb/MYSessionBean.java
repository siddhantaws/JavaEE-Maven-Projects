package com.manh.ejb;

import javax.ejb.Stateless;

@Stateless
public class MYSessionBean implements MYRemoteBean,MYSessionLocal
{

	@Override
	public String sayHello(String hello) 
	{
		return "Hello "+hello;
	}

}
