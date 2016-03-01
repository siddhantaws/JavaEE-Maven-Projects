/*
 * Copyright 2009 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package com.manh.jsf;

import com.manh.annotation.Informal;

@Informal
public class InformalGreeting implements Greeting {
    public String greet(String name) {
        return "Hi, " + name + "!";
    }
}
