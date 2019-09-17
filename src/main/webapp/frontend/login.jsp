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
        <title>Login</title>
    </head>
    <body>
       <%@include file="header.jsp" %>
        <div class="center">
            <h2>Please login:</h2>
            <form>
                Email: <input type="text" size="10"><br/>
                Password: <input type="password" size="10"/><br/>
                <input type="submit" value="Login"/>
            </form>
        </div>
       <%@include file="footer.jsp" %>
        
    </body>
</html>
