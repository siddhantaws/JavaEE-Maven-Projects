package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.manh.entity.Customer;
import com.manh.util.JPAUtil;


public class Main {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("CustomerServicePU");
        EntityManager em = emf.createEntityManager();

        // Display the test table
        JPAUtil.checkData("select CUSTOMER_ID, DISCOUNT_CODE, NAME, EMAIL from CUSTOMER");
        JPAUtil.checkData("select * from DISCOUNT_CODE");

        // Display all customers whose discount rate is bigger than 10%
        String jpql = "SELECT c FROM Customer c WHERE c.discountCode.rate > 10";
        Query query = em.createQuery(jpql);
        List<Customer> customers = query.getResultList();
        displayQueryResult(jpql, customers);

        ///////// Perform the same query using Criteria API
        CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Customer> criteria = cbuilder.createQuery(Customer.class);
        Root<Customer> Customer = criteria.from(Customer.class);

        // Create criteria
        criteria.select(Customer);
        criteria.where(cbuilder.greaterThan(Customer.get("discountCode").get("rate").as(Integer.class), 10));

        // Create query using Criteria and then perform query operation
        customers = em.createQuery(criteria).getResultList();
        displayQueryResult2(customers);

        em.close();
        emf.close();

    }

    // Display the query result
    public static void displayQueryResult(String jpql, List<Customer> customers) {
        System.out.println("\n------ Query result of \"" + jpql + "\"");
        for (Customer e : customers) {
            System.out.println("Customer id = " + e.getCustomerId() + ", name = " + e.getName() + ", discount rate = " + e.getDiscountCode().getRate());
        }
    }

    // Display the query result
    public static void displayQueryResult2(List<Customer> customers) {
        System.out.println("\n******* Query result using Criteria API");
        for (Customer e : customers) {
            System.out.println("Customer id = " + e.getCustomerId() + ", name = " + e.getName() + ", discount rate = " + e.getDiscountCode().getRate());
        }
    }
}
