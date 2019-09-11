/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin.book;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author anastasios
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,// 10KB
        maxFileSize = 1024 * 300, // 300KB
        maxRequestSize = 1024 * 1024 // 1MB
)
public class EditBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService service = new BookService();
        Integer bookId = Integer.parseInt(request.getParameter("id"));
        List<Category> categories = service.listCategories();
        Book book = service.getBookById(bookId);
        request.setAttribute("book", book);
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/book_form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService service = new BookService();
        Integer categoryId = Integer.parseInt(request.getParameter("category"));
        Integer bookId = Integer.parseInt(request.getParameter("bid"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = null;
        try {
            publishDate = df.parse(request.getParameter("publishDate"));
        } catch (ParseException ex) {
            throw new ServletException("Exception in parsing Publish Date");
        }
        Part part = request.getPart("image");
        byte[] imageBytes = null;
        if (part != null && part.getSize() > 0) {
            long size = part.getSize();
            imageBytes = new byte[(int) size];
            InputStream is = part.getInputStream();
            is.read(imageBytes);
            is.close();
        }
        Book bookUpdated = service.update(bookId, title, description, author, isbn, price, publishDate, imageBytes, categoryId);
        String message;
        if(bookUpdated == null){
            message = "Book has not been updated because this title already exists!";
        }else{
            message = "Book has been updated successfully!";
        }
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_books");
        dispatcher.forward(request, response);
    }

}
