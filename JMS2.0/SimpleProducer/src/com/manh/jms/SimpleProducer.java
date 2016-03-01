package com.manh.jms;

import java.util.Enumeration;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQSslConnectionFactory;

public class SimpleProducer
{
	public static void main(String[] args)
	{
		//setSSLProperty();
		Context  context= getInitialContext();
		try {
			ConnectionFactory connectionFactory=(ConnectionFactory)context.lookup("ConnectionFactory");
			QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory)connectionFactory;
			QueueConnection connection = queueConnectionFactory.createQueueConnection();
			QueueSession session = (QueueSession) connection.createSession(false	, Session.AUTO_ACKNOWLEDGE);
			Queue queue=getQueue(session);
			QueueSender queueSender= (QueueSender)session.createSender(queue);
			queueSender.send(session.createTextMessage("Hello World"));
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
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
		properties.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactor");
		properties.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
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
			queue =(Queue)session.createQueue("activemq/queue/TestQueue");
		} catch ( JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queue; 
	}

}
