/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tasos
 */
public class UserDaoTest {
//    private static EntityManagerFactory emf;
//    private static EntityManager em;

    private static UserDao udao;

    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
//        emf = Persistence.createEntityManagerFactory("BookStorePU");
//        em = emf.createEntityManager();
        udao = new UserDao();
    }

    @AfterClass
    public static void tearDownClass() {
//        em.close();
//        emf.close();
        udao.closeEntityManagerFactory();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testCreateUser(){
//        User u = new User();
//        u.setEmail("tasos@hot.com");
//        u.setFname("tas");
//        u.setLname("lel");
//        u.setPassword("1234");
//        u = udao.create(u);
//        assertTrue(u.getUid() > 0);
//    }
//    @Test
//    public void testUpdateUser(){
//        
//    }
//    
//    @Test
//    public void testGetUser(){
//        Integer uid = 1;
//        User u = udao.get(uid);
//        assertNotNull(u);
//    }
//    
//    @Test
//    public void testGetUserNotFound(){
//        Integer uid = 99;
//        User u = udao.get(uid);
//        assertNull(u);
//    }
//    
//    @Test
//    public void testDeleteUser(){
//        Integer uid = 10;
//        udao.delete(uid);
//        User u = udao.get(uid);
//        assertNull(u);
//    }
//    
//    @Test(expected = EntityNotFoundException.class)
//    public void testDeleteUserNotExists(){
//        Integer uid = 10;
//        udao.delete(uid);
//    }
//    
//    @Test
//    public void testListAll(){
//        List<User> list = udao.listAll();
//        assertTrue(list.size()>0);
//    }
//    
//    @Test
//    public void testCount(){
//        long result = udao.count();
//        long expected = 4;
//        assertEquals(expected, result);
//    }
//    @Test
//    public void testGetUserByEmail(){
//        String email = "tasos@hotmail.com";
//        User u = udao.getUserByEmail(email);
//        assertNotNull(u);
//    }
//    
//    @Test(expected = NoResultException.class)
//    public void testGetUserByEmailNotFound(){
//        String email = "tasos@m.com";
//        User u = udao.getUserByEmail(email);
//        
//    }
//    @Test
//    public void testCheckLogin(){
//        String email = "tasos@hotmail.com";
//        String password = "1234";
//        boolean exists = udao.checkLogin(email, password);
//        assertTrue(exists);
//    }
//    
//    @Test
//    public void testCheckLoginFailed(){
//        String email = "tasos3@hotmail.com";
//        String password = "1234";
//        boolean exists = udao.checkLogin(email, password);
//        assertFalse(exists);
//    }
}
