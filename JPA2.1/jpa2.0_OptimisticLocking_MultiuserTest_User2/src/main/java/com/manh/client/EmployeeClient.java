package com.manh.client;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.manh.entity.Employee;
import com.manh.util.JPAUtil;

public class EmployeeClient {

    public static void main(String[] args) throws Exception {

        // Perform JPA operrations
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
         
        // Version number of record 1 gets increamented by 1
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, 1);
        employee.setSalary(employee.getSalary() + 300);
        em.getTransaction().commit();

        em.close();
        emf.close();

        // Display the table for verification
        JPAUtil.checkData("select * from EMPLOYEE");
    }
}
