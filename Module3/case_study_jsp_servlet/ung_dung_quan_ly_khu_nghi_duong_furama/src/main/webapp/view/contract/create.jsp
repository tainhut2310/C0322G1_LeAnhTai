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
<div class="col-lg-12 js-header-nav sticky";
     style="display: block; position: sticky; top: 0px; z-index: 1; background-color: #046056; height: 80px;">
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
                                <li><a class="dropdown-item" href="/facility?action=create">Add new Employee</a></li>
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
            <h3 style="text-align: center">TẠO HỢP ĐỒNG</h3>
            <form method="post" action="/contract?action=create">
                <div class="mb-2">
                    <label class="form-label">Ngày bắt đầu</label>
                    <input name="startDate" type="date" class="form-control">
                </div>
                <div class="mb-2">
                    <label class="form-label">Ngày kết thúc</label>
                    <input name="endDate" type="date" class="form-control">
                </div>
                <div class="mb-2">
                    <label class="form-label">Số tiền cọc trước</label>
                    <input name="phoneNumber" type="text" class="form-control">
                </div>
                <div class="mb-2">
                    <label class="form-label">Tổng tiền thanh toán</label>
                    <input name="deposit" type="text" class="form-control">
                </div>
                <div class="mb-2">
                    <label class="form-label">Tên nhân viên</label>
                </div>
                <div class="mb-2">
                    <label class="form-label">Tên khách hàng</label>
                </div>
                <div class="mb-2">
                    <label class="form-label">Tên dịch vụ</label>
                </div>
                <div class="mb-2">
                    <label class="form-label">Dịch vụ đi kèm: </label>
                    <a href="#addContractDetailModal" data-toggle="modal">
                        <button type="button" class="btn btn-primary">
                            +
                        </button>
                    </a>
                </div>
                <div style="text-align: center">
                    <a href="\view\contract\list.jsp"><input class="btn btn-primary" type="button" value="Hủy bỏ"></a>
                    <button type="submit" class="btn btn-primary">Tạo hợp động</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Add Modal Contract Detail HTML -->
<div id="addContractDetailModal" class="modal fade" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Tạo hợp đồng chi tiết</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã hợp đồng</label>
                        <input type="number" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Tên dịch vụ đi kèm</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Số lượng</label>
                        <input type="number" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="HỦy bỏ">
                    <input type="submit" class="btn btn-success" value="Tạo hợp đồng chi tiết">
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <footer class="text-center text-lg-start bg-white text-muted">
                <section class="">
                    <div class="container-fluid text-center text-md-start mt-5">
                        <div class="row mt-3">
                            <div class=" col-lg-7">
                                <!-- Content -->
                                <h2 class="text-uppercase fw-bold mb-4">
                                    <i class="fas fa-gem me-3 text-grayish"></i>Hướng dẫn di chuyển
                                </h2>
                                <p>
                                    Khu nghỉ dưỡng Furama là cơ sở hàng đầu để khám phá một trong những điểm đến hấp dẫn nhất Châu Á.
                                    Chỉ cách Đà Nẵng một quãng lái xe ngắn là bốn Di sản Văn hóa Thế giới được UNESCO công nhận:
                                </p>
                            </div>

                            <div class="col-lg-5 ">
                                <h6 class="text-uppercase fw-bold mb-4">Liên hệ</h6>
                                <p><i class="fas fa-home me-3 text-grayish"></i>103-105 Vo Nguyen Giap Street, Khue My ward,
                                    Ngu Hanh Son District, Danang City, Vietnam</p>
                                <p><i class="fas fa-phone me-3 text-grayish"></i>Tel: + 01 234 567 88* Fax:84-236-3847-666</p>
                                <p><i class="fas fa-print me-3 text-grayish"></i>Email: reservation@furamavietnam.com</p>
                                <p><i class="fas fa-print me-3 text-grayish"></i>GDS Codes: Amadeus-GD DADFUR, Galieo/Apol-GD 16236lo</p>
                            </div>
                        </div>
                    </div>
                </section>

                <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
                    © 2018 Copyright:
                    <a class="text-reset fw-bold" href="https://mdbootstrap.com/">Furama Resort Danang.</a>
                </div>
                <!-- Copyright -->
            </footer>
        </div>
    </div>
</div>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

