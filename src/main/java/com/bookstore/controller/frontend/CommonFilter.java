/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.frontend;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author anastasios
 */
@WebFilter(filterName = "CommonFilter", urlPatterns = {"/*"})
public class CommonFilter implements Filter {

    private final CategoryDao cdao;

    public CommonFilter() {
        cdao = new CategoryDao();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (!path.startsWith("/admin")) {
            List<Category> listCategory = cdao.listAll();
            request.setAttribute("listCategory", listCategory);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

}
