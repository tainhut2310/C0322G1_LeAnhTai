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
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="/view/css/file.css">
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

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            min-width: 1000px;
            background: #fff;
            padding: 20px 25px;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
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
<div class="col-lg-12 js-header-nav sticky" ;
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
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
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

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <div class="row">
                <div class="container-fluid">
                    <div class="table-responsive">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <h2>Manage <b>Employee</b></h2>
                                    </div>
                                    <div class="col-xs-4">
                                        <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                                                class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>
                                    </div>
                                    <div class="col-xs-5">
                                        <form class="d-flex" role="search" action="/employee">
                                            <input class="form-control me-2" type="search" placeholder="search"
                                                   aria-label="Search" name="nameSearch">
                                            <button class="btn btn-success" type="submit" name="action" value="search">
                                                search
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <table id="tableEmployee" class="table table-striped table-hover" border="1">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Name</th>
                                    <th>Ngày sinh</th>
                                    <th>CMND</th>
                                    <th>Lương</th>
                                    <th>Số điện thoại</th>
                                    <th>Email</th>
                                    <th>Địa chỉ</th>
                                    <th>Vị trí</th>
                                    <th>Trình độ</th>
                                    <th>Bộ phận</th>
                                    <th>Sửa</th>
                                    <th>Xóa</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="Employee" items="${employeeList}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${Employee.name}</td>
                                        <td>${Employee.dateOfBirthday}</td>
                                        <td>${Employee.idCard}</td>
                                        <td>${Employee.salary}</td>
                                        <td>${Employee.phoneNumber}</td>
                                        <td>${Employee.email}</td>
                                        <td>${Employee.address}</td>
                                        <c:forEach var="Position" items="${positionList}">
                                            <c:if test="${Employee.positionId==Position.id}">
                                                <td>${Position.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach var="EducationDegree" items="${educationDegreeList}">
                                            <c:if test="${Employee.educationDegreeId==EducationDegree.id}">
                                                <td>${EducationDegree.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:forEach var="Division" items="${divisionList}">
                                            <c:if test="${Employee.divisionId==Division.id}">
                                                <td>${Division.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <td>
                                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"
                                               onclick="infoUpdate('${Employee.id}','${Employee.name}',
                                                       '${Employee.dateOfBirthday}', '${Employee.idCard}',
                                                       '${Employee.salary}', '${Employee.phoneNumber}',
                                                       '${Employee.email}', '${Employee.address}',
                                                       '${Employee.positionId}', '${Employee.educationDegreeId}',
                                                       '${Employee.divisionId}')">
                                                <i class="material-icons" data-toggle="tooltip"
                                                   title="Edit">&#xE254;</i></a>
                                        </td>
                                        <td>
                                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"
                                               onclick="infoDelete('${Employee.id}','${Employee.name}')"><i
                                                    class="material-icons" data-toggle="tooltip"
                                                    title="Delete">&#xE872;</i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--           DeleteModal--%>
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <span>Bạn có chắc chắn muốn xóa:  </span>
                    <span id="nameDelete"></span>
                    <input type="text" hidden name="idDelete" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <p class="text-warning"><small>Hành động này không thể hoàn tác.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/employee?action=create">
                <div class="modal-header">
                    <h4 class="modal-title">Add Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên nhân viên</label>
                        <input name="name" type="text" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Ngày sinh</label>
                        <input name="dateOfBirthday" type="date" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Số CMND</label>
                        <input name="idCard" type="text" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Lương</label>
                        <input name="salary" type="text" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Số điện thoại</label>
                        <input name="phoneNumber" type="text" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>Email</label>
                        <input name="email" type="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Địa chỉ</label>
                        <textarea name="address" class="form-control" required></textarea>
                    </div>

                    <div class="form-group">
                        <label class="form-label">Vị trí</label>
                        <select class="form-control" name="position">
                            <option value="">Chọn vị trí</option>
                            <c:forEach var="Position" items="${positionList}">
                                <option value="${Position.id}">${Position.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label class="form-label">Trình độ</label>
                        <select class="form-control" name="educationDegree">
                            <option value="">Chọn trình độ</option>
                            <c:forEach var="EducationDegree" items="${educationDegreeList}">
                                <option value="${EducationDegree.id}">${EducationDegree.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label class="form-label">Bộ phận</label>
                        <select class="form-control" name="division">
                            <option value="">Chọn bộ phận</option>
                            <c:forEach var="Division" items="${divisionList}">
                                <option value="${Division.id}">${Division.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<%--Edit Modal--%>
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="/employee?action=update">
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID</label>
                        <input name="idUpdate" id="idUpdate" readonly type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Tên nhân viên</label>
                        <input name="nameUpdate" id="nameUpdate" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Ngày sinh</label>
                        <input name="dateOfBirthday" id="dateOfBirthday" type="date" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Số CMND</label>
                        <input name="idCard" id="idCard" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Lương</label>
                        <input name="salary" id="salary" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Số điện thoại</label>
                        <input name="phoneNumber" id="phoneNumber" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input name="email" id="email" type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Địa chỉ</label>
                        <textarea name="address" id="address" class="form-control" required></textarea>
                    </div>

                    <div class="form-group">
                        <label class="form-label">Vị trí</label>
                        <select class="form-control" name="position" id="position">
                            <c:forEach var="Position" items="${positionList}">
                                <option value="${Position.id}">${Position.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label class="form-label">Trình độ</label>
                        <select class="form-control" name="educationDegree" id="educationDegree">
                            <c:forEach var="EducationDegree" items="${educationDegreeList}">
                                <option value="${EducationDegree.id}">${EducationDegree.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="form-label">Bộ phận</label>
                        <select class="form-control" name="division" id="division">
                            <c:forEach var="Division" items="${divisionList}">
                                <option value="${Division.id}">${Division.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
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
                                    Khu nghỉ dưỡng Furama là cơ sở hàng đầu để khám phá một trong những điểm đến hấp dẫn
                                    nhất Châu Á.
                                    Chỉ cách Đà Nẵng một quãng lái xe ngắn là bốn Di sản Văn hóa Thế giới được UNESCO
                                    công nhận:
                                </p>
                            </div>

                            <div class="col-lg-5 ">
                                <h6 class="text-uppercase fw-bold mb-4">Liên hệ</h6>
                                <p><i class="fas fa-home me-3 text-grayish"></i>103-105 Vo Nguyen Giap Street, Khue My
                                    ward,
                                    Ngu Hanh Son District, Danang City, Vietnam</p>
                                <p><i class="fas fa-phone me-3 text-grayish"></i>Tel: + 01 234 567 88*
                                    Fax:84-236-3847-666</p>
                                <p><i class="fas fa-print me-3 text-grayish"></i>Email: reservation@furamavietnam.com
                                </p>
                                <p><i class="fas fa-print me-3 text-grayish"></i>GDS Codes: Amadeus-GD DADFUR,
                                    Galieo/Apol-GD 16236lo</p>
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
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>
<script>
    function infoUpdate(id, name, dateOfBirthday, idCard, salary,
                        phoneNumber, email, address, positionId, educationDegreeId, divisionId) {
        document.getElementById("idUpdate").value = id;
        document.getElementById("nameUpdate").value = name;
        document.getElementById("dateOfBirthday").value = dateOfBirthday;
        document.getElementById("idCard").value = idCard;
        document.getElementById("salary").value = salary;
        document.getElementById("phoneNumber").value = phoneNumber;
        document.getElementById("email").value = email;
        document.getElementById("address").value = address;
        document.getElementById("position").value = positionId;
        document.getElementById("educationDegree").value = educationDegreeId;
        document.getElementById("division").value = divisionId;
    }
</script>
<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>