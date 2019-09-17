/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.BookDao;
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
    private CategoryDao cdao;

    public CategoryService() {
        cdao = new CategoryDao();
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
    
    public String deleteCategory(Object id){
        BookDao bdao = new BookDao();
        Category category = getCategoryById(id);
        if(category == null){
            return null;
        }
        long count = bdao.countByCategory((Integer)id);
        String message;
        if(count > 0){
            message = "Category (ID:%d) cannot be deleted because it has %d books.";
            message = String.format(message, id, count);
        }else{
            message = "Category deleted successfully!";
            cdao.delete(id);
        }
        return message;
    }
    
}
