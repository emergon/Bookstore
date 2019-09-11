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
        <title>Manage Books</title>
        <link rel="stylesheet" href="../css/style.css"/>
        <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>

        <div align="center">
            <h2 class="pageheading">Books Management</h2>
            <a href="create_book">Create New Book</a>
        </div>

        <!-- this is the message from create a new book-->
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
                    <th>Image</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Last Updated</th>
                     <th>Actions</th>
                </tr>
                <c:forEach items="${books}" var="book"  varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${book.bid}</td>
                        <td>
                            <img src="data:image/jpg;base64,${book.base64Image}" width="70" height="95">
                        </td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.cid.name}</td>
                        <td>$${book.price}</td>
                        <td><fmt:formatDate pattern="MM/dd/yyyy" value="${book.lastUpdated}"/> </td>
                        <td>
                            <a href="edit_book?id=${book.bid}">Edit</a> |
                            <a href="javascript:confirmDelete(${book.bid})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:directive.include file="../footer.jsp"/>

        <script>
            function confirmDelete(bookId){
                if (confirm('Are you sure you want to delete the book with ID:'+bookId+'?')){
                    window.location = 'delete_book?bid='+bookId;
                }
            }
        </script>
    </body>
</html>
