<%-- 
    Document   : 404
    Created on : Aug 23, 2019, 6:04:28 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Not Found - Error</title>
    </head>
    <body>
        <div align="center">
            <div>
                <img src="${pageContext.request.contextPath}/images/bookstore-logo.jpg" width="200" height="100">
            </div>
            <div>
                <h2>Sorry the requested page could not be found</h2>
            </div>
            <div>
                <a href="javascript:history.go(-1);">Go Back</a>
            </div>
        </div>
    </body>
</html>
