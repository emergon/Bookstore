/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tasos
 */
public class CategoryDaoTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static CategoryDao cdao;
    
    public CategoryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("BookStorePU");
        em = emf.createEntityManager();
        cdao = new CategoryDao(em);
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.close();
        emf.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testListAll(){
//        List<Category> list = cdao.listAll();
//        assertTrue(list.size()>0);
//    }
//    
//    @Test
//    public void testCreateCategory(){
//        Category c = new Category();
//        c.setName("Programming");
//        c = cdao.create(c);
//        assertTrue(c.getCid() > 0);
//    }
//    
//    @Test
//    public void testGetCategory(){
//        Integer uid = 1;
//        Category c = cdao.get(uid);
//        assertNotNull(c);
//    }
//    
//    @Test
//    public void testGetCategoryNotFound(){
//        Integer uid = 99;
//        Category c = cdao.get(uid);
//        assertNull(c);
//    }
//    
//    @Test
//    public void testUpdateCategory(){
//        Category c = new Category("History");
//        c.setCid(1);
//        Category updatedCategory = cdao.update(c);
//        assertEquals(updatedCategory.getName(), c.getName());
//    }
//    
//    @Test
//    public void testDeleteCategory(){
//        Integer uid = 10;
//        cdao.delete(uid);
//        Category c = cdao.get(uid);
//        assertNull(c);
//    }
//    
//    @Test(expected = EntityNotFoundException.class)
//    public void testDeleteCategoryNotExists(){
//        Integer uid = 10;
//        cdao.delete(uid);
//    }
}
