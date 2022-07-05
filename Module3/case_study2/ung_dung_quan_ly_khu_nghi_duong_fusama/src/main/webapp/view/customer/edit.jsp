<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/5/2022
  Time: 10:40 AM
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
    <h3 style="text-align: center">CHỈNH SỬA THÔNG TIN KHÁCH HÀNG</h3>
    <form method="post" action="/customer?action=update">
        <div class="mb-2">
            <label class="form-label">ID</label>
            <input type="text" name="id" class="form-control" size="45" value="${customer.id}">
        </div>
        <div class="mb-2">
            <label class="form-label">Tên khách hàng</label>
            <input type="text" name="name" class="form-control" size="45" value="${customer.name}">
        </div>
        <div class="mb-2">
            <label  class="form-label">Ngày sinh</label>
            <input type="text" name="dateOfBirth" class="form-control" size="45" value="${customer.dateOfBirth}">
        </div>
        <div class="mb-2">
            <label  class="form-label">Giới tính</label>
            <select name="gender">
                <c:if test="${customer.gender==1}">
                    <option value="1" selected>Nam</option>
                    <option value="0">Nữ</option>
                </c:if>
                <c:if test="${customer.gender==0}">
                    <option value="1">Nam</option>
                    <option value="0" selected>Nữ</option>
                </c:if>
            </select>
        </div>
        <div class="mb-2">
            <label  class="form-label">Số CMND</label>
            <input type="text" name="idCard" class="form-control" size="45" value="${customer.idCard}">
        </div>

        <div class="mb-2">
            <label  class="form-label">Số điện thoại</label>
            <input type="text" name="phoneNumber" class="form-control" size="45" value="${customer.phoneNumber}">
        </div>
        <div class="mb-2">
            <label class="form-label">Email</label>
            <input type="text" name="email" class="form-control" size="45" value="${customer.email}">
        </div>
        <div class="mb-2">
            <label class="form-label">Địa chỉ</label>
            <input type="text" name="address" class="form-control" size="45" value="${customer.address}">
        </div>
        <div class="mb-2">
            <label  class="form-label">Kiểu khách hàng</label>
            <select name="typeOfCustomer">
                <option value="">Chọn kiểu khách</option>
                <c:forEach items="${customerTypeList}" var="customerType">
                    <c:if test="${customerType.customerTypeId == customer.typeOfCustomer}">
                        <option value="${customerType.customerTypeId}" selected>${customerType.customerTypeName}</option>
                    </c:if>
                    <c:if test="${customerType.customerTypeId != customer.typeOfCustomer}">
                        <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
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
