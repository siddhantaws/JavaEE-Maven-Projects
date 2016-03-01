package com.restfully.shop.services;

import com.restfully.shop.domain.Customer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/variantCustomers")
public class VariantCustomerResource
{
   private Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
   private AtomicInteger idCounter = new AtomicInteger();
   private List<Variant> variants=new ArrayList<Variant>();
   public VariantCustomerResource()
   {
	   variants.add(new Variant(MediaType.APPLICATION_JSON_TYPE,"en", "deflate"));
	   variants.add(new Variant(MediaType.APPLICATION_JSON_TYPE,"es", "deflate"));
	   variants.add(new Variant(MediaType.APPLICATION_XML_TYPE,"en", "deflate"));
	   variants.add(new Variant(MediaType.APPLICATION_XML_TYPE,"es", "deflate"));
   }

   @POST
   @Consumes("application/xml")
   public Response createCustomer(Customer customer)
   {
      customer.setId(idCounter.incrementAndGet());
      customerDB.put(customer.getId(), customer);
      System.out.println("Created customer " + customer.getId());
      return Response.created(URI.create("/customers/" + customer.getId())).build();

   }

   @GET
   @Path("{id}")
   public Response getCustomer(@Context Request request,@PathParam("id") int id)
   {
	   Variant variant=request.selectVariant(variants);
	   Customer customer = customerDB.get(id);
	   if(variant.getMediaType().equals(MediaType.APPLICATION_JSON_TYPE))
	   {
		   System.out.println("MediaType.APPLICATION_JSON_TYPE"+variant.getEncoding()+"\t"+variant.getMediaType()+"\t"+variant.getLanguage());
		   return  Response.ok(customer).type(variant.getMediaType()).language(variant.getLanguage()).header("Content-Encoding", variant.getEncoding()).build();
	   }else{
		   System.out.println(variant.getEncoding()+"\t"+variant.getMediaType()+"\t"+variant.getLanguage());
		   return  Response.ok(customer).type(variant.getMediaType()).language(variant.getLanguage()).header("Content-Encoding", variant.getEncoding()).build();
	   }
   }

}
