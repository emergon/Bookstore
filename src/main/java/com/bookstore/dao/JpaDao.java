/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tasos
 */
public class JpaDao<T> {

    protected EntityManager em;

    public JpaDao(EntityManager em) {
        this.em = em;
    }

    public T create(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.flush();
        em.refresh(t);
        em.getTransaction().commit();
        return t;
    }

    public T update(T t) {
        em.getTransaction().begin();
        t = em.merge(t);
        em.getTransaction().commit();
        return t;
    }

    public T find(Class<T> type, Object id) {
        T t = em.find(type, id);
        if (t != null) {
            em.refresh(t);
        }
        return t;
    }
    
    public void delete(Class<T> type, Object id){
        em.getTransaction().begin();
        T t = em.getReference(type, id);
        em.remove(t);
        em.getTransaction().commit();
    }
    
    public List<T> findWithNamedQuery(String query){
        Query q = em.createNamedQuery(query);
        List<T> list = q.getResultList();
        return list;
    }
    
    public long countWithNamedQuery(String query){
        Query q = em.createNamedQuery(query);
        return (long)q.getSingleResult();
    }
    
}
