package com.sapient.ejb.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig={
			@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
			@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/topic/JMSBridgeSourceTopicOne"),
	        @ActivationConfigProperty(propertyName="subscriptionDurability",propertyValue="Durable"),
	        @ActivationConfigProperty(propertyName="clientId",propertyValue="myClientId"),
	        @ActivationConfigProperty(propertyName="subscriptionName",propertyValue="mySubscription")
})
public class ActiveMQDurableTopicMDB implements MessageListener
{

	@Override
	public void onMessage(Message message)
	{
		try {
			if(!message.getJMSRedelivered())
			{
				System.out.println("Message received from Durable Topic "+message.toString());
				message.getIntProperty("JMSXDeliveryCount");
			}
				
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
	}
	
}
