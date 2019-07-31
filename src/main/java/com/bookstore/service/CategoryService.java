/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tasos
 */
public class CategoryService {
    private EntityManagerFactory emf;
    private CategoryDao cdao;

    public CategoryService() {
        emf = Persistence.createEntityManagerFactory("BookStorePU");
        cdao = new CategoryDao(emf.createEntityManager());
    }
    
    public List<Category> listAll(){
        return cdao.listAll();
    }
    
    public Category createCategory(String name){
        Category c = new Category(name);
        Category existCategory = cdao.getCategoryByName(name);
        if(existCategory==null){//if no user with name exists, then create user
            return cdao.create(c);
        }
        return null;//else return null, which means user was not created because name exists.
    }
    
    public Category getCategoryById(Object id){
        return cdao.get(id);
    }
    
    public Category updateCategory(int cid, String name){
        Category c = new Category(cid, name);
        Category categoryExist = cdao.getCategoryByName(name);
        if(categoryExist != null && categoryExist.getCid()!=cid){
            return null;
        }else{
            return cdao.update(c);
        }
        
    }
    
    public void deleteCategory(Object id){
        cdao.delete(id);
    }
    
}
