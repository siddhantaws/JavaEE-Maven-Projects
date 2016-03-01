package com.manh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(asyncSupported=true,loadOnStartup=1,urlPatterns={"/AsyncServlet"})
public class AsyncServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		AsyncContext asyncContext=req.startAsync(req, resp);
		
		ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(10);
		executor.execute(new AsyncRunnableDispatch(asyncContext));
		asyncContext.setTimeout(5000);
		asyncContext.addListener(new AsyncListener() {
			
			@Override
			public void onTimeout(AsyncEvent event) throws IOException 
			{
				 System.out.println("----onTimeout() is called");
			}
			
			@Override
			public void onStartAsync(AsyncEvent event) throws IOException
			{
				 System.out.println("----onStartAsync() is called");
			}
			
			@Override
			public void onError(AsyncEvent event) throws IOException 
			{
				 System.out.println("----onError() is called");
			}
			
			@Override
			public void onComplete(AsyncEvent event) throws IOException 
			{
				System.out.println("----onComplete() is called");
			}
		});
		resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Async. call is called and the task will be completed asynchronously. " +  "</h1>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }

	}
}
