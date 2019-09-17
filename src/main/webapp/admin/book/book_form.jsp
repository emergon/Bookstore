<%-- 
    Document   : book_form
    Created on : Jul 11, 2019, 5:25:22 PM
    Author     : tasos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <c:if test="${book != null}">
                Edit Book
            </c:if>
            <c:if test="${book == null}">
                Create Book
            </c:if>

        </title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/js/richtext.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.richtext.min.js"></script>
        
    </head>
    <body>
        <jsp:directive.include file="../header.jsp"/>
        <div align="center">
            <h2 class="pageheading">
                <c:if test="${book != null}">
                    Edit Book
                </c:if>
                <c:if test="${book == null}">
                    Create New Book
                </c:if>
            </h2>
        </div>
        <div align="center">
            <c:if test="${book != null}">
                <form action="edit_book" method="post" id="bookform" onsubmit="return validateFormInput()" enctype="multipart/form-data">
                    <input type="hidden" name="bid" value="${book.bid}">
                </c:if>
                <c:if test="${book == null}">
                    <form action="create_book" method="post" id="bookform" onsubmit="return validateFormInput()" enctype="multipart/form-data">
                    </c:if>

                    <table class="form">
                        <tr>
                            <td>Category:</td>
                            <td>
                                <select name="category">
                                    <c:forEach items="${categories}" var="category">
                                        <c:if test="${category.cid eq book.cid.cid}">
                                            <option value="${category.cid}" selected>
                                            </c:if>
                                            <c:if test="${category.cid ne book.cid.cid}">
                                            <option value="${category.cid}">
                                            </c:if>
                                            ${category.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">Title:</td>
                            <td><input type="text" id="title" name="title" value="${book.title}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Author:</td>
                            <td><input type="text" id="author" name="author" value="${book.author}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">ISBN:</td>
                            <td><input type="text" id="isbn" name="isbn" value="${book.isbn}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Publish Date:</td>
                            <td><input type="text" id="publishDate" name="publishDate" size="20"
                                       value="<fmt:formatDate pattern='MM/dd/yyyy' value='${book.publishDate}' />" ></td>
                        </tr>
                        <tr>
                            <td align="right">Book Image:</td>
                            <td>
                                <input type="file" id="image" name="image" size="20"><br/>
                                <img id="thumbnail" alt="Image Preview" width="60" height="90"
                                     src="data:image/jpg;base64,${book.base64Image}"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">Price:</td>
                            <td><input type="text" id="price" name="price" value="${book.price}" size="20"></td>
                        </tr>
                        <tr>
                            <td align="right">Description:</td>
                            <td>
                                <textarea rows="5" cols="50" id="description" name="description">${book.description}</textarea>
                            </td>
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
        $(document).ready(function () {
            $('#publishDate').datepicker();
//            $('#description').richText();//does not work properly
            $("#image").change(function () {
                showImageThumbnail(this);
            });
            $('#bookform').validate({
                rules: {
                    category: "required",
                    title: "required",
                    author: "required",
                    isbn: "required",
                    publishDate: "required",
                    image: "required",
                    price: "required",
                    description: "required"
                },
                messages: {
                    category: "Please select a category",
                    title: "Please enter title",
                    author: "Please enter last name",
                    isbn: "Please enter first name",
                    publishDate: "Please enter publish date",
                    image: "Please enter image",
                    price: "Please enter price",
                    description: "Please enter description"
                }
            });
        });
        function validateFormInput() {
            var fieldTitle = document.getElementById("title");
            var fieldAuthor = document.getElementById("author");
            var fieldIsbn = document.getElementById("isbn");
            var fieldPublishDate = document.getElementById("publishDate");
            var fieldImage = document.getElementById("image");
            var fieldPrice = document.getElementById("price");
            var fieldDescription = document.getElementById("description");


            if (fieldTitle.value.length == 0) {
                alert("Title is required!");
                fieldTitle.focus();
                return false;
            }
            if (fieldAuthor.value.length == 0) {
                alert("Author is required!");
                fieldAuthor.focus();
                return false;
            }
            if (fieldIsbn.value.length == 0) {
                alert("ISBN is required!");
                fieldIsbn.focus();
                return false;
            }
            if (fieldPublishDate.value.length == 0) {
                alert("Publish Date is required!");
                fieldPublishDate.focus();
                return false;
            }
           <c:if test="${book == null}">
            if (fieldImage.value.length == 0) {
                alert("Image is required!");
                fieldImage.focus();
                return false;
            }
        </c:if>

            if (fieldPrice.value.length == 0) {
                alert("Price is required!");
                fieldPrice.focus();
                return false;
            }
            if (fieldDescription.value.length == 0) {
                alert("Description is required!");
                fieldDescription.focus();
                return false;
            }
            return true;
        }
        ;

        function showImageThumbnail(fileInput) {
            var file = fileInput.files[0];
            var reader = new FileReader();
            reader.onload = function (e) {
                $("#thumbnail").attr("src", e.target.result);
            };
            reader.readAsDataURL(file);
        }
        ;
    </script>
</html>
