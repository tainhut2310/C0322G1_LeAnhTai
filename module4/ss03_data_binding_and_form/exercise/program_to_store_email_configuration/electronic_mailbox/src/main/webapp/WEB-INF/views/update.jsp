<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/17/2022
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="POST" action="/update" modelAttribute="emailSettings">
    <table>
        <tr>
            <td><form:label path="languages">Language: </form:label></td>
            <td><form:select path="languages" items="${languages}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size: </form:label></td>
            <td>Show <form:select path="pageSize" items="${sizes}"/> emails per page</td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><a href="/"><input type="button" value="Quay lại"></a></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
