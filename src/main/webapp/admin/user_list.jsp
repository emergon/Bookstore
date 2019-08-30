<%-- 
    Document   : user_list
    Created on : Jul 11, 2019, 1:02:19 AM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
        <link rel="stylesheet" href="../css/style.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    </head>
    <body>
        <jsp:directive.include file="header.jsp"/>

        <div align="center">
            <h2 class="pageheading">Users Management</h2>
            <a href="user_form.jsp">Create New User</a>
        </div>

        <!-- this is the message from create a new user-->
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
                    <th>Email</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${users}" var="user"  varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${user.uid}</td>
                        <td>${user.email}</td>
                        <td>${user.lname}</td>
                        <td>${user.fname}</td>
                        <td>
                            <a href="edit_user?id=${user.uid}">Edit</a> |
                            <a href="javascript:confirmDelete(${user.uid});" class="deletelink" id="${user.uid}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:directive.include file="footer.jsp"/>

        <script>
            $(document).ready(function () {
                $(".deletelink").each(function () {
                    $(this).on("click", function () {
                        userid = $(this).attr("id");
                        if (confirm('Are you sure you want to delete the user with ID:' + userId + '?')) {
                            window.location = 'delete_user?uid=' + userId;
                        }
                    });
                });
            });
            function confirmDelete(userId) {
                if (confirm('Are you sure you want to delete the user with ID:' + userId + '?')) {
                    window.location = 'delete_user?uid=' + userId;
                }
            }
        </script>
    </body>
</html>
