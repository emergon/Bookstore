<%-- 
    Document   : message
    Created on : Jul 12, 2019, 12:39:34 AM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Message</title>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>

        <div class="center">
            <h3>${message}</h3>    
        </div>

        <jsp:directive.include file="footer.jsp"/>
    </body>
</html>
