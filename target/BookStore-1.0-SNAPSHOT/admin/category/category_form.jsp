<%-- 
    Document   : category_form
    Created on : Jul 11, 2019, 5:25:22 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:if test="${category != null}">
                Edit Category
            </c:if>
            <c:if test="${category == null}">
                Create Category
            </c:if>

        </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>
        <div align="center">
            <h2 class="pageheading">
                <c:if test="${category != null}">
                    Edit Category
                </c:if>
                <c:if test="${category == null}">
                    Create New Category
                </c:if>
            </h2>
        </div>
        <div align="center">
            <c:if test="${category != null}">
                <form action="${pageContext.request.contextPath}/admin/edit_category" method="post" id="categoryform">
                    <input type="hidden" name="cid" value="${category.cid}">
            </c:if>
            <c:if test="${category == null}">
                <form action="${pageContext.request.contextPath}/admin/create_category" method="post" id="categoryform">
            </c:if>

                    <table class="form">
                        <tr>
                            <td align="right">Name:</td>
                            <td><input type="text" id="name" name="name" value="${category.name}" size="20"></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <button>Save</button>&nbsp;&nbsp;
                                <button type="button" onclick="history.back()">Cancel</button>
                            </td>
                        </tr>

                    </table>
                </form>
        </div>

        <jsp:directive.include file="../footer.jsp"/>
    </body>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#categoryform").validate({
                rules:{
                    name: "required"
                },
                messages:{
                    name: "Please enter a category name"
                }
            });
        });
        function validateFormInput() {
            var fieldName = document.getElementById("name");
            
            if (fieldName.value.length == 0) {
                alert("Name is required!");
                fieldName.focus();
                return false;
            }
            
            return true;
        }
    </script>
</html>
