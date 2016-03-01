/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jaxws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author Sang
 */
@WebService
@Stateless
public class HelloSession implements HelloSessionLocal {
	
	public String sayHello(String name) {
		  return "Hello " + name + "!";
	}
 
}
