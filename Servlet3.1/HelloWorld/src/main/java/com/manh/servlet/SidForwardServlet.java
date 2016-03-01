package com.manh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(displayName="sidForward",urlPatterns={"/sidForward"},asyncSupported=false,loadOnStartup=1,name="sidForward")
public class SidForwardServlet extends HttpServlet
{
	private String listenerMessage=null;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("SidForwardServlet>init");
		super.init(config);
		listenerMessage = (String)config.getServletContext().getAttribute("listenerMessage");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
	{
		 PrintWriter writer = res.getWriter();
	     writer.write("Hello, " + getInitParameter("message") + ", ");
	     writer.write(req.getAttribute("filterMessage") + ", ");
	     writer.write(listenerMessage + ".\n");
	}
}
