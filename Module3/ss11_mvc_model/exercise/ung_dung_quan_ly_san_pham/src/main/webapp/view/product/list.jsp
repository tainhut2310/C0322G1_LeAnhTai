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
    <style>
        form, h2, p {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>PRODUCT LIST</h2>
    <form class="d-flex" role="search" action="/product">
        <input class="form-control me-2" type="search" placeholder="Search product" aria-label="Search" name="nameSearch">
        <button class="btn btn-outline-success" type="submit" name="action" value="search">SEARCH</button>
    </form>
    <p><a href="/product?action=create">
        <button type="button" class="btn btn-primary">ADD Product</button>
    </a>
    </p>
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
        <td><a href="/product?action=update&id=${product.id}">
            <button type="button" class="btn btn-outline-success">Update</button>
        </a></td>
        <td>
            <button type="button" class="btn btn-primary"
                    onclick="infoDelete('${product.id}','${product.name}')"
                    data-bs-toggle="modal" data-bs-target="#deleteModal">
                Delete
            </button>
        </td>
    </tr>
    </c:forEach>
</table>
</div>

                                            <%--Delete Modal--%>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/product" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="idDelete" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Bạn có muốn xóa sản phẩm: </span>
                    <span id="nameDelete"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
