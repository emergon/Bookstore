/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.user;

import com.bookstore.entity.User;
import com.bookstore.service.UserService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tasos
 */
public class CreateUserServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String lname = request.getParameter("lname");
        String fname = request.getParameter("fname");
        String password = request.getParameter("password");
        UserService service = new UserService();
        User u = service.createUser(email, lname, fname, password);
        if (u == null) {//User exists
            String message = "Cannot create user. User with email "+email+" already exists";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "New user created successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("list_users");
            dispatcher.forward(request, response);
        }

    }

}
