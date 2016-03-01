package com.sapient.ejb.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Topic"),
		@ActivationConfigProperty(propertyName="destination",propertyValue="java:/topic/JMSBridgeSourceTopicOne")
})
public class ActiveMQTopicMDB implements MessageListener 
{

	@Override
	public void onMessage(Message message) 
	{
		
		System.out.println("Message Received From Topic :"+message.toString());
	}

}
