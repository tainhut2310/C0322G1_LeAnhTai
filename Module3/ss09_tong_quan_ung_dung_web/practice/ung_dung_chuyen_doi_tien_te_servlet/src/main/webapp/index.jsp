<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" href="/bootstrap-5.0.2-dist/css/bootstrap.css">
</head>
<body>
<form role="form" method="post" action="/convert">
  <div class="container">
    <h2>Currency Converter</h2>
    <div class="form-group col-6">
      <label>Rate: </label>
      <input name="rate" type="text" class="form-control" placeholder="RATE">
    </div>
    <div class="form-group col-6">
      <label>USD: </label>
      <input name="usd" type="text" class="form-control" placeholder="USD">
    </div>
    <br/>
    <div>
      <input class="bg-warning" type="submit" id="submit" value="Converter"/>
    </div>
  </div>
</form>
<script src="/bootstrap-5.0.2-dist/js/bootstrap.js"></script>
</body>
</html>
