package com.manh.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		System.out.println("TestServletContextListener>contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		System.out.println("TestServletContextListener>contextInitialized");
		ServletContext context = sce.getServletContext();
        context.setAttribute("listenerMessage", "my listener");
	}
	
}
