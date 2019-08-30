/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tasos
 */
public class AdminLoginFilter implements Filter {
    
    public AdminLoginFilter() {
    }    

    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("useremail") != null;
        String loginURI = httpRequest.getContextPath() + "/admin/login";
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
        
        if(loggedIn && (loginRequest || loginPage)){
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/admin");
            dispatcher.forward(request, response);
        }else if(loggedIn || loginRequest){
            chain.doFilter(request, response);
        }else{
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    

    
    @Override
    public void destroy() {        
    }

    
    @Override
    public void init(FilterConfig filterConfig) {        
        
    }
    
}
