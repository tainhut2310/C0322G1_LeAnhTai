<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ứng dụng quản lý khu nghỉ dưỡng Fusama</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        * {
            box-sizing: border-box;
        }

        [class*="col-"] {
            float: left;
            padding: 10px;
        }

        .row::after {
            clear: both;
            content: "";
            display: block;
        }

        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

    </style>
</head>
<body>
<%@include file="../include/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-10">
            <div class="row">
                <div class="container-fluid">
                    <h3 style="text-align: center">THÊM MỚI THÔNG TIN KHÁCH HÀNG</h3>
                    <form method="post" action="/customer?action=create">
                        <c:if test="${messenger != null}">
                            <div class="mb-2">
                                <label class="form-label">${messenger}</label>
                            </div>
                        </c:if>
                        <div class="mb-2">
                            <label class="form-label">Tên khách hàng</label>
                            <input name="name" type="text" class="form-control">
                            <p class="text-danger">${errorsMap.get("name")}</p>
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Ngày sinh</label>
                            <input name="dateOfBirthday" type="date" class="form-control">
                            <p class="text-danger">${errorsMap.get("dateOfBirthday")}</p>
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Giới tính: </label>
                            <input type="radio" name="gender" value="1">Nam
                            <input type="radio" name="gender" value="0">Nữ
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Số CMND</label>
                            <input name="idCard" type="text" class="form-control">
                            <p class="text-danger">${errorsMap.get("idCard")}</p>
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Số điện thoại</label>
                            <input name="phoneNumber" type="text" class="form-control">
                            <p class="text-danger">${errorsMap.get("phoneNumber")}</p>
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Email</label>
                            <input name="email" type="text" class="form-control">
                            <p class="text-danger">${errorsMap.get("email")}</p>
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Địa chỉ</label>
                            <input name="address" type="text" class="form-control">
                            <p class="text-danger">${errorsMap.get("address")}</p>
                        </div>

                        <div class="mb-2">
                            <label class="form-label">Kiểu khách hàng: </label>
                            <select class = "form-control" name="typeOfCustomer">
                                <option value="">Chọn kiểu khách</option>
                                <c:forEach var="CustomerType" items="${customerTypeList}">
                                    <option value="${CustomerType.id}">${CustomerType.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="text-align: center">
                            <a href="/customer"><input class="btn btn-primary" type="button" value="Quay lại"></a>
                            <button type="submit" class="btn btn-primary">Lưu</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../include/footer.jsp"%>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

