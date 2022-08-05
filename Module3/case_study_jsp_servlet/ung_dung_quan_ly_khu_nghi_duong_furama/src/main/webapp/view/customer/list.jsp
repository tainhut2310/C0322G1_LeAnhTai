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
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/view/css/file.css">
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
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                EMPLOYEE
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="\view\employee\list.jsp">Employee List</a></li>
                                <li><a class="dropdown-item" href="\view\employee\create.jsp">Add new employee</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                CUSTOMER
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="\view\customer\list.jsp">Customer List</a></li>
                                <li><a class="dropdown-item" href="\view\customer\create.jsp">Add new customer</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                FACILITY
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="\view\facility\list.jsp">Facility List</a></li>
                                <li><a class="dropdown-item" href="\view\facility\create.jsp">Add new facility</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                CONTRACT
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="\view\contract\list.jsp">Contract List</a></li>
                                <li><a class="dropdown-item" href="\view\contract\create.jsp">Add new contract</a></li>
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
        <div class="col-lg-2"></div>
        <div class="col-lg-10">
            <div class="row">
                <div class="container-fluid">
                    <div class="table-responsive">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <h2>Manage <b>Customer</b></h2>
                                    </div>
                                    <div class="col-xs-6">
                                        <a href="/customer?action=create" class="btn btn-success" data-toggle="modal"><i
                                                class="material-icons">&#xE147;</i> <span>Add New Customer</span></a>
                                    </div>
                                </div>
                            </div>
                            <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%"
                                   class="table" border="1">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Ngày sinh</th>
                                    <th>Giới tính</th>
                                    <th>Số CMND</th>
                                    <th>Số điên thoại</th>
                                    <th>Email</th>
                                    <th>Địa chỉ</th>
                                    <th>Kiểu khách hàng</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="Customer" items="${customerList}">
                                <tr>
                                    <td>${Customer.id}</td>
                                    <td>${Customer.name}</td>
                                    <td>${Customer.dateOfBirthday}</td>
                                    <td>${Customer.gender == 1 ? "Nam" : "Nữ"}</td>
                                    <td>${Customer.idCard}</td>
                                    <td>${Customer.phoneNumber}</td>
                                    <td>${Customer.email}</td>
                                    <td>${Customer.address}</td>
                                    <c:forEach var="CustomerType" items="${customerTypeList}">
                                        <c:if test="${CustomerType.id==Customer.customerTypeId}">
                                            <td>${CustomerType.name}</td>
                                        </c:if>
                                    </c:forEach>
                                    <td>
                                        <a href="update.jsp" class="edit"><i class="material-icons"
                                                                             data-toggle="tooltip"
                                                                             title="Edit">&#xE254;</i></a>
                                        <a href="#deleteCustomerModal" class="delete" data-toggle="modal"><i
                                                class="material-icons"
                                                data-toggle="tooltip"
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

<div id="deleteCustomerModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
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
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</body>
</html>