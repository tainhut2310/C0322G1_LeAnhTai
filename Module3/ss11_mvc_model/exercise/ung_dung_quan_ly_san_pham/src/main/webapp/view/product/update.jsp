<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/29/2022
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Update Product</h1>
<p>
    <c:if test='${message != null}' >
        <span class="message">${message}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input readonly type="text" name="idProduct" value="${product.id}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="nameProduct" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="priceProduct" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Product Description: </td>
                <td><input type="text" name="productDescription" value="${product.productDescription}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer" value="${product.producer}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><a href="/product">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
