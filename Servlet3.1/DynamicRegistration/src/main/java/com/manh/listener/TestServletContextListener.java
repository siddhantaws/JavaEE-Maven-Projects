package com.manh.listener;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
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
        ServletRegistration registration=context.addServlet("TestServlet", "com.manh.servlet.TestServlet");
        registration.setInitParameter("servletInitName", "servletInitValue");
        registration.addMapping("/sidd");
        FilterRegistration filterRegistration=context.addFilter("TestFilter", "com.manh.filter.TestFilter");
        filterRegistration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "TestServlet");
        filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/sidd");
        filterRegistration.setInitParameter("filterInitName", "filterInitValue");
        context.addListener("com.manh.listener.TestServletRequestListener");
		context.setAttribute("listenerMessage", "my listener");
	}
	
}
