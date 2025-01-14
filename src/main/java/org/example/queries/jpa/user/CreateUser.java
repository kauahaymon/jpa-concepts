package org.example.queries.jpa.user;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.model.User;

public class CreateUser {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa-concepts");
        EntityManager em = emf.createEntityManager();

        User newUser = new User("Test", "test@gmail.com.br");

        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();

        System.out.println("New user: " + newUser);
        em.close();
        emf.close();
    }
}