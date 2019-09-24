/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.customer;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/admin/list_customers"})
public class ListCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerService service = new CustomerService();
        List<Customer> listCustomers = service.listCustomers();
        request.setAttribute("listCustomers", listCustomers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer_list.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        doGet(request, response);
    }

}
