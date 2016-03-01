package com.manh.helloworld;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.restfully.shop.domain.Customer;

public class HelloWorldClient
{
	public static void main(String[] args) 
	{
		Client client=ClientBuilder.newClient();
		//POST request
		/*WebTarget target=client.target("http://localhost:8080/jaxrs-2.0-response-exception/services/customers");
		Response response=target.request().post(Entity.xml(new Customer(1,	 "Siddhanta", "Pattnaik", "4thcross", "Bangalore", "Karnataka", "560037", "India")));
		System.out.println(response.getHeaderString("Location"));
		response.close();*/
		//GET
		WebTarget targetGet=client.target("http://localhost:8080/jaxrs-2.0-response-exception/services/customers/1");
		String responseGet= targetGet.request(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(responseGet);
		/*WebTarget targetGetOne=client.target("http://localhost:8080/jaxrs-2.0-helloworld/services/customers/1");
		//targetGetOne.path("/1");//.resolveTemplate("id", 1);
		System.out.println(targetGetOne.request(MediaType.APPLICATION_JSON).get(String.class));;*/
	}
}
