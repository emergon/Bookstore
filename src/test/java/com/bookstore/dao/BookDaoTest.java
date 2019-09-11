/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author anastasios
 */
public class BookDaoTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static BookDao bdao;
    
    public BookDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("BookStorePU");
        em = emf.createEntityManager();
        bdao = new BookDao(em);
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.close();
        emf.close();
    }

    /**
     * Test of create method, of class BookDao.
     */
//    @Test
//    public void testCreate() throws ParseException, IOException {
//        Book b = new Book();
//        Category category = new Category(5, "Java");
//        b.setCid(category);
//        b.setAuthor("Tasos");
//        b.setDescription("This is description");
//        b.setIsbn("123456789");
//        b.setPrice(18.3f);
//        b.setTitle("Effective Java");
//        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date publishDate = format.parse("12/04/2018");
//        b.setPublishDate(publishDate);
//        String uri = "/home/anastasios/NetBeansProjects/Bookstore/general/bookImages/effectiveJava.jpeg";
//        b.setImage(Files.readAllBytes(Paths.get(uri))); 
//        Book createdBook = bdao.create(b);
//        assertTrue(createdBook.getBid() > 0);
//    }

    /**
     * Test of get method, of class BookDao.
     */
//    @Test
//    public void testGet() {
//        Integer bookId = 3;
//        Book book = bdao.get(bookId);
//        assertNotNull(book);
//    }

    /**
     * Test of update method, of class BookDao.
     */
//    @Test
//    public void testUpdate() throws ParseException, IOException {
//        Book b = new Book();
//        b.setBid(1);
//        Category category = new Category(5, "Java");
//        b.setCid(category);
//        b.setAuthor("Nick");
//        b.setDescription("This is description");
//        b.setIsbn("123456789");
//        b.setPrice(18.3f);
//        b.setTitle("Effective Java 2");
//        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        Date publishDate = format.parse("12/04/2018");
//        b.setPublishDate(publishDate);
//        String uri = "/home/anastasios/NetBeansProjects/Bookstore/general/bookImages/effectiveJava.jpeg";
//        b.setImage(Files.readAllBytes(Paths.get(uri))); 
//        Book updatedBook = bdao.update(b);
//        assertEquals(updatedBook.getTitle(), "Effective Java 2");
//    }

    /**
     * Test of delete method, of class BookDao.
     */
//    @Test(expected = EntityNotFoundException.class)
//    public void testDeleteFailed() {
//        Integer bookId = 100;
//        bdao.delete(bookId);
//    }
//    @Test
//    public void testDeleteSuccess() {
//        Integer bookId = 1;
//        bdao.delete(bookId);
//        assertTrue(true);
//    }

//    @Test
//    public void testFindByTitle(){
//        String title = "Effective Java";
//        Book book = bdao.findByTitle(title);
//        assertNotNull(book);
//    }
    
    /**
     * Test of listAll method, of class BookDao.
     */
//    @Test
//    public void testListAll() {
//        List<Book> books = bdao.listAll();
//        assertTrue(books.size()>0);
//    }

    /**
     * Test of count method, of class BookDao.
     */
//    @Test
//    public void testCount() {
//        long numberOfBooks = bdao.count();
//        assertEquals(numberOfBooks, 1);
//    }
    
//    @Test
//    public void testFindByCategory(){
//        Category c = new Category(5);
//        List<Book> listOfBooks = bdao.findByCategory(c);
//        assertTrue(listOfBooks.size()>1);
//    }
    
    
}
