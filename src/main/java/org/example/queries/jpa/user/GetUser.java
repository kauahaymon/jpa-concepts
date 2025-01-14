package org.example.queries.jpa.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.model.User;

public class GetUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa-concepts");
        EntityManager em = emf.createEntityManager();

        User getUser = em.find(User.class, 2L);
        System.out.println(getUser.getEmail());

        em.close();
        emf.close();
    }
}
