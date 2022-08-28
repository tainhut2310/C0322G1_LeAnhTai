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

<%@include file="../include/footer.jsp"%>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

