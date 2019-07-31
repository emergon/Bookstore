/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tasos
 */
public class UserTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookStorePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User u = new User();
        u.setEmail("ee");
        u.setFname("f");
        u.setLname("l");
        u.setPassword("pass");
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
