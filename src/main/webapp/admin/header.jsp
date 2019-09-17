<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}/admin">
            <img src="${pageContext.request.contextPath}/images/bookstore-logo.jpg" width="200" height="100">
        </a>
        
    </div>

    <div>
        Welcome, <c:out value="${sessionScope.useremail}"/>| <a href="logout">Logout</a>

    </div>
    <br/>
    <div id="headermenu">
        <div>
            <a href="${pageContext.request.contextPath}/admin/list_users">
                <img src="${pageContext.request.contextPath}/images/user.jpeg" width="50px"><br/>
                Users
            </a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/admin/list_categories">
                <img src="${pageContext.request.contextPath}/images/category.png" width="50px"><br/>
                Categories
            </a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/admin/list_books">
                <img src="${pageContext.request.contextPath}/images/book.png" width="50px"><br/>
                Books
            </a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/admin/list_customers">
                <img src="${pageContext.request.contextPath}/images/customer.jpeg" width="50px"><br/>
                Customers
            </a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/admin/list_reviews">
                <img src="${pageContext.request.contextPath}/images/review.png" width="50px"><br/>
                Reviews
            </a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/admin/list_orders">
                <img src="${pageContext.request.contextPath}/images/order.jpeg" width="50px" ><br/>
                Orders
            </a>
        </div>
    </div>
</div>
