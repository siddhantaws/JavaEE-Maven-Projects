package com.manh.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echoServer")
public class EchoServer 
{
	@OnMessage
	public String echo(String incommingMessage)
	{
		return "I got this (" + incommingMessage + ")"+ " so I am sending it back !";
				
	}
}
