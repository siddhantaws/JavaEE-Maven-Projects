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


public class TestFilter implements Filter
{
	  private String filterInitParam;

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException 
	    {
	        filterInitParam = filterConfig.getInitParameter("filterInitName");
	    }   

	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException 
	    {
	        req.setAttribute("filterInitName", filterInitParam);
	        chain.doFilter(req, res);
	    }

	    @Override
	    public void destroy() 
	    {
	        // Do nothing
	    }
}
