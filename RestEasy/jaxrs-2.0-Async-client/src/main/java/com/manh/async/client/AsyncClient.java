package com.manh.async.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.manh.async.callback.CustomCallback;

public class AsyncClient
{
	public static void main(String[] args) 
	{
		Client client=ClientBuilder.newClient();
		/*Future<String> future=client.target("http://localhost:8081/jaxrs-2.0-helloworld/services/cars/BMW").request().async().get(String.class);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Future<Response> future=client.target("http://localhost:8081/jaxrs-2.0-helloworld/services/cars/BMW").request().async().get(new CustomCallback());
		try {
			future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
