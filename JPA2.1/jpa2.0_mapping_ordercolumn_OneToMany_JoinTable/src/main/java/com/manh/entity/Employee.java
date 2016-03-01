package com.manh.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private int eid;

    private String name;
    private long salary;

    // Bidirectional one to many relationship through "mappedBy".
    // The value of "mappedBy" is a field of Phone entity class.
    //@OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
    @OneToMany(cascade=CascadeType.ALL)
    // Specifies a column that is used to maintain the persistent order of a list.
    @OrderColumn(name = "INDEX")
    private List<Phone> phones;

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
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void sePhones(List<Phone> phones) {
        this.phones = phones;
    }
}
