<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    float listPrice = Float.parseFloat(request.getParameter("txtDescribeProduct"));
    float discountPercent = Float.parseFloat(request.getParameter("numberDiscountRate"));
    double discountAmount = listPrice * discountPercent * 0.01;
%>
<h1>Result</h1>
<h1><%=listPrice%></h1>
<h1><%=discountPercent%></h1>
<h1><%=discountAmount%></h1>
</body>
</html>
