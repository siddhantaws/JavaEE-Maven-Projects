package com.manh.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Customer implements Serializable {

    @Id
    //@GeneratedValue
    private int id;
    
    private String name;

    // By using annotation, you can specify more options
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Order orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the order
     */
    public Order getOrders() {
        return orders;
    }

    /**
     * @param order the order to set
     */
    public void setOrders(Order order) {
        this.orders = order;
    }

}
