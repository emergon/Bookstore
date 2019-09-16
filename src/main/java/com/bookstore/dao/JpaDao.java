/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author tasos
 */
public class JpaDao<T> {

    private static EntityManagerFactory emf;
    //protected EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("BookStorePU");
    }

    public JpaDao() {
    }

    protected static EntityManagerFactory getEmf() {
        return emf;
    }

    protected EntityManager getEntityManager() {
        EntityManager em = emf.createEntityManager();
        return em;
    }

    protected void closeEntityManager(EntityManager em) {
        em.close();
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    public T create(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.flush();
        em.refresh(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    public T update(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        t = em.merge(t);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    public T find(Class<T> type, Object id) {
        EntityManager em = emf.createEntityManager();
        T t = em.find(type, id);
        if (t != null) {
            em.refresh(t);
        }
        em.close();
        return t;
    }

    public void delete(Class<T> type, Object id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T t = em.getReference(type, id);
        em.remove(t);
        em.getTransaction().commit();
        em.close();
    }

    public List<T> findWithNamedQuery(String query) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery(query);
        List<T> list = q.getResultList();
        em.close();
        return list;
    }

    public long countWithNamedQuery(String query) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createNamedQuery(query);
        long count = (long) q.getSingleResult();
        em.close();
        return count;
    }

}
