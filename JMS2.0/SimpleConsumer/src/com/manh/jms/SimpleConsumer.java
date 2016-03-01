package com.manh.jms;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SimpleConsumer 
{
	public static void main(String[] args) 
	{
		Context context=getInitialContext();
		ConnectionFactory connectionFactory=getConnectionFactory(context);
		QueueConnection connection;
		try {
			connection = ((QueueConnectionFactory) connectionFactory).createQueueConnection();
			QueueSession session = (QueueSession) connection.createSession(false	, Session.AUTO_ACKNOWLEDGE);
			Queue queue=getQueue(session);
			QueueReceiver queueReceiver = (QueueReceiver)session.createReceiver(queue);
			queueReceiver.setMessageListener((message)->{System.out.println(message);});
			connection.setExceptionListener((exeption)->{System.err.println(exeption.getMessage());});
			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
	}
	
	private static ConnectionFactory getConnectionFactory(Context  context)
	{
		ConnectionFactory connectionFactory=null;
		try {
				connectionFactory=(ConnectionFactory)context.lookup("ConnectionFactory");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connectionFactory;
	}
	
	
	private static  Context getInitialContext()
	{
		Context  context=null;
		Properties properties=new Properties();
		properties.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		properties.put("java.naming.provider.url", "ssl://localhost:61617");
		properties.put("java.naming.security.principal", "admin");
		properties.put("java.naming.security.credentials", "admin");
		try {
			  context=new InitialContext(properties);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return context;
	}
	public static Queue getQueue(Session  session)
	{
		Queue queue=null;
		try {
			queue =(Queue)session.createQueue("Test.Foo");
		} catch ( JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queue; 
	}
}
