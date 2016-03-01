package com.manh.client;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.manh.entity.Employee;
import com.manh.entity.EmployeeService;
import com.manh.util.JPAUtil;


public class EmployeeClient {

    public static void main(String[] args) throws Exception {

        // Set up the table and data for testing
        JPAUtil.droptable("drop table EMPLOYEE");
        JPAUtil.setup("create table EMPLOYEE ( employee_id number, version number, name VARCHAR(20), salary number)");

        // Perform JPA operrations
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        // Create some employees
        EmployeeService es = new EmployeeService(em);

        em.getTransaction().begin();
        es.createEmployee(1, "Sang Shin", 1000000);
        es.createEmployee(2, "Bill Clinton", 800000);
        es.createEmployee(3, "Angela Caicedo", 700000);
        em.getTransaction().commit();

        // Version number of record 1 gets increamented by 1
        em.getTransaction().begin();
        String raise = JOptionPane.showInputDialog("Please enter raise amount - you will experience an exception after another user changes the row");
        Employee employee = em.find(Employee.class, 1);
        employee.setSalary(employee.getSalary() + Integer.parseInt(raise));
        em.getTransaction().commit();

        em.close();
        emf.close();

        // Display the table for verification
        JPAUtil.checkData("select * from EMPLOYEE");
    }
}
