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

        Employee emp = es.createEmployee("Sang Shin", 10000);
        List<Phone> phones = new ArrayList<Phone>();
        phones.add(new Phone("111-111-1234", emp));
        phones.add(new Phone("111-111-2345", emp));
        phones.add(new Phone("111-111-2341", emp));
        phones.add(new Phone("111-111-3455", emp));
        es.setPhones(emp, phones);
        es.updateEmployee(emp);

        emp = es.createEmployee("Bill Clinton", 8000);
        phones = new ArrayList<Phone>();
        phones.add(new Phone("222-222-4252", emp));
        phones.add(new Phone("222-222-2452", emp));
        es.setPhones(emp, phones);
        es.updateEmployee(emp);

        tx.commit();

        // Perform query - Retrieve all employees who have a specific phone number
        // in their contactinfo
        String jpql = "SELECT e FROM Employee e "
                + "JOIN e.phones p WHERE p.phoneNumber like ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "222-222-42%");
        List<Employee> emps = query.getResultList();
        displayQueryResultBidirection(jpql, emps);

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        JPAUtil.checkData("select * from PHONE_TABLE");
        JPAUtil.checkData("select * from EMPLOYEE_PHONE_TABLE");

        em.close();
        emf.close();

    }

    // Display the query result
    public static void displayQueryResultBidirection(String jpql, List<Employee> emps) {
        System.out.println("\n------ Query result of \"" + jpql + "\"");
        for (Employee e : emps) {
            System.out.println("Employee " + e.getId() + ", " + e.getName() + ", " + e.getSalary());
            for (Phone p: e.getPhones()){
                System.out.println("  Phone number " + p.getPhoneNumber() + "is owned by "+ p.getEmployee().getName() );
            }
        }
    }
}
