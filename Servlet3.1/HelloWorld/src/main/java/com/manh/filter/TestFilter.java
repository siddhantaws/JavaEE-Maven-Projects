package com.manh.filter;

import java.io.IOException;

import javax.jws.WebParam;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns={"/sidd"},
initParams={ @WebInitParam(name="mesg", value="my filter") },dispatcherTypes=DispatcherType.REQUEST)
public class TestFilter implements Filter
{
	String mesg = null;
	@Override
	public void init(FilterConfig fc) throws ServletException 
	{
		System.out.println("TestFilter>init");
		mesg=fc.getInitParameter("mesg");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain fc) throws IOException, ServletException 
	{
		System.out.println("TestFilter>doFilter");
		req.setAttribute("filterMessage", mesg);	
		fc.doFilter(req, res);
	}
	@Override
	public void destroy() 
	{
		System.out.println("TestFilter->destroy");
	}
}
