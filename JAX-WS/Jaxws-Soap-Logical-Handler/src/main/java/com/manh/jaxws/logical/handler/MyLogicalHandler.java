/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jaxws.logical.handler;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author michgan
 */
public class MyLogicalHandler implements LogicalHandler<LogicalMessageContext> {

    private String handlerName = "MyLogicalHandler";

    public boolean handleMessage(LogicalMessageContext messageContext) {
        // LogicalMessage msg = messageContext.getMessage();
        boolean direction = ((Boolean) messageContext.get(
                LogicalMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue();
        if (direction) {
            System.out.println("--------direction = outbound");
        } else {
            System.out.println("--------direction = inbound");
        }

        dumpMsg(messageContext);

        return true;
    }

    public boolean handleFault(LogicalMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

    public void dumpMsg(MessageContext context) {

        try {
            LogicalMessage lm = ((LogicalMessageContext) context).getMessage();
            if (lm != null) {
                Source source = lm.getPayload();
                // The Source is in the DOM object so you need to transform into
                // String object by calling getSourceAsString(source))
                if (source != null) {
                    System.out.println("----MSG=" + source); // Testing
                    System.out.println("----MSG=" + getSourceAsString(source));
                } else {
                    System.out.println("----No message payload was present");
                }
            } else {
                System.out.println("----No message was present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return;
    }

    public String getSourceAsString(Source s) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        OutputStream out = new ByteArrayOutputStream();
        // StreamResult object acts as an holder for a transformation result, which
        // may be XML, plain Text, HTML, or some other form of markup
        StreamResult streamResult = new StreamResult();
        streamResult.setOutputStream(out);
        transformer.transform(s, streamResult);
        return streamResult.getOutputStream().toString();
    }
}
