package com.manh.ejb;

import javax.ejb.Local;

@Local
public interface MYSessionLocal 
{
	public String sayHello(String hello);
}
