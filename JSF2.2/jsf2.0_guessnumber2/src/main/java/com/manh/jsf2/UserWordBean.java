/*
 * Copyright 2009 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */
package com.manh.jsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserWordBean {

    String userWord = null;
    String response = null;
    String correctWord = "passion";
    boolean correctlyGuessed = false;

    /** Creates a new instance of UserWordBean */
    public UserWordBean() {
    }

    public void setUserWord(String user_Word) {
        userWord = user_Word;
        System.out.println("Set userWord " + userWord);
    }

    public String getUserWord() {
        System.out.println("get userWord " + userWord);
        return userWord;
    }

    public String getResponse() {
        if (userWord != null && userWord.compareTo(correctWord) == 0) {
            return "Yay! You got the right word, " + userWord;
        } else {
            return "Sorry, " + userWord + " is incorrect.";
        }
    }
    protected String[] status = null;

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] newStatus) {
        status = newStatus;
    }
    private int maximum = 0;
    private boolean maximumSet = false;

    public int getMaximum() {
        return (this.maximum);
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
        this.maximumSet = true;
    }
    private int minimum = 0;
    private boolean minimumSet = false;

    public int getMinimum() {
        return (this.minimum);
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
        this.minimumSet = true;
    }

    // Action handler
    public String submitActionHandler() {

        if (userWord != null && userWord.compareTo(correctWord) == 0) {
            correctlyGuessed = true;
            return "greeting";
        } else {
            correctlyGuessed = false;
            return "response2";
        }
    }

    public String submitActionHandler2() {

        System.out.println("submitActionHandler2(): correctlyGuessed = " + correctlyGuessed);
        if (correctlyGuessed == true) {
            return "greeting";
        } else {
            return "greeting2";
        }
    }
}
