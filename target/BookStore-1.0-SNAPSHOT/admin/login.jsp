<%-- 
    Document   : login
    Created on : Aug 12, 2019, 6:12:13 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" href="../css/style.css"/>
        <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    </head>
    <body>
        <div align="center">
            <h1>Bookstore Administration</h1>
            <h2 class="pageheading">Admin Login</h2> 

            <c:if test="${message != null}">
                <div align="center">
                    <h4 class="message">${message}</h4>
                </div>
            </c:if>

            <form id="loginForm" action="login" method="post">
                <table class="form">
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input type="text" name="email" id="email" size="20"
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <input type="password" name="password" id="password" size="20">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit">Login</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#loginForm").validate({
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    password: "required"
                },
                messages: {
                    email: {
                        required: "Please enter an email",
                        email: "Please enter a valid email address"
                    },
                    password: "Please enter a password"
                }
            });
        });
    </script>
</html>
