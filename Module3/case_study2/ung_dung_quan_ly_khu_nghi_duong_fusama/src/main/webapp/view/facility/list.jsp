<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/3/2022
  Time: 11:09 AM
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
<table class="table">
    <tr>
        <th>ID</th>
        <th>Dịch vụ</th>
        <th>Diện tích sử dụng</th>
        <th>Giá thuê</th>
        <th>Số người tối đa</th>
        <th>Kiểu thuê</th>
        <th>Tiêu chuẩn phòng</th>
        <th>Mô tả tiện nghi khác</th>
        <th>Diện tích hồ bơi</th>
        <th>Số tầng</th>
        <th>Dịch vụ miễn phí đi kèm</th>
    </tr>
    <c:forEach items="${facilityList}" var="facility">
        <tr>
            <td> ${facility.idFacility} </td>
            <td> ${facility.nameFacility} </td>
            <td> ${facility.usableArea} </td>
            <td> ${facility.rentalCosts} </td>
            <td> ${facility.maxPeople} </td>
            <td> ${facility.rentalType} </td>
            <c:if test="${facility.idFacility == 1}">
                <td> ${facility.standardRoom} </td>
                <td> ${facility.descriptionOtherConvenience} </td>
                <td> ${facility.areaPool} </td>
                <td> ${facility.numberOfFloors} </td>
                <td> NULL </td>
            </c:if>
            <c:if test="${facility.idFacility == 2}">
                <td> ${facility.standardRoom} </td>
                <td> ${facility.descriptionOtherConvenience} </td>
                <td> NULL </td>
                <td> ${facility.numberOfFloors} </td>
                <td> NULL </td>
            </c:if>
            <c:if test="${facility.idFacility == 3}">
                <td> NULL </td>
                <td> NULL </td>
                <td> NULL </td>
                <td> NULL </td>
                <td> ${facility.facilityFree} </td>
            </c:if>

        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
