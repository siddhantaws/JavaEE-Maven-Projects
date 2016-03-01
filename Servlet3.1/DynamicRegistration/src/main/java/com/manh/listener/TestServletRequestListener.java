package com.manh.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TestServletRequestListener implements ServletRequestListener {

	 /**
     * Receives notification that a request is about to enter the scope
     * of the web application.
     *
     * @param sre The ServletRequestEvent
     */
    public void requestInitialized(ServletRequestEvent sre) {
    	// Add listenerAttributeName attribute to the request scope
        sre.getServletRequest().setAttribute("listenerAttributeName",
            "listenerAttributeValue");
    }
    
    /**
     * Receives notification that a request is about to leave the scope
     * of the web application.
     *
     * @param sre The ServletRequestEvent
     */
    public void requestDestroyed(ServletRequestEvent sre) {
        // Do nothing
    }

}
