package com.manh.jms.topic;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DurableTopic 
{
	public static void main(String[] args)
	{
		//setSSLProperty();
		Context  context= getInitialContext();
		try {
			ConnectionFactory connectionFactory=getConnectionFactory(context);
			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory)connectionFactory;
			TopicConnection connection = topicConnectionFactory.createTopicConnection();
			TopicSession session = (TopicSession) connection.createSession(false	, Session.AUTO_ACKNOWLEDGE);
			Topic topic=getTopic(session);
			TopicPublisher topicPublisher= (TopicPublisher)session.createPublisher(topic);
			topicPublisher.publish(session.createTextMessage("Hello My Topic "));
		} catch (JMSException e) {
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
		properties.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
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
	public static Topic getTopic(Session  session)
	{
		Topic topic=null;
		try {
			topic =(Topic)session.createTopic("activemq/topic/TestTopicOne");
		} catch ( JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return topic; 
	}
}
