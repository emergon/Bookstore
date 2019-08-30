/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.service;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tasos
 */
public class UserService {
    private EntityManagerFactory emf;
    private UserDao udao;
    
    public UserService(){
        emf = Persistence.createEntityManagerFactory("BookStorePU");
        udao = new UserDao(emf.createEntityManager());
    }
    
    public List<User> listAll(){
        return udao.listAll();
    }
    
    public User createUser(String email, String lname, String fname, String pass){
        User u = new User(fname, lname, email, pass);
        User existUser = udao.getUserByEmail(email);
        if(existUser==null){//if no user with email exists, then create user
            return udao.create(u);
        }
        return null;//else return null, which means user was not created because email exists.
    }
    
    public User getUser(int id){
        return udao.get(id);
    }
    
    public User updateUser(User oldUser, int id, String email, String lname, String fname, String pass){
        User existUser = udao.getUserByEmail(email);
        User u = new User(id, fname, lname, email, pass);
        if(existUser!=null && existUser.getUid()!=oldUser.getUid()){
            return null;
        }else{
            return udao.update(u);
        }
    }
    
    public void deleteUser(Object id){
        udao.delete(id);
    }
    
    public boolean login(String email, String password){
        return udao.checkLogin(email, password);
    }

}
