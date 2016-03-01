package com.manh.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.manh.entity.Manufacturer;
import com.manh.entity.Product;
import com.manh.util.JPAUtil;


public class Main {

    public static void main(String[] args) throws Exception {

        // Display the test table
        JPAUtil.checkData("select MANUFACTURER_ID, NAME, CITY from MANUFACTURER");
        //JPAUtil.checkData("select * from MANUFACTURER");
        JPAUtil.checkData("select PRODUCT_ID, MANUFACTURER_ID, MARKUP, DESCRIPTION from PRODUCT");
        //JPAUtil.checkData("select * from PRODUCT");
        JPAUtil.checkData("select * from PRODUCT_CODE");

        // Perform JPA operations
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ManufacturerServicePU");
        EntityManager em = emf.createEntityManager();

        // Display all manufacturers who have products whose markups are greater than 20.0 - same as above
        String jpql = "SELECT m FROM Manufacturer m "
                + "INNER JOIN m.productCollection p WHERE p.markup > 20.0";
        Query query = em.createQuery(jpql);
        List<Manufacturer> manufacturers = query.getResultList();
        displayQueryResult(jpql, manufacturers);

        ///////// Perform the same query using Criteria API
        CriteriaBuilder cbuilder = em.getEntityManagerFactory().getCriteriaBuilder();
        CriteriaQuery<Manufacturer> criteria = cbuilder.createQuery(Manufacturer.class);
        Root<Manufacturer> m = criteria.from(Manufacturer.class);
        Join<Manufacturer, Product> p = m.join("productCollection");

        // Create criteria
        criteria.select(m);
        criteria.where(cbuilder.greaterThan(p.get("markup").as(Integer.class), 20));

        // Create query using Criteria and then perform query operation
        manufacturers = em.createQuery(criteria).getResultList();
        displayQueryResult2(manufacturers);

        em.close();
        emf.close();

    }

    // Display the query result
    public static void displayQueryResult(String jpql, List<Manufacturer> manufacturers) {
        System.out.println("\n------ Query result of \"" + jpql + "\"");
        for (Manufacturer e : manufacturers) {
            System.out.println("Manufacturer id = " + e.getManufacturerId() + ", name = " + e.getName() + ", Sales rep = " + e.getRep() );
        }
    }

     // Display the query result
    public static void displayQueryResult2(List<Manufacturer> manufacturers) {
        System.out.println("\n******* Query result using Criteria API");
        for (Manufacturer e : manufacturers) {
            System.out.println("Manufacturer id = " + e.getManufacturerId() + ", name = " + e.getName() + ", Sales rep = " + e.getRep() );
        }
    }

}
