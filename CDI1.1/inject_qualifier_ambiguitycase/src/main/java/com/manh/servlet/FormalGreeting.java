package com.manh.servlet;

public class FormalGreeting implements GreetingInterface {
    public String greet(String name){
        return "Formal Hello " + name;
    }
}
