package com.manh.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class Employee implements Serializable {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int eid;

    private String name;
    private long salary;

    // Bidirectional one to many relationship through "mappedBy".
    // The value of "mappedBy" is a field of Phone entity class.
    @OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
    // The @MapKeyColumn annotation is used to define a map
    // relationship where the key is a Basic value (not a class)
    @MapKeyColumn(name="PHONE_TYPE")
    private Map<String, Phone> phones;

    public Employee() {
    }

    public Employee(int id) {
        this.eid = id;
    }

    public int getId() {
        return eid;
    }

    public void setId(int id) {
        this.eid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee id: " + getId() + " name: " + getName() + " salary: " + getSalary();
    }

    /**
     * @return the phones
     */
    public Map<String, Phone> getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }

}
