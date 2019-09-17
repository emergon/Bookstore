<%-- 
    Document   : books_list_by_category
    Created on : Jul 10, 2019, 4:54:16 PM
    Author     : tasos
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books in ${category}</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <br/><br/>
        <div class="center">
            <h2>${category}</h2>
        </div>
        <div class="book_group">
            <c:forEach items="${booksByCategory}" var="book">
                <div style="float:left; display: inline-block; margin: 20px">
                    <div>
                        <a href="view_book?bid=${book.bid}">
                            <img class="book_small" 
                                src="data:image/jpg;base64,${book.base64Image}">
                        </a>
                    </div>
                    <div>
                        <a href="view_book?bid=${book.bid}">
                            <b>${book.title}</b>
                        </a>
                    </div>
                    <div>Rating *****</div>
                    <div><i>by ${book.author}</i></div>
                    <div><b>$${book.price}</b></div>
                </div>

            </c:forEach>
        </div>
        <br/><br/>
        <jsp:directive.include file="footer.jsp" />

    </body>
</html>
