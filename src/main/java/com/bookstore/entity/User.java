/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tasos
 */

@Entity
@Table(name = "user",schema = "bookstore")//use it if the class has different name than the db table
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.lname"),
    @NamedQuery(name = "User.countAll", query = "SELECT COUNT(*) FROM User u"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email =:email"),
    @NamedQuery(name= "User.findByEmailPassword", query = "SELECT u FROM User u WHERE u.email =:email AND u.password =:password")
})
public class User {
    @Id
    @Column(name = "uid")//optional, use if name is different
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String fname;
    private String lname;
    private String email;
    private String password;

    public User() {
    }

    public User(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public User(Integer uid, String fname, String lname, String email, String password) {
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
