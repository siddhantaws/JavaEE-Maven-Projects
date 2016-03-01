package com.manh.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWorld 
{
	@WebMethod
	public String sayHello(String name) 
	{
        return "Hello " + name + "!";
    }
}
