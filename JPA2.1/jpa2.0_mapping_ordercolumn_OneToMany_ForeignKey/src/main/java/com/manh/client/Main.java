package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.manh.entity.Employee;
import com.manh.entity.EmployeeService;
import com.manh.entity.Phone;
import com.manh.util.JPAUtil;


public class Main {

    public static void main(String[] args) throws Exception {

        // Perform JPA operations
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        // Create some employees
        EmployeeService es = new EmployeeService(em);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        com.manh.entity.Employee emp = es.createEmployee("Sang Shin", 10000);
        List<Phone> phones = new ArrayList<Phone>();
        phones.add(new Phone("111-111-1234"));
        phones.add(new Phone("111-111-2345"));
        phones.add(new Phone("111-111-2341"));
        phones.add(new Phone("111-111-3455"));
        es.setPhones(emp, phones);

        emp = es.createEmployee("Bill Clinton", 8000);
        phones = new ArrayList<Phone>();
        phones.add(new Phone("222-222-4252"));
        phones.add(new Phone("222-222-2452"));
        es.setPhones(emp, phones);

        tx.commit();

        // Perform query - Retrieve all employees who have a specific phone number
        // in their contactinfo
        String jpql = "SELECT e FROM Employee e "
                + "JOIN e.phones p WHERE p.phoneNumber like ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "222%");
        List<Employee> emps = query.getResultList();
        displayQueryResult(jpql, emps);

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        JPAUtil.checkData("select * from PHONE_TABLE");

        em.close();
        emf.close();

    }

    // Display the query result
    public static void displayQueryResult(String jpql, List<Employee> emps) {
        System.out.println("\n------ Query result of \"" + jpql + "\"");
        for (Employee e : emps) {
            System.out.println("Employee " + e.getId() + ", " + e.getName() + ", " + e.getSalary());
        }
    }

    // Display the query result
    public static void displayQueryResult2(List<Employee> emps) {
        System.out.println("\n******* Query result using Criteria API");
        for (Employee e : emps) {
            System.out.println("Employee " + e.getId() + ", " + e.getName() + ", " + e.getSalary());
        }
    }
}
