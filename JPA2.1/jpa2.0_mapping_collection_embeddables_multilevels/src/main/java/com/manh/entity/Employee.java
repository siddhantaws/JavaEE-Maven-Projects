package com.manh.entity;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private int id;
    private String name;
    private long salary;
    
    // Collection of basic type - Stting type in this case
    @ElementCollection
    // Name the table as "expertise"
    @CollectionTable(name = "expertise")
    private Set<String> javaskills;

     // Collection of embeddable type
    @ElementCollection
    @CollectionTable(name = "vacationhomes")
    private Set<Address> vacationHomes;

    // Multi-levels of Embeddable
    private ContactInfo contactInfo;

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

    /**
     * @return the contactInfo
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
