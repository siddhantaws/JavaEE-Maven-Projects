package com.manh.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

@Embeddable
public class ContactInfo implements Serializable{
    @Embedded private Address address;

    // One-to-many bidirectional relationship between 
    // ContactInfo and Phone.
    //
    // The "employee" is a field in the Phone Entity class.  The Phone 
    // Entity class is the owner of this bi-directional relationship.
    // In other words, it is the table that has the foreign key column.
    @OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
    private Set<Phone> phones;

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
     * @return the phones
     */
    public Set<Phone> getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
   
}
