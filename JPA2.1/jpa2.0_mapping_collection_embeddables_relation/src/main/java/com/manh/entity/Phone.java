package com.manh.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_TABLE")
public class Phone implements Serializable {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue
    private int id;
    private String phoneNumber;

    // Bi-directional one-to-many relationship
    @ManyToOne(optional = true)
    // If you want to have a non-default foreign key column,
    // use @JoinColumn annotation as shown below.
    @JoinColumn(name="employee_fk")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phone() {
    }

    public Phone(String phoneNumber, Employee emp) {
        this.phoneNumber = phoneNumber;
        this.employee = emp;
    }

    public Phone(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
