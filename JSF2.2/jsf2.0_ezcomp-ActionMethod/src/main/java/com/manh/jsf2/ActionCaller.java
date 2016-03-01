package com.manh.jsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="actionBean")
@RequestScoped
public class ActionCaller  {

    public String myaction(){
        System.out.println("-----myaction() called");
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getRequestMap().put("myactionCalled",
                Boolean.TRUE.toString());
        return "home";
    }

}