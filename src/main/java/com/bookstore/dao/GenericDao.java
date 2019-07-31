/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.dao;

import java.util.List;

/**
 *
 * @author tasos
 */
public interface GenericDao<T> {
    T create(T t);
    T get(Object id);
    T update(T t);
    void delete(Object id);
    List<T> listAll();
    long count();
}
