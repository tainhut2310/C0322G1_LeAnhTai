<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/31/2022
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <form action="/users">
        <input type="search" placeholder="Enter Country" name="countrySearch">
        <button type="submit" name="action" value="search">SEARCH</button>
    </form>
    <a href="/users?action=sort"><button type="button">SORT BY NAME</button></a>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country}</td>
                <td>
                    <a href="/users?action=edit&id=${user.id}"><button type="button">Edit</button></a>
                    <a href="/users?action=delete&id=${user.id}"><button type="button">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
