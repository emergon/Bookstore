/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Customer;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class CustomerService {

    private CustomerDao cdao;

    public CustomerService() {
        cdao = new CustomerDao();
    }

    public List<Customer> listCustomers() {
        return cdao.listAll();
    }

    public int createCustomer(String email, String fname, String lname, String password, String phone, String address, String city, String zip, String country) {
        Customer c = cdao.getCustomerByEmail(email);
        if (c != null) {
            return 0;
        }
        c = new Customer(fname, lname, email, password, phone, address, zip, country, city);
        cdao.create(c);
        return 1;

    }

    public int editCustomer(Integer cid, String email, String fname, String lname, String password, String phone, String address, String city, String zip, String country) {
        Customer existsCustomer = cdao.getCustomerByEmail(email);
        if(existsCustomer != null && existsCustomer.getCid()!=cid){
            return 0;
        }
        Customer customer = cdao.get(cid);
        customer.setEmail(email);
        customer.setFname(fname);
        customer.setLname(lname);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setCity(city);
        customer.setZip(zip);
        customer.setCountry(country);
        cdao.update(customer);
        return 1;
    }

    public Customer getCustomer(Integer cid) {
        return cdao.get(cid);
    }

    public void deleteCustomer(Integer customerId) {
        cdao.delete(customerId);
    }

}
