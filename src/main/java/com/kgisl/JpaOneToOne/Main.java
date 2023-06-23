package com.kgisl.JpaOneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create a user
        User user = new User();
        user.setName("John Doe");

        // Create an address
        Address address = new Address();
        address.setCity("New York");

        // Establish the relationship
        user.setAddress(address);
        address.setUser(user);

        // Save the entities
        em.persist(user);
        em.persist(address);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
