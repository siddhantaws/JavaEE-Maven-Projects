package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityTransaction;

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
        Map<String, Phone> phones = new HashMap<String, Phone>();
        phones.put("cell", new Phone("111-111-1234", emp));
        phones.put("home", new Phone("111-111-2345", emp));
        phones.put("fax", new Phone("111-111-2341", emp));
        phones.put("cell2", new Phone("111-111-3455", emp));
        es.setPhones(emp, phones);
        es.updateEmployee(emp);

        emp = es.createEmployee("Bill Clinton", 8000);
        phones = new HashMap<String, Phone>();
        phones.put("home", new Phone("222-222-4252", emp));
        phones.put("cell", new Phone("222-222-2452", emp));
        es.setPhones(emp, phones);
        es.updateEmployee(emp);

        tx.commit();

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
