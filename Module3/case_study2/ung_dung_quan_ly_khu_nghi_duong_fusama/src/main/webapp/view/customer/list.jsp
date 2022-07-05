<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/3/2022
  Time: 8:39 PM
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
<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://du-lich.chudu24.com/f/m/2204/08/46741cbc-7cb9-4ccf-ac09-07b7f4fdc76d.jpeg?w=800&c=1" class="d-block w-100" height="300" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://bazantravel.com/cdn/medias/uploads/53/53126-furama-resort-da-nang-16-700x494.jpg" class="d-block w-100" height="300" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://m.justgola.com/media/a/00/17/97982_lg_1.jpeg" height="300" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<nav class="navbar navbar-expand-lg bg-light">
    <div style="background-color: lightgreen" class="container-fluid">
        <a class="navbar-brand" href="\index.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="\employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Service
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Contract</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <!--        <div class="col-lg-12">-->
        <div class="col-lg-3 col-md-6 col-sm-12">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <img src="https://cdn1.ivivu.com/iVivu/2019/11/28/13/64261840-cr-800x450.jpg" width="100%" height="240" class="d-block w-100" alt="...">
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <img src="https://pix10.agoda.net/hotelImages/365/3651207/3651207_17121510060060423670.jpg?s=1024x768" width="100%" height="240" class="d-block w-100" alt="...">
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <img src="https://danatourism.com.vn/wp-content/uploads/2018/10/Vietnam_Danang_Furama_Villas_Beach_Pool_Villas-Sea-View-FILEminimizer.jpg" width="100%" height="240" class="d-block w-100" alt="...">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-9 col-md-6 col-sm-12 ">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h3 style="text-align: center">DANH SÁCH KHÁCH HÀNG</h3>
                        <form style="text-align: center" action="/customer">
                            <input style="background-color: deepskyblue;" type="submit" name="action" value="Thêm mới khách hàng">
                        </form>
                        <table class="table" border="1">
                            <tr>
                                <th>ID</th>
                                <th>Tên khách hàng</th>
                                <th>Ngày sinh</th>
                                <th>Giới tính</th>
                                <th>Số CMND</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Địa chỉ</th>
                                <th>Loại khách</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <c:forEach items="${customerList}" var="Customer">
                                <tr>
                                    <td> ${Customer.id} </td>
                                    <td> ${Customer.name} </td>
                                    <td> ${Customer.dateOfBirth} </td>
                                    <c:if test="${Customer.gender==1}">
                                        <td> Nam </td>
                                    </c:if>
                                    <c:if test="${Customer.gender==0}">
                                        <td> Nữ </td>
                                    </c:if>
                                    <td> ${Customer.idCard} </td>
                                    <td> ${Customer.phoneNumber} </td>
                                    <td> ${Customer.email} </td>
                                    <td> ${Customer.address} </td>
                                    <c:forEach items="${customerTypeList}" var="CustomerType">
                                        <c:if test="${CustomerType.customerTypeId==Customer.typeOfCustomer}">
                                            <td>${CustomerType.customerTypeName}</td>
                                        </c:if>
                                    </c:forEach>
                                    <td><a href="/customer?action=edit&id=${Customer.id}">Edit</a></td>
                                    <td><a href="/customer?action=delete&id=${Customer.id}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--        </div>-->
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
