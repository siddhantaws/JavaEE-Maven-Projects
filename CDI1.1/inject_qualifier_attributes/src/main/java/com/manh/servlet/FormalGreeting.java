package com.manh.servlet;

import com.manh.annotation.VariousGreetings;
import com.manh.enm.GreetingType;

@VariousGreetings(type=GreetingType.FORMAL)
public class FormalGreeting implements GreetingInterface 
{
    public String greet(String name){
        return "Formal Hello " + name;
    }
}
