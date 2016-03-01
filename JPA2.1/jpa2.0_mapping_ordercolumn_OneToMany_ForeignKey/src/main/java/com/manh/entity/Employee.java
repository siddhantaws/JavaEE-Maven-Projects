package com.manh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private int id;

    private String name;
    private long salary;

    // Unidirectional One-to-Many association using a foreign key mapping
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    // The join column is in table for Phone (for Unidirectional relationship)
    @JoinColumn(name="EMPLOYEE_ID") 
    // Specifies a column that is used to maintain the persistent order of a list.
    @OrderColumn(name = "INDEX")
    private List<Phone> phones;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

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
