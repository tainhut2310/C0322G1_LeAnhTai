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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Student List</h1>
    <form action="/product">
        <input type="text" name="nameSearch">
        <input type="submit" name="action" value="search">
    </form>
    <th><a href="/product?action=create">Thêm mới Product</a></th>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price Product</th>
        <th>Product Description</th>
        <th>Producer</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${productList}" var="product">
    <tr>
        <td>${product.id}</td>
        <td><a href="/product?action=view&id=${product.id}">${product.name}</a></td>
        <td>${product.price}</td>
        <td>${product.productDescription}</td>
        <td>${product.producer}</td>
        <td><a href="/product?action=update&id=${product.id}">Update</a></td>
        <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
