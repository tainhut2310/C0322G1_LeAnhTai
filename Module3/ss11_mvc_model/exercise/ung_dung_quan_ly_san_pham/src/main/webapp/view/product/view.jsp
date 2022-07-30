<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/29/2022
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product information detail</h1>
<fieldset>
    <legend>Product information</legend>
    <table>
        <tr>
            <td>ID: </td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Name: </td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Product Description: </td>
            <td>${product.productDescription}</td>
        </tr>
        <tr>
            <td>Producer: </td>
            <td>${product.producer}</td>
        </tr>
        <tr>
            <td><a href="/product">Back to product list</a></td>
        </tr>
    </table>
</fieldset>
</body>
</html>
