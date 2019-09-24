/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author anastasios
 */
public class CustomerDao extends JpaDao<Customer> implements GenericDao<Customer> {

    @Override
    public Customer get(Object id) {
        return super.find(Customer.class, id);
    }

    @Override
    public Customer create(Customer c) {
        c.setRegisterOn(new Date());
        return super.create(c);
    }

    @Override
    public Customer update(Customer c) {
        return super.update(c);
    }

    @Override
    public void delete(Object id) {
        super.delete(Customer.class, id);
    }

    @Override
    public List<Customer> listAll() {
        return super.findWithNamedQuery("Customer.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Customer.countAll");
    }

    public Customer getCustomerByEmail(String email) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Customer.findByEmail");
        q.setParameter("email", email);
        Customer c;
        try {
            c = (Customer) q.getSingleResult();
        } catch (NoResultException nre) {
            c = null;
        } finally {
            closeEntityManager(em);
        }
        return c;
    }

}
