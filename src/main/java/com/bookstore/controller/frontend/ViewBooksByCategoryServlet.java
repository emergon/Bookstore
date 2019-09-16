/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.frontend;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;
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
@WebServlet(name = "ViewBooksByCategoryServlet", urlPatterns = {"/view_category"})
public class ViewBooksByCategoryServlet extends HttpServlet {

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
        List<Category> listCategory = service.listCategories();
        Integer categoryId = Integer.parseInt(request.getParameter("id"));
        List<Book> booksByCategory = service.getBooksByCategory(categoryId);
        if (booksByCategory == null) {
            String message = "Sorry, the category ID " + categoryId + " is not available.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("frontend/message.jsp").forward(request, response);
        } else {
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("booksByCategory", booksByCategory);
            if (booksByCategory.isEmpty()) {
                request.setAttribute("category", "There are no books for this category");
            } else {
                request.setAttribute("category", booksByCategory.get(0).getCid().getName());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("frontend/books_list_by_category.jsp");
            dispatcher.forward(request, response);
        }

    }
}
