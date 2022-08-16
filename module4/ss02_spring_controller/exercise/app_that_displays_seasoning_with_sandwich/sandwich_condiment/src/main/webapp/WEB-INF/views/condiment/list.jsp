<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/16/2022
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<hr>
<form style="align-content: center" action="/condiment" method="post">
    <c:forEach var="condiment" items="${condimentList}" varStatus="status">
        <input type="checkbox" name="condiment" value="${condiment}">${condiment}
    </c:forEach>
    <br>
    <input type="submit" value="Save">
    <br>
    <c:if test="${condiments!=null}">
        <h2>Danh sách gia vị bạn đã chọn là: ${condiments} </h2>
    </c:if>
</form>
</body>
</html>
