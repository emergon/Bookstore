/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.book;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anastasios
 */
public class DeleteBookServlet extends HttpServlet {

    
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
        BookService service = new BookService();
        Integer bookId = Integer.parseInt(request.getParameter("bid"));
        Book deleteBook = service.getBookById(bookId);
        if(deleteBook == null){
            String message = "Cannot delete book with ID:"+bookId+"!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        }else{
            service.delete(bookId);
            String message = "Book deleted successfully!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list_books");
            dispatcher.forward(request, response);
        }
        
    }
    
}
