/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.sapient.ejb;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Arun Gupta
 */
@Path("/")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyResource {
   
	@Inject @JMSConnectionFactory("java:/ConnectionFactory") private JMSContext context;
 
    @Resource(lookup = "java:/queue/JMSBridgeSourceQueue")
    private Queue queue;
    
    @Resource(lookup = "java:/topic/JMSBridgeSourceTopic")
    private Topic topic;
    
	
	@GET
	@Path("/queue")
    public void sendMessageToQueue() 
    {
		System.out.println("Entering the sendMessageToQueue");
		try {
			context.createProducer().send(queue, context.createTextMessage("Hello World ->sendMessageToQueue()"));
		} catch (Exception e) 
		{
			System.out.println(e);
		}
    }
	
	@GET
	@Path("/persiatenceQueue")
    public void sendMessageToPersiatenceQueue() 
    {
		System.out.println("Entering the sendMessageToPersiatenceQueue");
		try {
			Message message= context.createTextMessage("Hello World ->sendMessageToTopic()");
			message.setStringProperty("color", "yellow");
			context.createProducer().setDeliveryMode(DeliveryMode.PERSISTENT).send(queue, message);
		} catch (Exception e) 
		{
			System.out.println(e);
		}
    }
	
	
	@GET
	@Path("/topic")
    public void sendMessageToTopic() 
    {
		System.out.println("Entering the sendMessageToQueue");
		try {
			Message message= context.createTextMessage("Hello World ->sendMessageToTopic()");
			message.setStringProperty("color", "yellow");
			context.createProducer().send(topic, message);
		} catch (Exception e) 
		{
			System.out.println(e);
		}
    }
	
	@GET
	@Path("/durableTopic")
    public void sendMessageToDurableTopic() 
    {
		System.out.println("Entering the sendMessageToQueue");
		try {
			context.createProducer().send(topic, context.createTextMessage("Hello World ->sendMessageToTopic()"));
		} catch (Exception e) 
		{
			System.out.println(e);
		}
    }
}
