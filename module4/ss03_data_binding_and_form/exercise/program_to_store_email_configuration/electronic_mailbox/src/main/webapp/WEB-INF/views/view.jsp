<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/17/2022
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>Language: </td>
            <td>${emailSettings.languages}</td>
        </tr>
        <tr>
            <td>Page size: </td>
            <td>${emailSettings.pageSize}</td>
        </tr>
        <tr>
            <td>Spams Filter: </td>
            <td>${emailSettings.spamsFilter}</td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td>${emailSettings.signature}</td>
        </tr>
    </table>
</body>
</html>
