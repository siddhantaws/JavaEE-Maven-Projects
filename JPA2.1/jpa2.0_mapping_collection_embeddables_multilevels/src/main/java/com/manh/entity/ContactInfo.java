package com.manh.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ContactInfo implements Serializable{
    
    @Embedded private Address address;
    private String email;

    public ContactInfo(){       
    }

    public ContactInfo(Address address) {
        this.address = address;
    }


    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
   
}
