/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author anastasios
 */
public class BookDao extends JpaDao<Book> implements GenericDao<Book> {

    public BookDao() {
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
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Book.findByTitle");
        q.setParameter("title", title);
        List<Book> resultList = q.getResultList();
        closeEntityManager(em);
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        }
        return null;
    }
    
    public List<Book> findByCategory(Category category){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Book.findByCategory");
        q.setParameter("category", category);
        List<Book> resultList = q.getResultList();
        closeEntityManager(em);
        return resultList;
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Book.countAll");
    }
    
    public List<Book> findNewBooks(){
        EntityManager em = getEntityManager();
        String findNewBooksQuery = "select * from book order by publish_date desc limit 4";
        Query q = em.createNativeQuery(findNewBooksQuery, Book.class);
        //We can also use the below and not limit in the native query.
        //q.setFirstResult(0);
        //q.setMaxResults(4);
        List<Book> newBooks = q.getResultList();
        closeEntityManager(em);
        return newBooks;
    }
    
    public List<Book> searchBook(String keyword){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Book.findByKeyword");
        q.setParameter("keyword", "%"+keyword+"%");
        List<Book> books = q.getResultList();
        closeEntityManager(em);
        return books;
    }
    
    public long countByCategory(Integer categoryId){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Book.countByCategory");
        q.setParameter("categoryId", categoryId);
        long count = (long)q.getSingleResult();
        closeEntityManager(em);
        return count;
    }

}
