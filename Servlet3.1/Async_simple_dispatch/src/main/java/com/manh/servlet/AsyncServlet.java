package com.manh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(asyncSupported=true,loadOnStartup=1,urlPatterns={"/AsyncServlet"})
public class AsyncServlet extends HttpServlet 
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException , IOException 
	{
		
		AsyncContext asyncContext=req.startAsync(req, resp);
		ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(10);
		executor.execute(new AsyncRunnableDispatch(asyncContext));
	}
}
