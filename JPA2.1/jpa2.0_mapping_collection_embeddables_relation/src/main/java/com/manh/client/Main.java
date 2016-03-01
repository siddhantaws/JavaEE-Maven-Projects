package com.manh.client;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.manh.entity.Address;
import com.manh.entity.ContactInfo;
import com.manh.entity.Employee;
import com.manh.entity.EmployeeService;
import com.manh.entity.Phone;
import com.manh.util.JPAUtil;


public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        EmployeeService es = new EmployeeService(em);

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // First employee
        Employee emp = es.createEmployee("Sang Shin", 10000);
        Set<Phone> phones = new HashSet<Phone>();
        phones.add(new Phone("111-3333-3333", emp));
        phones.add(new Phone("111-1233-6666", emp));
        ContactInfo contactInfo = new ContactInfo(new Address("1 dreamland road", "Newton", "MA"));
        contactInfo.setPhones(phones);
        es.setContactInfo(emp, contactInfo);
        es.updateEmployee(emp);

        // Second employee
        emp = es.createEmployee("Bill Clinton", 8000);
        phones = new HashSet<Phone>();
        phones.add(new Phone("222-3333-3333", emp));
        phones.add(new Phone("222-1233-6666", emp));
        contactInfo = new ContactInfo(new Address("7 Green St", "Ohmygodgown", "PA"));
        contactInfo.setPhones(phones);
        es.setContactInfo(emp, contactInfo);
        es.updateEmployee(emp);

        tx.commit();

        // Perform query - Retrieve all employees whose street is
        // "1 dteamland road".
        String jpql = "SELECT e FROM Employee e WHERE e.contactInfo.address.street = ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "1 dreamland road");
        List<Employee> emps = query.getResultList();

        // Access phone numbers through contactInfo
        if (!emps.isEmpty()) {
            Employee e = emps.get(0);
            System.out.println("Employee " + e.getId() + ", " + e.getName() + ", " + e.getSalary());
            for (Phone p : e.getContactInfo().getPhones()) {
                System.out.println("  Phone number " + p.getPhoneNumber() + "is owned by " + p.getEmployee().getName());
            }
        }

        // (Sang Shin: I could not make the following to work.) It causes the following error.
        // Invalid use of a query key [org.eclipse.persistence.mappings.OneToManyMapping[phones]] 
        //representing a "to-many" relationship in an expression.  Use anyOf() rather than get().
        // Perform query - Retrieve all employees who have a specific phone number
        // in their contactinfo
//        jpql = "SELECT e FROM Employee e "
//                + "JOIN e.contactInfo.phones p WHERE p.phoneNumber = ?1";
//        query = em.createQuery(jpql);
//        query.setParameter(1, "222-3333-3333");
//        emps = query.getResultList();
//        displayQueryResult(jpql, emps);

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
}
