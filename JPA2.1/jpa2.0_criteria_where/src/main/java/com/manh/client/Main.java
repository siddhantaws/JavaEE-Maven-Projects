package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.manh.entity.Employee;
import com.manh.entity.EmployeeService;
import com.manh.util.JPAUtil;


public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        EmployeeService es = new EmployeeService(em);

        em.getTransaction().begin();
        es.createEmployee("Sang Shin", 10000);
        es.createEmployee("Bill Clinton", 8000);
        es.createEmployee("Angela Caicedo", 6000);
        es.createEmployee("Annie Song", 5000);
        es.createEmployee("Charles Song", 4500);
        em.getTransaction().commit();

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++        

        // Get all employees
        String jpql = "SELECT e FROM Employee e";
        List<Employee> emps = em.createQuery(jpql).getResultList();
        displayQueryResult(jpql, emps);

        ///////// Perform the same query using Criteria API
        CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cbuilder.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);

        // ---- Build criteria
        criteria.select(employee);

        // ---- Create a query object from Criteria and perform query operation
        // The following two lines of code is the same as the single line
        // of code that follows it.
        //TypedQuery<Employee> q = em.createQuery(criteria);
        //emps = q.getResultList();
        emps = em.createQuery(criteria).getResultList();

        // ---- Display the result
        displayQueryResult2(emps);
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Get all employees whose name is 'Sang Shin'
        jpql = "SELECT e FROM Employee e where e.name = 'Sang Shin'";
        emps = em.createQuery(jpql).getResultList();
        displayQueryResult(jpql, emps);

        ///////// Perform the same query using Criteria API

        // ---- Build criteria
        criteria.select(employee);
        criteria.where(cbuilder.equal(employee.get("name"), "Sang Shin"));

        // ---- Create a query object from Criteria and perform query operation
        emps = em.createQuery(criteria).getResultList();

        // ---- Display the result
        displayQueryResult2(emps);
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Get all employees whose name is 'Sang Shin' or whose salary is greater than 7000
        jpql = "SELECT e FROM Employee e where e.name = 'Sang Shin' OR e.salary > 7000";
        emps = em.createQuery(jpql).getResultList();
        displayQueryResult(jpql, emps);

        ///////// Perform the same query using Criteria API
        criteria.select(employee);
        criteria.where(cbuilder.or(cbuilder.equal(employee.get("name"), "Sang Shin"), cbuilder.greaterThan(employee.get("salary").as(Integer.class), 7000)));
        emps = em.createQuery(criteria).getResultList();
        displayQueryResult2(emps);
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Get all emplyees whose name starts with A
        jpql = "SELECT e FROM Employee e where e.name LIKE 'A%'";
        emps = em.createQuery(jpql).getResultList();
        displayQueryResult(jpql, emps);

        ///////// Perform the same query using Criteria API
        criteria.select(employee);
        criteria.where(cbuilder.like(employee.get("name").as(String.class),  "A%"));
        emps = em.createQuery(criteria).getResultList();
        displayQueryResult2(emps);
        
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // Get all employees whose name is either 'Sang Shin' or 'Bill Clinton" or 'Some name'
        jpql = "SELECT e FROM Employee e where e.name IN ('Sang Shin', 'Bill Clinton', 'Some name')";
        emps = em.createQuery(jpql).getResultList();
        displayQueryResult(jpql, emps);

        ///////// Perform the same query using Criteria API
        criteria.select(employee);
        criteria.where(employee.get("name").in("Sang Shin", "Bill Clinton", "Some name"));
        emps = em.createQuery(criteria).getResultList();
        displayQueryResult2(emps);


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
