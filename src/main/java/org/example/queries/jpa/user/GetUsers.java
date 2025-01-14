package org.example.queries.jpa.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.model.User;

import java.util.List;

public class GetUsers {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa-concepts");
        EntityManager em = emf.createEntityManager();

        String jpql = "select u from User u";
        List<User> userList = em.createQuery(jpql, User.class)
                .setMaxResults(10)
                .getResultList();
        for (User u: userList) {
            System.out.println("Id: " + u.getId() + ", E-mail: " + u.getEmail());
        }

        em.close();
        emf.close();
    }
}
