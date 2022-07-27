<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/27/2022
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<form role="form" method="post" action="/discount ">
    <div class="container">
        <h1>Product Discount Calculator</h1>
        <div class="form-group col-6">
            <label>Product Description</label>
            <input name="productDescription" type="text" class="form-control" placeholder="Product Description input">
        </div>
        <div class="form-group col-6">
            <label>List Price</label>
            <input name="price" type="text" class="form-control" placeholder="Price input">
        </div>
        <div class="form-group col-6">
            <label>Discount Percent</label>
            <input name="discountPercent" type="text" class="form-control" placeholder="Discount Percent input">
        </div>
        <div>
            <input class="bg-warning" type="submit" id="submit" value="Calculate Discount">
        </div>

    </div>


</form>
<script src="/bootstrap-5.0.2-dist/js/bootstrap.js"></script>
</body>
</html>
