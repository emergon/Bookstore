<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center">
    <div>
        <img src="images/bookstore-logo.jpg" width="200" height="100"/>
    </div>
    <div>
        <form action="search" method="get">
            <input type="text" name="keyword" size="50"/>
            <input type="submit" value="Search"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="login">Sign in</a> |
            <a href="register">Register</a> |
            <a href="view_cart">Cart</a>
        </form>
    </div>
    <div>
        <c:forEach items="${listCategory}" var="category" varStatus="status">
            <a href="view_category?id=${category.cid}">
                <b><c:out value="${category.name}"/></b>
            </a>
            <c:if test="${not status.last}">
                &nbsp; |
            </c:if>
        </c:forEach>        
    </div>
</div>