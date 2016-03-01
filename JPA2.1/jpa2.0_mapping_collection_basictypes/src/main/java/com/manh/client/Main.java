package com.manh.client;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;

import com.manh.entity.Employee;
import com.manh.entity.EmployeeService;
import com.manh.util.JPAUtil;

public class Main {

    public static void main(String[] args) throws Exception {

        // Create EntityManager
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        // EmployeeService is a utility class
        EmployeeService es = new EmployeeService(em);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Create the first employee with a set of Java skills
        Employee emp = es.createEmployee("Sang Shin", 10000);
        Set<String> javaskills = new HashSet<String>();
        javaskills.add("servlet 3.0");
        javaskills.add("ejb 3.1");
        javaskills.add("jsf 2.0");
        javaskills.add("jpa 2.0");
        es.setJavaskills(emp, javaskills);

        // Create the second employee with a set of Java skills
        emp = es.createEmployee("Bill Clinton", 8000);
        javaskills = new HashSet<String>();
        javaskills.add("jsf");
        javaskills.add("ejb");
        es.setJavaskills(emp, javaskills);

        // Create the 4 more employees
        es.createEmployee("Angela Caicedo", 6000);
        es.createEmployee("Annie Song", 5000);
        es.createEmployee("Charles Lannie", 7500);
        es.createEmployee("Shelley Nichole", 8500);

        tx.commit();

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        JPAUtil.checkData("select * from EXPERTISE");

        em.close();
        emf.close();

    }
}
