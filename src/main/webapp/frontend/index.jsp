<%-- 
    Document   : index
    Created on : Jul 10, 2019, 4:54:16 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Book Store</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <br/><br/>
        <div align="center">
            <a href="admin/login.jsp">Admin</a>
            <h3>main content</h3>
            <h2>New Books:</h2>
            <h2>Best-Selling Books:</h2>
            <h2>Most-favored Books:</h2>

        </div>
        <br/><br/>
        <jsp:directive.include file="footer.jsp" />

    </body>
</html>
