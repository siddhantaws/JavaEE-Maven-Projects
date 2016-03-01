package com.manh.servlet;

import javax.ejb.Stateless;

@Stateless
public class GreetingSessionBean 
{
    public String greet(String name){
        return "Hello " + name;
    }
}
