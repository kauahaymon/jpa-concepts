package org.example.queries.jpa.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.model.User;

public class UpdateUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("jpa-concepts");
        EntityManager em = emf.createEntityManager();

        /*
         * Transactional context: every changing is sync to db
         * Managed state
         * em.detach(Object); -> remove the obj from the managed state
         */
        em.getTransaction().begin();

        User updatedUser = em.find(User.class, 1L);
        updatedUser.setEmail("robson@gmail.com.br");

        //em.detach(User);

        em.merge(updatedUser);

        em.getTransaction().commit();

        System.out.println(updatedUser.getEmail());

        em.close();
        emf.close();
    }
}
