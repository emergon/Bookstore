<%-- 
    Document   : user_form
    Created on : Jul 11, 2019, 5:25:22 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:if test="${user != null}">
                Edit User
            </c:if>
            <c:if test="${user == null}">
                Create User
            </c:if>

        </title>
        <link rel="stylesheet" href="../css/style.css"/>
        <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>
        <div align="center">
            <h2 class="pageheading">
                <c:if test="${user != null}">
                    Edit User
                </c:if>
                <c:if test="${user == null}">
                    Create New User
                </c:if>
            </h2>
        </div>
        <div align="center">
            <c:if test="${user != null}">
                <form action="edit_user" method="post" id="userform">
                    <input type="hidden" name="uid" value="${user.uid}">
            </c:if>
            <c:if test="${user == null}">
                <form action="create_user" method="post" id="userform">
            </c:if>

                    <table class="form">
                        <tr>
                            <td align="right">Email:</td>
                            <td><input type="text" id="email" name="email" value="${user.email}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Last name:</td>
                            <td><input type="text" id="lname" name="lname" value="${user.lname}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">First name:</td>
                            <td><input type="text" id="fname" name="fname" value="${user.fname}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Password:</td>
                            <td><input type="password" id="password" value="${user.password}" name="password" size="20"></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <button>Save</button>&nbsp;&nbsp;
                                <button onclick="javascript:history.go(-1);">Cancel</button>
                            </td>
                        </tr>

                    </table>
                </form>
        </div>

        <jsp:directive.include file="footer.jsp"/>
    </body>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#userform").validate({
                rules:{
                    email: {
                        required: true,
                        email: true
                    },
                    lname: "required",
                    fname: "required",
                    password: "required"
                },
                messages:{
                    email: {
                        required: "Please enter email",
                        email: "Please enter a valid email address"
                    },
                    lname: "Please enter last name",
                    fname: "Please enter first name",
                    password: "Please enter password"
                }
            });
        });
        function validateFormInput() {
            var fieldEmail = document.getElementById("email");
            var fieldLname = document.getElementById("lname");
            var fieldFname = document.getElementById("fname");
            var fieldPassword = document.getElementById("password");


            if (fieldEmail.value.length == 0) {
                alert("Email is required!");
                fieldEmail.focus();
                return false;
            }
            if (fieldLname.value.length == 0) {
                alert("Last name is required!");
                fieldLname.focus();
                return false;
            }
            if (fieldFname.value.length == 0) {
                alert("First name is required!");
                fieldFname.focus();
                return false;
            }
            if (fieldPassword.value.length == 0) {
                alert("Password is required!");
                fieldPassword.focus();
                return false;
            }
            return true;
        }
    </script>
</html>
