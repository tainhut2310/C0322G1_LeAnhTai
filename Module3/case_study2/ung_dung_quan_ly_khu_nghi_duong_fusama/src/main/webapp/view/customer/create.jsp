<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="text-align: center">THÊM THÔNG TIN KHÁCH HÀNG</h3>
    <form method="post" action="/customer?action=create">

        <div class="mb-2">
            <label class="form-label">Tên khách hàng</label>
            <input name="name" type="text" class="form-control" size="50">
        </div>
        <div class="mb-2">
            <label  class="form-label">Ngày sinh</label>
            <input name="dateOfBirth" type="date" class="form-control" size="50">
        </div>
        <div class="mb-2">
            <label  class="form-label">Số CMND</label>
            <input name="idCard" type="text" class="form-control" size="50">
        </div>
        <div class="mb-2">
            <label  class="form-label">Số điện thoại</label>
            <input name="phoneNumber" type="text" class="form-control" size="50">
        </div>
        <div class="mb-2">
            <label  class="form-label">Email</label>
            <input name="email" type="text" class="form-control" size="50">
        </div>
        <div class="mb-2">
            <label class="form-label">Địa chỉ</label>
            <input name="address" type="text" class="form-control" size="50">
        </div>
        <div class="mb-2">
            <label  class="form-label">Kiểu khách hàng</label>
            <select name="typeOfCustomer">
                <option value="">Chọn kiểu khách</option>
                <c:forEach items="${customerTypeList}" var="item">
                    <option value="${item.customerTypeId}">${item.customerTypeName}</option>
                </c:forEach>
            </select>
        </div>
        <label class="form-label">Giới tính</label>
        <select name="gender">
            <option value="1">Nam</option>
            <option value="0">Nữ</option>
        </select>
        <br>
        <div style="text-align: center">
        <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
