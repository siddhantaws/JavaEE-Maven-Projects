package com.manh.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int id;
    private String name;
    private long salary;
    
    // Collection of basic type - String type in this case
    @ElementCollection
    // Name the table as "EXPERTISE"
    @CollectionTable(name = "expertise")
    private Set<String> javaskills;

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
     * @return the javaskills
     */
    public Set<String> geJavaskills() {
        return javaskills;
    }

    /**
     * @param javaskills the javaskills to set
     */
    public void seJavaskills(Set<String> javaskills) {
        this.javaskills = javaskills;
    }
}
