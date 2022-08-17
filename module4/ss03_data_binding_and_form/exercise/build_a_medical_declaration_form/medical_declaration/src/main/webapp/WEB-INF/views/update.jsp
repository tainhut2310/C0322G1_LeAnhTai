<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/17/2022
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>CHỈNH SỬA TỜ KHAI Y TẾ</h3>
    <form:form method="POST" action="/update" modelAttribute="medicalDeclaration">
    <div class="row">
        <label>Họ tên(ghi chữ IN HOA) </label>
        <form:input path="name" cssClass="form-control"/>
    </div>
    <br>
    <div class="row">
        <div class="col-4">
            <form:label path="dateOfBirthday">Năm sinh: </form:label>
            <form:select path="dateOfBirthday" items="${year}" required="true"/>
        </div>

        <div class="col-4">
            <form:label path="gender">Giới tính: </form:label>
            <form:select path="gender" items="${gender}" required="true"/>
        </div>

        <div class="col-4">
            <form:label path="nationality">Quốc tịch: </form:label>
            <form:select path="nationality" items="${nationality}" required="true"/>
        </div>
    </div>
    <br>
    <div class="row">
        <form:label path="idCard">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác: </form:label>
        <form:input path="idCard" disabled="true" required="true"/>
    </div>
    <br>
    <div class="row">
        <form:label path="travelInformation">Thông tin đi lại: </form:label>
        <form:radiobuttons path="travelInformation" items="${travelInformation}" required="true"/>
    </div>
    <br>
    <div class="row">
        <div class="row">
            <div class="col-6">
                <form:label path="vehicleNumber">Số hiệu phương tiện: </form:label>
            </div>
            <div class="col-6">
                <form:label path="seats">Số ghế: </form:label>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <form:input path="vehicleNumber" required="true"/>
            </div>
            <div class="col-6">
                <form:input path="seats" required="true"/>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-2">
            <label>Ngày khởi hành: </label>
            <form:select path="departureDay" items="${day}" required="true"/>
        </div>
        <div class="col-2">
            <form:select path="departureMonth" items="${month}" required="true"/>
        </div>
        <div class="col-2">
            <form:select path="departureYear" items="${year}" required="true"/>
        </div>
        <div class="col-2">
            <label>Ngày khởi hành: </label>
            <form:select path="endDay" items="${day}" required="true"/>
        </div>
        <div class="col-2">
            <form:select path="endMonth" items="${month}" required="true"/>
        </div>
        <div class="col-2">
            <form:select path="endYear" items="${year}" required="true"/>
        </div>
    </div>
    <br>
    <div class="row">
        <form:label path="describe">Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào? </form:label>
        <form:textarea path="describe" required="true"/>
    </div>
</div>
<div style="text-align: center">
    <a href="/"><input type="button" value="Quay lại"></a>
    <button type="submit">Lưu</button>
</div>
</form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
