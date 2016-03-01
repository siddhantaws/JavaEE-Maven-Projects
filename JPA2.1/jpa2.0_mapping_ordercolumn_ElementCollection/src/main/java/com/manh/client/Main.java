package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.manh.entity.Employee;
import com.manh.entity.EmployeeService;
import com.manh.util.JPAUtil;

public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        EmployeeService es = new EmployeeService(em);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee emp = es.createEmployee("Sang Shin", 10000);
        List<String> phones = new ArrayList<String>();
        phones.add("111-111-1234");
        phones.add("111-111-2345");
        phones.add("111-111-2341");
        phones.add("111-111-3455");
        es.setPhones(emp, phones);

        emp = es.createEmployee("Bill Clinton", 8000);
        phones = new ArrayList<String>();
        phones.add("222-222-4252");
        phones.add("222-222-2452");
        es.setPhones(emp, phones);

        es.createEmployee("Angela Caicedo", 6000);
        es.createEmployee("Annie Song", 5000);
        es.createEmployee("Charles Lannie", 7500);
        es.createEmployee("Shelley Nichole", 8500);

        tx.commit();

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        JPAUtil.checkData("select * from PHONE_TABLE");

        em.close();
        emf.close();

    }
}
