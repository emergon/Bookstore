<%-- 
    Document   : index
    Created on : Jul 10, 2019, 10:52:44 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store Admin</title>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>
        <div align="center">
            <h1>Administrative DashBoard</h1>
        </div>
        
        
        
        <div align="center">
            <hr width="60%"/>
            <h2>Quick Actions</h2>
            <b>
            <a href="create_book">New Book</a>&nbsp;
            <a href="create_user">New User</a>&nbsp;
            <a href="create_category">New Category</a>&nbsp;
            <a href="create_customer">New Customer</a>
            </b>
        </div>
        
        <div align="center">
            <hr width="60%"/>
            <h2>Recent Sales</h2>
        </div>
        
        <div align="center">
            <hr width="60%"/>
            <h2>Recent Reviews</h2>
        </div>
        
        <div align="center">
            <hr width="60%"/>
            <h2>Statistics</h2>
            <hr width="60%"/>
        </div>
        
        <jsp:directive.include file="footer.jsp"/>
    </body>
</html>
