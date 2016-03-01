package com.manh.servlet;

import com.manh.annotation.Formal;

@Formal
public class FormalGreeting implements GreetingInterface 
{
    public String greet(String name){
        return "Formal Hello " + name;
    }
}
