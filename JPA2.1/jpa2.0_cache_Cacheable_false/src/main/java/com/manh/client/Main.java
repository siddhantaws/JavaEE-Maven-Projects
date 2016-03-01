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
import javax.persistence.Cache;

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

	        // Get all employees whose name is 'Sang Shin'
	        String jpql = "SELECT e FROM Employee e";
	        List<Employee> emps = em.createQuery(jpql).getResultList();
	        displayQueryResult(jpql, emps);

	        // Perform cache operations
	        Cache cache = emf.getCache();
	        System.out.println("cache.contains(Employee.class, 100) = " + cache.contains(Employee.class, 100)); // false
	        System.out.println("cache.contains(Employee.class, 1) before evict = " + cache.contains(Employee.class, 1));  // true
	        System.out.println("cache.contains(Employee.class, 2) = " + cache.contains(Employee.class, 2));  // true
	        cache.evict(Employee.class, 1);
	        System.out.println("cache.contains(Employee.class, 1) after evict = " + cache.contains(Employee.class, 1)); // false

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
