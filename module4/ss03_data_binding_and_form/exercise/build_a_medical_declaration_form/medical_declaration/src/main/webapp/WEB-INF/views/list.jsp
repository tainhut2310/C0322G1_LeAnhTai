<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/17/2022
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="text-align: center">DANH SÁCH TỜ KHAI BÁO Y TẾ</h3>
<div style="text-align: center">
    <a href="/create"><input type="button" value="Create"></a>
</div>
<table id="tableCustomer" class="table table-striped table-hover" border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Năm sinh</th>
        <th>Giới tính</th>
        <th>Quốc tịch</th>
        <th>Số CMND</th>
        <th>Thông tin đi lại</th>
        <th>Số hiệu phương tiện</th>
        <th>Số ghế</th>
        <th>Ngày khởi hành</th>
        <th>Ngày kết thúc</th>
        <th>Trong vòng 14 ngày qua có đi đến TP nào?</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="medicalDeclaration" items="${medicalDeclaration}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${medicalDeclaration.name}</td>
            <td>${medicalDeclaration.dateOfBirthday}</td>
            <td>${medicalDeclaration.gender}</td>
            <td>${medicalDeclaration.nationality}</td>
            <td>${medicalDeclaration.idCard}</td>
            <td>${medicalDeclaration.travelInformation}</td>
            <td>${medicalDeclaration.vehicleNumber}</td>
            <td>${medicalDeclaration.seats}</td>
            <td>${medicalDeclaration.departureDay}/${medicalDeclaration.departureMonth}/${medicalDeclaration.departureYear}</td>
            <td>${medicalDeclaration.endDay}/${medicalDeclaration.endMonth}/${medicalDeclaration.endYear}</td>
            <td>${medicalDeclaration.describe}</td>
            <td><a href="/update?idCard=${medicalDeclaration.idCard}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
