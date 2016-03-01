/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.manh.jaxws.soap.handler;

import java.util.Collections;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author michgan
 */
public class MyMessageHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext messageContext) {
        // SOAPMessage msg = messageContext.getMessage();
        logToSystemOut(messageContext);
        return true;
    }

    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

    /*
     * Check the MESSAGE_OUTBOUND_PROPERTY in the context
     * to see if this is an outgoing or incoming message.
     * Write a brief message to the print stream and
     * output the message. The writeTo() method can throw
     * SOAPException or IOException
     */
    private void logToSystemOut(SOAPMessageContext messageContext) {
        SOAPMessage msg = messageContext.getMessage();
        String content = null;
        try {
            content = msg.getSOAPBody().getTextContent();
        } catch (Exception e) {
            System.out.println("\nException occurred.." + e);
        }
        Boolean outboundProperty = (Boolean)
            messageContext.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            System.out.println("\nHandler Log -> Outbound message:" + content);
        } else {
            System.out.println("\nHandler Log -> Inbound message:" + content);
        }
    }

}
