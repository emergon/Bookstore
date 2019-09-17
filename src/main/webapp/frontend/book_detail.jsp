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
        <title>${book.title}</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <br/><br/>
        <div class="center">
            <table class="book">
                <tr>
                    <td colspan="3" align="left">
                        <p id="book_title">${book.title}</p>
                        by <span id="author">${book.author}</span>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">
                        <img class="book_large"
                             src="data:image/jpg;base64,${book.base64Image}">
                    </td>
                    <td valign="top" align="left">
                        Rating *****
                    </td>
                    <td valign="top" rowspan="2" width="20%">
                        <h2>$${book.price}</h2>
                        <br/><br/>
                        <button type="submit">Add to cart</button>
                    </td>
                </tr>
                <tr>
                    <td id="description">
                        ${book.description}
                    </td>
                </tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                    <td><h2>Customer Reviews</h2></td>
                    <td colspan="2">
                        <button>Write a Customer Review</button>
                    </td>
                </tr>
                
            </table>
        </div>
        <jsp:directive.include file="footer.jsp" />

    </body>
</html>
