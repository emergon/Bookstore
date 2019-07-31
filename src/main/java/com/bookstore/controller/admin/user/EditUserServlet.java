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
public class EditUserServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserService service = new UserService();
        User u = service.getUser(id);
        request.setAttribute("user", u);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
        dispatcher.forward(request, response);
    }

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
        int id = Integer.parseInt(request.getParameter("uid"));
        String email = request.getParameter("email");
        String lname = request.getParameter("lname");
        String fname = request.getParameter("fname");
        String password = request.getParameter("password");
        UserService service = new UserService();
        User oldUser = service.getUser(id);
        if (oldUser == null) {//This check is done if another admin has already deleted a user
            String message = "Cannot find user with id:" + id + ". Please enter a valid id!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        } else {
            User u = service.updateUser(oldUser, id, email, lname, fname, password);
            if (u == null) {//User exists
                String message = "Cannot update user. User with email "+email+" already exists";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("message", "User updated successfully!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("list_users");
                dispatcher.forward(request, response);
            }
        }

    }

}
