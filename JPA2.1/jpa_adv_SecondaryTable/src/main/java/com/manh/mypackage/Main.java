package com.manh.mypackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.manh.entities.EmployeeService;
import com.manh.util.JPAUtil;





public class Main {

    public static void main(String[] args) throws Exception {

        // Set up the table and data for testing
        JPAUtil.droptable("drop table MY_OWN_EMPLOYEE_TABLE");
        JPAUtil.droptable("drop table ATABLE");
        JPAUtil.droptable("drop table SALARY");

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

        em.close();
        emf.close();

        // Display the table for verification
        JPAUtil.checkData("select * from MY_OWN_EMPLOYEE_TABLE ORDER BY ID");
        JPAUtil.checkData("select * from SALARY ORDER BY ID");
    }
}
