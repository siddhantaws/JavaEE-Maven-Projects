package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        es.createEmployee("Sang Shin", 10000);
        es.createEmployee("Bill Clinton", 8000);
        es.createEmployee("Angela Caicedo", 6000);
        es.createEmployee("Annie Song", 5000);
        es.createEmployee("Charles Lannie", 7500);
        es.createEmployee("Shelley Nichole", 8500);

        tx.commit();

        // Display the table
        JPAUtil.checkData("select * from EMPLOYEE");
        
        // Perform JPA query with ORDER BY
        String jpql = "SELECT e FROM Employee e "
                + "WHERE e.salary > 4000 "
                + "ORDER BY e.name ASC, e.salary DESC";
        Query q = em.createQuery(jpql);
        List<Employee> emps = q.getResultList();
        displayQueryResult(jpql, emps);

        ///////// Perform the same query using Criteria API
        CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cbuilder.createQuery(Employee.class);
        Root<Employee> employee = criteria.from(Employee.class);

        // Create criteria
        criteria.select(employee);
        criteria.where(cbuilder.or(cbuilder.equal(employee.get("name"), "Sang Shin"), cbuilder.greaterThan(employee.get("salary").as(Integer.class), 4000)));
        criteria.orderBy(cbuilder.asc(employee.get("name")), cbuilder.desc(employee.get("salary")));

        // Create query using Criteria and then perform query operation
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
