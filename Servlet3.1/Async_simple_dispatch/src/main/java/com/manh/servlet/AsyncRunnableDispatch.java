package com.manh.servlet;

import javax.servlet.AsyncContext;

public class AsyncRunnableDispatch implements Runnable 
{
	AsyncContext context;
	
	public AsyncRunnableDispatch(AsyncContext context) 
	{
		super();
		this.context = context;
	}

	@Override
	public void run() 
	{
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.dispatch("/response.jsp");
	}

}
