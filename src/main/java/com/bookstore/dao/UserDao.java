/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author tasos
 */
public class UserDao extends JpaDao<User> implements GenericDao<User> {

    public UserDao() {
    }

    @Override
    public User create(User u) {
        return super.create(u);
    }

    @Override
    public User get(Object uid) {
        return super.find(User.class, uid);
    }

    @Override
    public User update(User user) {
        return super.update(user);
    }

    @Override
    public void delete(Object id) {
        super.delete(User.class, id);
    }

    @Override
    public List<User> listAll() {
        return super.findWithNamedQuery("User.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("User.countAll");
    }

    public User getUserByEmail(String email) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("User.findByEmail");
        q.setParameter("email", email);
        User u = null;
        try {
            u = (User) q.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("###UserDao:getUserByEmail=" + email + " NoResultException###");
            //u = null;
        }finally{
            closeEntityManager(em);
        }
        return u;
    }
    
    public boolean checkLogin(String email, String password){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("User.findByEmailPassword");
        q.setParameter("email", email);
        q.setParameter("password", password);
        List<User> listOfUsers = q.getResultList();
        closeEntityManager(em);
        if(listOfUsers.size() == 1){
            return true;
        }
        return false;
    }

}
