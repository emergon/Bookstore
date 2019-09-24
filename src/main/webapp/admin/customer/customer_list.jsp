<%-- 
    Document   : category_list
    Created on : Jul 11, 2019, 1:02:19 AM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Customers</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>

        <div align="center">
            <h2 class="pageheading">Customers Management</h2>
            <a href="${pageContext.request.contextPath}/admin/customer/customer_form.jsp">Create New Customer</a>
        </div>

        <!-- this is the message from create a new customer-->
        <c:if test="${message != null}">
            <div align="center">
                <h4 class="message">${message}</h4>
            </div>
        </c:if>
        <br/>
        <div align="center">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Index</th>
                    <th>ID</th>
                    <th>E-mail</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>City</th>
                    <th>Country</th>
                    <th>Registered On</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${listCustomers}" var="customer"  varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${customer.cid}</td>
                        <td>${customer.email}</td>
                        <td>${customer.fname}</td>
                        <td>${customer.lname}</td>
                        <td>${customer.city}</td>
                        <td>${customer.country}</td>
                        <td><fmt:formatDate pattern="MM/dd/yyyy" value="${customer.registerOn}" /></td>
                        <td>
                            <a href="edit_customer?id=${customer.cid}">Edit</a> |
                            <a href="javascript:confirmDelete(${customer.cid})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:directive.include file="../footer.jsp"/>

        <script>
            function confirmDelete(customerId){
                if (confirm('Are you sure you want to delete the customer with ID:'+customerId+'?')){
                    window.location = 'delete_customer?cid='+customerId;
                }
            }
        </script>
    </body>
</html>
