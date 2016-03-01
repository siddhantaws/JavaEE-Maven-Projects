/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jersy2;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Suryasnata
 */
@Path("/users")
public class HelloResources 
{
    @POST
    @Consumes("multipart/form-data")
    public Response addUsers(@FormParam("name")String name,@FormParam("age")int age)
    {
        String output=name+"-----"+age;
        System.out.println(output);
        return Response.status(Response.Status.CREATED).entity(output).build();
    }
}
