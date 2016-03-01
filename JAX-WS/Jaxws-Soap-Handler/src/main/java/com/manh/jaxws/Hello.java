/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jaxws;

import javax.jws.HandlerChain;
import javax.jws.WebService;

/**
 *
 * @author michgan
 */
@WebService()
@HandlerChain(file = "Hello_handler.xml")
public class Hello {
  // Business method we want to expose as
  // Web service operation

  public String sayHello(String name) {
    return "Hello " + name + "!";
  }
}
