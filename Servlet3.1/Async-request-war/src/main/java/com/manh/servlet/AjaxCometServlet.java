package com.manh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(asyncSupported=true,urlPatterns={"/"})
public class AjaxCometServlet extends HttpServlet 
{
    // Queue of AsyncContext objects, each of which represents a request/response pair that needs to be
    // handled asynchronously.
	private static Queue<AsyncContext> queue=new ConcurrentLinkedQueue<AsyncContext>();
	
	// Queue of messages, each of which needs to be delivered to all chat clients.
	private static BlockingDeque<String> messageQueue=new LinkedBlockingDeque<String>();
	
	private static final String BEGIN_SCRIPT_TAG = "<script type='text/javascript'>\n";
	
	private static final String END_SCRIPT_TAG = "</script>\n";
	
	private static final long serialVersionUID = -2919167206889576860L;
	
	private static final String JUNK = "<!-- Comet is a programming technique that enables web " + "servers to send data to the client without having any need " +"for the client to request it. -->\n";
	
	 private Thread notifierThread = null;
	 @Override
	public void init(ServletConfig config) throws ServletException 
	{
		// When this Runnable class gets started as a long running thread,
	    // it continuously extracts posted messages from the message queue
	    // and sends them to all clients participating in the chat.
	    //
	    // Each client is represented as a separate AsyncContext
	    // object in the Queue<AsyncContext> queue.  When a new
	    // client joined the chat (accessing the application for the
	    // first time through HTTP GET), a new AsynchContext object gets
	    // created and saved in the Queue<AsyncContext> queue.
		 Runnable notifiableThread=new Runnable() {
			@Override
			public void run() {
				 boolean done = false;
				 while (!done) 
				 {
	                    String cMessage = null;
	                    try {
	                    	// Take a message that has been posted
	                        cMessage = messageQueue.take();
	                        
	                        // For each chat client waiting for a newly
	                        // posted message, create and send a response
	                        // that contains the newly posted message.
	                        for (AsyncContext ac : queue) {
	                            try {
	                                PrintWriter acWriter = ac.getResponse().getWriter();
	                                acWriter.println(cMessage);
	                                acWriter.flush();
	                            } catch(IOException ex) {
	                                System.out.println(ex);
	                                queue.remove(ac);
	                            }
	                        }
	                    } catch(InterruptedException iex) {
	                        done = true;
	                        System.out.println(iex);
	                    }
	            }
			}
		};
		 // Start the thread as part of Servlet initialization
		notifierThread = new Thread(notifiableThread);
		notifierThread.start();
	}
	// The doGet(..) method gets invoked when a new chat client joins.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
	{
		 res.setContentType("text/html");
	     res.setHeader("Cache-Control", "private");
	     res.setHeader("Pragma", "no-cache");
	     PrintWriter writer = res.getWriter();
	     // for Safari, Chrome, IE and Opera
	     for (int i = 0; i < 10; i++) 
	     {
	            writer.write(JUNK);
	     }
	     writer.flush();
	     // When a new client joined the chat, a new AsyncContext
	     // object is created and saved in the Queue<AsyncContext> queue.
	     // The AsyncContext object will be removed only when asynch.
	     // task is completed or timed out.
	     final AsyncContext ac = req.startAsync();
	     ac.setTimeout(10  * 60 * 1000);
	     ac.addListener(new AsyncListener() 
	     {
	            public void onComplete(AsyncEvent event) throws IOException 
	            {
	                System.out.println("----onComplete() of asynch-request-war is called");
	                queue.remove(ac);
	            }

	            public void onTimeout(AsyncEvent event) throws IOException 
	            {
	                System.out.println("----onTimeout() of asynch-request-war is called");
	                queue.remove(ac);
	            }

	            public void onError(AsyncEvent event) throws IOException 
	            {
	                System.out.println("----onError() of asynch-request-war is called");
	                queue.remove(ac);
	            }

	            public void onStartAsync(AsyncEvent event) throws IOException 
	            {
	                System.out.println("----onStartAsync() of asynch-request-war is called");
	            }
	     });
	     queue.add(ac);
	}
	
	// The doPost(..) method gets invoked when login occurs or a new
    // message has been posted.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
	{
		res.setContentType("text/plain");
        res.setHeader("Cache-Control", "private");
        res.setHeader("Pragma", "no-cache");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        // When a login or message post request is received, call addMessageToQueue() method,
        // which saves the message in the message queue.
        // When a login or message post request is received, call addMessageToQueue() method,
        // which saves the message in the message queue.
        if ("login".equals(action)) 
        {
            String cMessage = BEGIN_SCRIPT_TAG + toJsonp("System Message", name + " has joined.") + END_SCRIPT_TAG;
            addMessageToQueue(cMessage);
            res.getWriter().println("success");
        } else if ("post".equals(action)) {
            String message = req.getParameter("message");
            String cMessage = BEGIN_SCRIPT_TAG + toJsonp(name, message) + END_SCRIPT_TAG;
            addMessageToQueue(cMessage);
            res.getWriter().println("success");
        } else {
            res.sendError(422, "Unprocessable Entity");
        }
	} 
	@Override
	public void destroy() 
	{
		queue.clear();
		notifierThread.interrupt();
	}
	private void addMessageToQueue(String cMessage) throws IOException 
	{
        try {
            messageQueue.put(cMessage);
        } catch(Exception ex) {
            IOException t = new IOException();
            t.initCause(ex);
            throw t;
        }
    }
	
	private String escape(String orig) 
	{
        StringBuffer buffer = new StringBuffer(orig.length());

        for (int i = 0; i < orig.length(); i++) {
            char c = orig.charAt(i);
            switch (c) {
            case '\b':
                buffer.append("\\b");
                break;
            case '\f':
                buffer.append("\\f");
                break;
            case '\n':
                buffer.append("<br />");
                break;
            case '\r':
                // ignore
                break;
            case '\t':
                buffer.append("\\t");
                break;
            case '\'':
                buffer.append("\\'");
                break;
            case '\"':
                buffer.append("\\\"");
                break;
            case '\\':
                buffer.append("\\\\");
                break;
            case '<':
                buffer.append("&lt;");
                break;
            case '>':
                buffer.append("&gt;");
                break;
            case '&':
                buffer.append("&amp;");
                break;
            default:
                buffer.append(c);
            }
        }

        return buffer.toString();
    }
	private String toJsonp(String name, String message) {
        return "window.parent.app.update({ name: \"" + escape(name) + "\", message: \"" + escape(message) + "\" });\n";
    }
}
