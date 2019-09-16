/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anastasios
 */
public class BookService {

    private BookDao bdao;
    private CategoryDao cdao;

    public BookService() {
        bdao = new BookDao();
        cdao = new CategoryDao();
    }

    public List<Book> listBooks() {
        return bdao.listAll();
    }

    public List<Category> listCategories() {
        return cdao.listAll();
    }

    public Book getBookByTitle(String title) {
        return bdao.findByTitle(title);
    }

    public Book create(String title, String description, String author, String isbn, float price, Date publishDate, byte[] image, Integer cid) {
        Category category = cdao.get(cid);
        Book newBook = new Book(title, description, author, isbn, price, publishDate, image, category);
        Book bookByTitle = getBookByTitle(newBook.getTitle());
        if (bookByTitle == null) {
            return bdao.create(newBook);
        } else {
            return null;
        }
    }

    public Book getBookById(Integer bookId) {
        Book book = bdao.get(bookId);
        return book;
    }

    public Book update(Integer bookId, String title, String description, String author, String isbn, float price, Date publishDate, byte[] imageBytes, Integer categoryId) {
        Book editBook = bdao.get(bookId);
        Book bookByTitle = bdao.findByTitle(title);
        if (!editBook.equals(bookByTitle) && bookByTitle != null) {
            return null;
        }
        editBook.setTitle(title);
        editBook.setAuthor(author);
        editBook.setCid(cdao.get(categoryId));
        editBook.setDescription(description);
        if (imageBytes != null) {
            editBook.setImage(imageBytes);
        }
        editBook.setIsbn(isbn);
        editBook.setPrice(price);
        editBook.setPublishDate(publishDate);
        editBook.setTitle(title);
        return bdao.update(editBook);
    }

    public void delete(Integer bookId) {
        bdao.delete(bookId);
    }

    public List<Book> getBooksByCategory(Integer categoryId) {
        Category category = cdao.get(categoryId);
        if (category == null) {
            return null;
        }
        List<Book> booksByCategory = bdao.findByCategory(category);
        return booksByCategory;
    }

    public List<Book> getNewBooks() {
        return bdao.findNewBooks();
    }

    public Book viewBookDetail(Integer bookId) {
        return bdao.get(bookId);
    }

    public List<Book> search(String keyword) {
        return bdao.searchBook(keyword);
    }

}
