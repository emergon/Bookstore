/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.customer;

import com.bookstore.service.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeleteCustomerServlet", urlPatterns = {"/admin/delete_customer"})
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("cid"));
        CustomerService service = new CustomerService();
        service.deleteCustomer(customerId);
        String message = "Customer deleted successfully.";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_customers");
        dispatcher.forward(request, response);
    }
}
