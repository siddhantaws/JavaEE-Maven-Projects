package com.manh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(displayName="TestServlet",urlPatterns={"/sidd"},asyncSupported=false,loadOnStartup=1)
public class TestServlet extends HttpServlet
{
	private String listenerMessage=null;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("TestServlet>init");
		super.init(config);
		listenerMessage = (String)config.getServletContext().getAttribute("listenerMessage");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
	{
		req.getRequestDispatcher("/sidForward").forward(req, res);
	}
}
