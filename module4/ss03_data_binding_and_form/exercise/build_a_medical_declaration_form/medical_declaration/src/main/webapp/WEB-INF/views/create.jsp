<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/17/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h3>TỜ KHAI Y TẾ</h3>
        <h5>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH
            BỆNH TRUYỀN NHIỄM</h5>
        <p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
    </div>
    <form:form method="POST" action="/create" modelAttribute="medicalDeclaration">
    <div class="row">
        <label>Họ tên(ghi chữ IN HOA) </label>
        <form:input path="name" cssClass="form-control" required="true" pattern="[A-Z\\s]+"/>
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
        <form:input path="idCard" required="true"/>
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
    <a href="/"><input  type="button" value="Quay lại"></a>
    <button type="submit">Lưu</button>
</div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
