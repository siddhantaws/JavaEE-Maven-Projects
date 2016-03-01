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
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private int id;
    private String name;
    private long salary;

    // Collection of Embeddable type
    @ElementCollection
    // Name the table as "vacationhomes"
    @CollectionTable(name = "vacationhomes")
    private Set<Address> vacationHomes;

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
     * @return the vacationHomes
     */
    public Set<Address> getVacationHomes() {
        return vacationHomes;
    }

    /**
     * @param vacationHomes the vacationHomes to set
     */
    public void setVacationHomes(Set<Address> vacationHomes) {
        this.vacationHomes = vacationHomes;
    }
}
