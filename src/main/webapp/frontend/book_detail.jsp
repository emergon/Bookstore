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
        <div align="center">
            <table width="80%" style="border: 0">
                <tr>
                    <td colspan="3" align="left">
                        <h2>${book.title}</h2> by ${book.author}
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">
                        <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300">
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
                    <td valign="top" style="text-align: justify">
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
        <br/><br/>
        <jsp:directive.include file="footer.jsp" />

    </body>
</html>
