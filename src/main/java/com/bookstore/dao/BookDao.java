/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Book;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author anastasios
 */
public class BookDao extends JpaDao<Book> implements GenericDao<Book> {

    public BookDao(EntityManager em) {
        super(em);
    }

    @Override
    public Book create(Book b) {
        b.setLastUpdated(new Date());
        return super.create(b);
    }

    @Override
    public Book get(Object id) {
        return super.find(Book.class, id);
    }

    @Override
    public Book update(Book b) {
        b.setLastUpdated(new Date());
        return super.update(b);
    }

    @Override
    public void delete(Object id) {
        super.delete(Book.class, id);
    }

    @Override
    public List<Book> listAll() {
        return super.findWithNamedQuery("Book.findAll");
    }

    public Book findByTitle(String title) {
        Query q = em.createNamedQuery("Book.findByTitle");
        q.setParameter("title", title);
        List<Book> resultList = q.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;

    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Book.countAll");
    }

}
