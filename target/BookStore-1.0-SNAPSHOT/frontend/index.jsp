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
        <title>Online Book Store</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <br/><br/>
        <div align="center">
            <a href="admin/login.jsp">Admin</a>
            <h3>main content</h3>
            <div>
                <h2>New Books:</h2>
                <div align="center" style="width: 50%; margin: 0 auto">
                    <c:forEach items="${newBooks}" var="book">
                        <div style="display: inline-block; margin: 20px">
                            <div>
                                <a href="view_book?bid=${book.bid}">
                                    <img src="data:image/jpg;base64,${book.base64Image}" width="85" height="115">
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
            </div>
            <div align="center" style="clear:both">
                <h2>Best-Selling Books:</h2>
            </div>
            <div align="center" style="clear:both">

                <h2>Most-favored Books:</h2>
            </div>
        </div>
        <br/><br/>
        <jsp:directive.include file="footer.jsp" />

    </body>
</html>
