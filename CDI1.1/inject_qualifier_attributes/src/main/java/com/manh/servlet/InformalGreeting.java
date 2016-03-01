package com.manh.servlet;

import com.manh.annotation.VariousGreetings;
import com.manh.enm.GreetingType;

@VariousGreetings(type=GreetingType.INFORMAL)
public class InformalGreeting implements GreetingInterface {
    public String greet(String name){
        return "Informal Hello " + name;
    }
}
