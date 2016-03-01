package com.manh.async.callback;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

public class CustomCallback implements InvocationCallback<Response> 
{

	@Override
	public void completed(Response response) 
	{
		if(response.getStatus()==200)
			System.out.println("returned objects "+response.readEntity(String.class));
	}

	@Override
	public void failed(Throwable throwable) 
	{
		System.out.println(throwable.getMessage());
	}
	
}
