<%-- 
    Document   : customer_form
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
            <c:if test="${customer != null}">
                Edit User
            </c:if>
            <c:if test="${customer == null}">
                Create User
            </c:if>

        </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>
        <div align="center">
            <h2 class="pageheading">
                <c:if test="${customer != null}">
                    Edit Customer
                </c:if>
                <c:if test="${customer == null}">
                    Create New Customer
                </c:if>
            </h2>
        </div>
        <div align="center">
            <c:if test="${customer != null}">
                <form action="edit_customer" method="post" id="customerform">
                    <input type="hidden" name="cid" value="${customer.cid}">
                </c:if>
                <c:if test="${customer == null}">
                    <form action="create_customer" method="post" id="customerform">
                    </c:if>

                    <table class="form">
                        <tr>
                            <td align="right">Email:</td>
                            <td><input type="text" id="email" name="email" value="${customer.email}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Last name:</td>
                            <td><input type="text" id="lname" name="lname" value="${customer.lname}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">First name:</td>
                            <td><input type="text" id="fname" name="fname" value="${customer.fname}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Password:</td>
                            <td><input type="password" id="password" value="${customer.password}" name="password" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Confirm Password:</td>
                            <td><input type="password" id="confirmPassword" value="${customer.password}" name="confirmPassword" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Phone Number:</td>
                            <td><input type="text" id="phone" name="phone" value="${customer.phone}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Address:</td>
                            <td><input type="text" id="address" name="address" value="${customer.address}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">City:</td>
                            <td><input type="text" id="city" name="city" value="${customer.city}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Zip Code:</td>
                            <td><input type="text" id="zip" name="zip" value="${customer.zip}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Country:</td>
                            <td><input type="text" id="country" name="country" value="${customer.country}" size="20"></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <button>Save</button>&nbsp;&nbsp;
                                <button type="button" onclick="history.back()">Cancel</button>
                            </td>
                        </tr>

                    </table>
                </form>
        </div>

        <jsp:directive.include file="../footer.jsp"/>
    </body>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#customerform").validate({
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    lname: "required",
                    fname: "required",
                    password: "required",
                    confirmPassword: {
                        required: true,
                        equalTo: "#password"
                    },
                    phone: "required",
                    address: "required",
                    city: "required",
                    zip: "required",
                    country: "required"
                },
                messages: {
                    email: {
                        required: "Please enter email",
                        email: "Please enter a valid email address"
                    },
                    lname: "Please enter last name",
                    fname: "Please enter first name",
                    password: "Please enter password",
                    confirmPassword: {
                        required: "Please confirm password",
                        equalTo: "Confirm password does not match password"
                    },
                    phone: "Please enter phone number",
                    address: "Please enter address",
                    city: "Please enter city",
                    zip: "Please enter zip",
                    country: "Please enter country"
                }
            });
        });
    </script>
</html>
