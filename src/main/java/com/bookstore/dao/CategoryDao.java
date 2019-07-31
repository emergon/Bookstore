/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author tasos
 */
public class CategoryDao extends JpaDao<Category> implements GenericDao<Category>{

    public CategoryDao(EntityManager em) {
        super(em);
    }

    @Override
    public Category get(Object id) {
        return super.find(Category.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Category.class, id);
    }

    @Override
    public List<Category> listAll() {
        return super.findWithNamedQuery("Category.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Category.countAll");
    }
    
    public Category getCategoryByName(String name){
        Query q = em.createNamedQuery("Category.findByName");
        q.setParameter("name", name);
        Category c = null;
        try {
            c = (Category) q.getSingleResult();
        } catch (NoResultException nre) {
            System.out.println("###CategoryDao:getCategoryByName=" + name + " NoResultException###");
            //c = null;
        }
        return c;
    }
    
}
