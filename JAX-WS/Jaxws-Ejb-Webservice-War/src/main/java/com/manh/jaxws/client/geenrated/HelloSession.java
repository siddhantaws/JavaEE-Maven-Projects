
package com.manh.jaxws.client.geenrated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.3-b01-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloSession", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloSession {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://server/", className = "client_generated.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://server/", className = "client_generated.SayHelloResponse")
    @Action(input = "http://server/HelloSession/sayHelloRequest", output = "http://server/HelloSession/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}