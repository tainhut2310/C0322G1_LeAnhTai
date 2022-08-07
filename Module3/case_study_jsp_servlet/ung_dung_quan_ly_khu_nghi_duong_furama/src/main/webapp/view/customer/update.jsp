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
<div class="container" style="padding-left: 15px; padding-right: 15px;">
    <div class="row">
        <div class="col-lg-3 align-items-center">
            <span><img src="/img_icon/Logo-FURAMA-RESORT.jpg" width="100" height="100"></span>
        </div>
        <div class="col-lg-3">
            <div style="padding-right: 5px; border: solid 1px #CDCDCD">
                <span><img src="/img_icon/moovbike-tripadvisor-5.png" alt="" width="150" height="100"></span>
            </div>

        </div>
        <div class="col-lg-3 align-items-center">
            <p style="font-size: 13px;">103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng,
                Việt Nam</p>
            <p class="txt-sm" style="font-size: 13px;">
                <span>7.0 km</span> từ Sân bay Quốc tế Đà Nẵng
            </p>
        </div>
        <div class="col-lg-3">
            <div>
                <p class="txt-lg">
                    84-236-3847 333/888</p>
                <a href="mailto:reservation@furamavietnam.com">
                    reservation@furamavietnam.com</a>
            </div>
        </div>
    </div>
</div>
<div class="col-lg-12" ; style="background-color: #046056; height: 80px">
    <div class="container">
        <nav style="padding-left: 80px;" class="navbar navbar-expand-lg navbar-light">
            <a style="color: white" class="navbar-brand" href="/index.jsp">HOME</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a style="color: white" class="nav-link" href="/employee" role="button">
                                EMPLOYEE
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                CUSTOMER
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/customer">Customer List</a></li>
                                <li><a class="dropdown-item" href="/customer?action=create">Add new customer</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                FACILITY
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/facility">Facility List</a></li>
                                <li><a class="dropdown-item" href=/facility?action=create">Add new Employee</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                CONTRACT
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/contract">Contract List</a></li>
                                <li><a class="dropdown-item" href="/contract?action=create">Add new contract</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="col-lg-2"></div>
<div class="col-lg-10">
    <div class="row">
        <div class="container-fluid">
            <h3 style="text-align: center">CHỈNH SỬA THÔNG TIN KHÁCH HÀNG</h3>
            <form method="post" action="/customer?action=update">
                <div class="mb-2">
                    <label class="form-label">ID</label>
                    <input name="id" type="text" class="form-control" value="${customer.id}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Tên khách hàng</label>
                    <input name="name" type="text" class="form-control" value="${customer.name}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Ngày sinh</label>
                    <input name="dateOfBirthday" type="date" class="form-control" value="${customer.dateOfBirthday}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Giới tính: </label>
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
                    <label class="form-label">Số CMND</label>
                    <input name="idCard" type="text" class="form-control" value="${customer.idCard}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Số điện thoại</label>
                    <input name="phoneNumber" type="text" class="form-control" value="${customer.phoneNumber}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Email</label>
                    <input name="email" type="text" class="form-control" value="${customer.email}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Địa chỉ</label>
                    <input name="address" type="text" class="form-control" value="${customer.address}">
                </div>
                <div class="mb-2">
                    <label class="form-label">Kiểu khách hàng: </label>
                    <select name="typeOfCustomer">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <c:if test="${customerType.id==customer.customerTypeId}">
                                <option value="${customerType.id}" selected>${customerType.name}</option>
                            </c:if>
                            <c:if test="${customerType.id!=customer.customerTypeId}">
                                <option value="${customerType.id}">${customerType.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div style="text-align: center">
                    <a href="/customer"><input class="btn btn-primary" type="button" value="Quay lại"></a>
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="footer">
    <div style="border: solid 1px beige; height: 100px" class="col-12"></div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>


