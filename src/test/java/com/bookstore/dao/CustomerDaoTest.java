/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Customer;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anastasios
 */
public class CustomerDaoTest {
    private static CustomerDao cdao;
    
    public CustomerDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        cdao = new CustomerDao();
    }
    
    @AfterClass
    public static void tearDownClass() {
        cdao.closeEntityManagerFactory();
    }

//    /**
//     * Test of get method, of class CustomerDao.
//     */
//    @Test
//    public void testGet() {
//        Integer customerId = 2;
//        Customer c = cdao.get(customerId);
//        assertNotNull(c);
//    }
//
//    /**
//     * Test of create method, of class CustomerDao.
//     */
//    @Test
//    public void testCreate() {
//        Customer c = new Customer();
//        c.setAddress("Souniou 10");
//        c.setCity("Patras");
//        c.setCountry("Greece");
//        c.setEmail("t@mail.com");
//        c.setFname("Tas");
//        c.setLname("Lela");
//        c.setPhone("6932323232");
//        c.setPassword("1234");
//        c.setZip("12345");
//        Customer createdCustomer = cdao.create(c);
//        assertTrue(createdCustomer.getCid()>0);
//    }
//
//    /**
//     * Test of update method, of class CustomerDao.
//     */
//    @Test
//    public void testUpdate() {
//        Customer c = cdao.get(1);
//        String name = "Nick";
//        c.setFname(name);
//        Customer updatedCustomer = cdao.update(c);
//        assertTrue(updatedCustomer.getFname().equals(name));
//        
//    }
//
//    /**
//     * Test of delete method, of class CustomerDao.
//     */
//    @Test
//    public void testDelete() {
//        Integer customerId = 1;
//        cdao.delete(customerId);
//        assertNull(cdao.get(customerId));
//    }
//
//    /**
//     * Test of listAll method, of class CustomerDao.
//     */
//    @Test
//    public void testListAll() {
//        List<Customer> customerList = cdao.listAll();
//        assertFalse(customerList.isEmpty());
//    }
//
//    /**
//     * Test of count method, of class CustomerDao.
//     */
//    @Test
//    public void testCount() {
//        long count = cdao.count();
//        assertEquals(1, count);
//    }
//    @Test
//    public void testGetCustomerByEmail(){
//        String email = "t@mail.com";
//        Customer c = cdao.getCustomerByEmail(email);
//        assertNotNull(c);
//    }
    
}
