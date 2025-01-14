package org.example.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAO<E> {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> eClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa-concepts");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> eClass) {
        this.eClass = eClass;
        em = emf.createEntityManager();
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> createEntity(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> createWithTransaction(E entity) {
        return this
                .openTransaction()
                .createEntity(entity)
                .closeTransaction();
    }

    public List<E> getAll(int limit, int offset) {
        if (eClass == null) {
            throw new UnsupportedOperationException("Class is null");
        }

        String jpql = "select e from " + eClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, eClass);
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();

    }

    public List<E> getAll() {
        return this.getAll(10, 0);
    }

    public void close() {
        em.close();
    }
}
