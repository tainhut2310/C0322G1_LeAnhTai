<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/12/2022
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form role="form" method="get" action="/convert">
    <div class="container">
        <h1>Currency Converter</h1>
        <div class="form-group col-6">
            <label>Rate: </label>
            <input name="rate" type="text" class="form-control" placeholder="RATE">
        </div>
        <br>
        <div class="form-group col-6">
            <label>USD: </label>
            <input name="usd" type="text" class="form-control" placeholder="USD">
        </div>
        <br>
        <div>
            <input class="bg-warning" type="submit" id="submit" value="Convert"/>
        </div>
    </div>
</form>
<h2>Total Money: ${totalMoney} vnđ</h2>
</body>
</html>
