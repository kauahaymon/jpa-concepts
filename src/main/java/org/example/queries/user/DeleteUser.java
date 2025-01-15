package org.example.queries.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.basic.User;

public class DeleteUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa-concepts");
        EntityManager em = emf.createEntityManager();

        Long userId = 11L;

        User deletedUser = em.find(User.class, userId);
        if (deletedUser != null) {
            em.getTransaction().begin();
            em.remove(deletedUser);
            em.getTransaction().commit();
        }

        System.out.println("Deleted user: " + deletedUser.getName());

        em.close();
        emf.close();
    }
}
