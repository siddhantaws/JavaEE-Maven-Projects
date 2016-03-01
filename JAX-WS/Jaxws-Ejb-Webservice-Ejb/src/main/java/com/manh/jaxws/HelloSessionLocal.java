/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manh.jaxws;

import javax.ejb.Local;

/**
 *
 * @author Sang
 */
@Local
public interface HelloSessionLocal {

	public String sayHello(String name);
    
}
