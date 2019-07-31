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
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>
        <div align="center">
            <h2>
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
                <form action="edit_category" method="post" onsubmit="return validateFormInput()">
                    <input type="hidden" name="cid" value="${category.cid}">
            </c:if>
            <c:if test="${category == null}">
                <form action="create_category" method="post" onsubmit="return validateFormInput()">
            </c:if>

                    <table>
                        <tr>
                            <td align="right">Name:</td>
                            <td><input type="text" id="name" name="name" value="${category.name}" size="20"></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save">
                                <input type="button" value="Cancel" onclick="javascript:history.go(-1);">
                            </td>
                        </tr>

                    </table>
                </form>
        </div>

        <jsp:directive.include file="../footer.jsp"/>
    </body>

    <script type="text/javascript">
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
