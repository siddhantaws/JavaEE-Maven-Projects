/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jersy2;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Suryasnata
 */
@Path("greetings")
public class GreetingsResources {
    @GET
    public JsonObject greetings()
    {
        System.out.print("name");
        return Json.createObjectBuilder().add("Hello", "world").build();
    }
    @GET
    @Path("{first}-{last}")
    public String getGreetings(@PathParam("first")String first,@PathParam("last")String last)
    {
        return first+"----"+last;
    }
}
