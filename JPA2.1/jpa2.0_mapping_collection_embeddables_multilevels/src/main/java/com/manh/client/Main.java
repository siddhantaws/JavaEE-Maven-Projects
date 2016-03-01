package com.manh.client;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityTransaction;

import com.manh.entity.Address;
import com.manh.entity.ContactInfo;
import com.manh.entity.EmployeeService;
import com.manh.util.JPAUtil;

public class Main {

    public static void main(String[] args) throws Exception {
    	 JPAUtil.droptable("drop table VACATIONHOMES");	
    	
         JPAUtil.droptable("drop table EXPERTISE");
         JPAUtil.droptable("drop table EMPLOYEE");
      
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        EmployeeService es = new EmployeeService(em);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // First employee
        es.createEmployee("Sang Shin", 10000);

        Set<String> javaskills = new HashSet<String>();
        javaskills.add("servlet");
        javaskills.add("ejb");
        es.setJavaskills(1, javaskills);

        Set<Address> vacationHomes = new HashSet<Address>();
        vacationHomes.add(new Address("1 dreamland st", "newton", "MA"));
        vacationHomes.add(new Address("22 marthas vineyard", "cape cod", "MA"));
        es.setVacationHomes(1, vacationHomes);

        ContactInfo contactInfo = new ContactInfo(new Address("1 dreamland road", "Newton", "MA"));
        contactInfo.setEmail("test@gmail.com");
        es.setContactInfo(1, contactInfo);

        // 2nd employee
        es.createEmployee("Bill Clinton", 8000);
        javaskills = new HashSet<String>();
        javaskills.add("jsf");
        javaskills.add("ejb");
        es.setJavaskills(2, javaskills);

        es.createEmployee("Angela Caicedo", 6000);
        es.createEmployee("Annie Song", 5000);
        es.createEmployee("Charles Lannie", 7500);
        es.createEmployee("Shelley Nichole", 8500);

        tx.commit();

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        JPAUtil.checkData("select * from EXPERTISE");
        JPAUtil.checkData("select * from VACATIONHOMES");

        em.close();
        emf.close();

    }
}
