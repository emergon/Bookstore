<%-- 
    Document   : category_list
    Created on : Jul 11, 2019, 1:02:19 AM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Categories</title>
        <link rel="stylesheet" href="../css/style.css"/>
        <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>

        <div align="center">
            <h2 class="pageheading">Categories Management</h2>
            <a href="category/category_form.jsp">Create New Category</a>
        </div>

        <!-- this is the message from create a new category-->
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
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${categories}" var="category"  varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${category.cid}</td>
                        <td>${category.name}</td>
                        <td>
                            <a href="edit_category?id=${category.cid}">Edit</a> |
                            <a href="javascript:confirmDelete(${category.cid})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:directive.include file="../footer.jsp"/>

        <script>
            function confirmDelete(categoryId){
                if (confirm('Are you sure you want to delete the category with ID:'+categoryId+'?')){
                    window.location = 'delete_category?cid='+categoryId;
                }
            }
        </script>
    </body>
</html>
