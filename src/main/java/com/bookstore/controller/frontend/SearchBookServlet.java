/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.frontend;

import com.bookstore.entity.Book;
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
@WebServlet(name = "SearchBookServlet", urlPatterns = {"/search"})
public class SearchBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService service = new BookService();
        String keyword = request.getParameter("keyword");
        List<Book> books = service.search(keyword);
        request.setAttribute("keyword", keyword);
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("frontend/search_result.jsp");
        dispatcher.forward(request, response);
    }

}
