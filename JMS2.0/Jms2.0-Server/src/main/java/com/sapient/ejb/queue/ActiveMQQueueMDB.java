package com.sapient.ejb.queue;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import javax.ejb.ActivationConfigProperty;

@MessageDriven(activationConfig = {
	
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
 
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/JMSBridgeSourceQueueOne") ,
        @ActivationConfigProperty(propertyName = "messageSelector",propertyValue = "color= 'red'")})
 
public class ActiveMQQueueMDB implements MessageListener 
{

	public void onMessage(Message message) 
	{
		System.out.println("Message Received from JMSBridgeSourceQueueOne"+message.toString());
	}

}
