<%-- 
    Document   : index
    Created on : Jul 10, 2019, 4:54:16 PM
    Author     : tasos
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results from ${keyword}</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <br/><br/>
        <div class="center">
            <c:if test="${fn:length(books) == 0}">
                <h2>No results for <i>"${keyword}"</i></h2>
            </c:if>
            <c:if test="${fn:length(books) > 0}">
                <h2>Results for "${keyword}"</h2>
                <div class="book_group">
                    
                    <c:forEach items="${books}" var="book">
                        <div>
                            <div id="search_image">
                                <div>
                                    <a href="view_book?bid=${book.bid}">
                                        <img class="book_small" 
                                            src="data:image/jpg;base64,${book.base64Image}">
                                    </a>
                                </div>
                            </div>

                            <div id="search_description">
                                <div>
                                    <h2>
                                        <a href="view_book?bid=${book.bid}">
                                            <b>${book.title}</b>
                                        </a>
                                    </h2>
                                </div>
                                <div>Rating *****</div>
                                <div><i>by ${book.author}</i></div>
                                <div>
                                    <p>${fn:substring(book.description, 0, 100)}...</p>
                                </div>
                            </div>

                            <div id="search_price">
                                <h3><b>$${book.price}</b></h3>
                                <h3><a>Add to cart</a></h3>
                            </div>

                        </div>
                    </c:forEach>
                </div>

            </c:if>
        </div>
        <br/><br/>
        <jsp:directive.include file="footer.jsp" />

    </body>
</html>
