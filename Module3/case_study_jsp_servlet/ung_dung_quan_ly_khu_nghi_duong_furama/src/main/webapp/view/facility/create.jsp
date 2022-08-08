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
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
    <title>Ứng dụng quản lý khu nghỉ dưỡng Fusama</title>
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
                    <h3 style="text-align: center">THÊM MỚI DỊCH VỤ</h3>
                    <form method="post" action="/facility?action=create">
                        <c:if test="${messenger != null}">
                            <div class="mb-2">
                                <label class="form-label">${messenger}</label>
                            </div>
                        </c:if>
                        <div class="mb-2">
                                <label class="form-label">Kiểu dịch vụ</label>
                                <select class = "form-control" name="facilityType" id="facilityType" onchange="facilityTypeChanged(this.value)">
                                    <option value = "">Chọn kiểu dịch vụ</option>
                                    <c:forEach var="FacilityType" items="${facilityTypeList}">
                                        <option value = "${FacilityType.id}">${FacilityType.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        <div class="mb-2">
                            <label class="form-label">Tên dịch vụ</label>
                            <input name="name" type="text" class="form-control">
                            <p class="text-danger">${errorsMap.get("name")}</p>
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Diện tích sử dụng</label>
                            <input name="area" type="text" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Chi phí thuê</label>
                            <input name="cost" type="text" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Số lượng người tối đa</label>
                            <input name="maxPeople" type="number" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label class="form-label">Kiểu thuê</label>
                            <select class = "form-control" name="rentTypeId">
                                <option value = "">Chọn kiểu thuê</option>
                                <c:forEach var="RentType" items="${rentTypeList}">
                                    <option value = "${RentType.id}">${RentType.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-2" id="standardRoom" hidden>
                            <label class="form-label">Tiêu chuẩn phòng</label>
                            <input name="standardRoom" type="text" class="form-control">
                        </div>
                        <div class="mb-2" id="descriptionOtherConvenience" hidden>
                            <label class="form-label">Mô tả tiện nghi khác</label>
                            <textarea name="descriptionOtherConvenience" type="text" class="form-control"></textarea>
                        </div>
                        <div class="mb-2" id="poolArea" hidden>
                            <label class="form-label">Diện tích hồ bơi</label>
                            <input name="poolArea" type="text" class="form-control">
                        </div>
                        <div class="mb-2" id="numberOfFloors" hidden>
                            <label class="form-label">Số tầng</label>
                            <input name="numberOfFloors" type="number" class="form-control">
                        </div>
                        <div class="mb-2" id="facilityFree" hidden>
                            <label class="form-label">Dịch vụ miễn phí đi kèm</label>
                            <input name="facilityFree" type="text" class="form-control">
                        </div>
                        <div style="text-align: center">
                            <a href="/facility"><input class="btn btn-primary" type="button" value="Quay lại"></a>
                            <button type="submit" class="btn btn-primary">Lưu</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../include/footer.jsp"%>
<script>
    function facilityTypeChanged(value) {
        if (value == 1) {
            document.getElementById("standardRoom").hidden = false;
            document.getElementById("descriptionOtherConvenience").hidden = false;
            document.getElementById("poolArea").hidden = false;
            document.getElementById("numberOfFloors").hidden = false;
            document.getElementById("facilityFree").hidden = true;
        } else if (value == 2) {
            document.getElementById("standardRoom").hidden = false;
            document.getElementById("descriptionOtherConvenience").hidden = false;
            document.getElementById("poolArea").hidden = true;
            document.getElementById("numberOfFloors").hidden = false;
            document.getElementById("facilityFree").hidden = true;
        } else if(value == 3) {
            document.getElementById("standardRoom").hidden = true;
            document.getElementById("descriptionOtherConvenience").hidden = true;
            document.getElementById("poolArea").hidden = true;
            document.getElementById("numberOfFloors").hidden = true;
            document.getElementById("facilityFree").hidden = false;
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>



