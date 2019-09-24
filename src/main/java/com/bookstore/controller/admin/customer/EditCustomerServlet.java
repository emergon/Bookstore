/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.customer;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anastasios
 */
@WebServlet(name = "EditCustomerServlet", urlPatterns = {"/admin/edit_customer"})
public class EditCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        CustomerService service = new CustomerService();
        Integer cid = Integer.parseInt(request.getParameter("id"));
        Customer customer = service.getCustomer(cid);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer_form.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerService service = new CustomerService();
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");
        int result = service.editCustomer(cid, email, fname, lname, password, phone, address, city, zip, country);
        String message = null;
        switch (result) {
            case 0:
                message = "Could not update customer. The email " + email + " is registered by another customer.";
                break;
            case 1:
                message = "Customer updated successfully";
                break;
        }
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_customers");
        dispatcher.forward(request, response);
    }

}
