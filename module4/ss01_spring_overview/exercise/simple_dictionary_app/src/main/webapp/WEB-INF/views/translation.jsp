<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/14/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="translate" method="get">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/>
</form>
<h2>Result: ${result} </h2>
</body>
</html>
