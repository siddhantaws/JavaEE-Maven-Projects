package com.manh.jsf2;


import javax.faces.bean.ManagedBean;

@ManagedBean(name="my_hello")

public class Hello {
    private String world = "Hello World!";
    public  Hello(){
    	System.out.println("siddhanta");
    }
    public String getworld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }
}
