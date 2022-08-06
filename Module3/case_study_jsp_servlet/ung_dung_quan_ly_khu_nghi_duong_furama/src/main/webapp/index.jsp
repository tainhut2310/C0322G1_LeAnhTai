<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2022
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng quản lý khu nghỉ dưỡng Fusama</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
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
<div class="col-lg-12 js-header-nav sticky" ;
     style="display: block; position: sticky; top: 0px; z-index: 1; background-color: #046056;">
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
                            <a style="color: white" class="nav-link" href="/employee" role="button">
                                EMPLOYEE
                            </a>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                CUSTOMER
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/customer">Customer List</a></li>
                                <li><a class="dropdown-item" href="\view\customer\create.jsp">Add new customer</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                FACILITY
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/facility">Facility List</a></li>
                                <li><a class="dropdown-item" href="\view\facility\create.jsp">Add new facility</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a style="color: white" class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                CONTRACT
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/contract">Contract List</a></li>
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
            <img src="img_icon/furama resort (2).jpg" width="100%" height="500" alt="">
        </div>
    </div>
    <div class="container" style="padding-left: 15px; padding-right: 15px;">
        <div class="row">
            <div class="col-lg-4">
                <h2 style="font-size: 24px;color: #cbbe73;line-height: 36px;text-align: left;font-family:Playfair Display;font-weight:700;font-style:normal"
                    class="vc_custom_heading">
                    KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT
                    NAM.</h2>
            </div>
            <div class="col-lg-4">
                <div class="wpb_column vc_column_container vc_col-sm-4">
                    <a href="https://www.youtube.com/watch?v=IjlT_4mvd-c" class="video-btn js-video-btn">
                        <img width="1000" height="754" src="https://furamavietnam.com/wp-content/
                    uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg" class="img-fluid"
                             alt="" srcset="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg
                                             1000w, https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach-300x226.jpg
                                             300w, https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach-768x579.jpg
                                             768w, https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach-747x563.jpg
                                             747w, https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach-370x279.jpg
                                             370w, https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach-317x239.jpg
                                             317w, https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Beach-139x105.jpg
                                             139w" sizes="(max-width: 1000px) 100vw, 1000px">
                    </a>
                    <div class="vc_empty_space" style="height: 32px"><span class="vc_empty_space_inner"></span></div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="wpb_text_column wpb_content_element ">
                    <div class="wpb_wrapper">
                        <p style="text-align: justify;">Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà
                            Nẵng
                            là cửa ngõ đến với 3 di sản văn hoá thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2
                            tiếng. 196 phòng hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ có hồ bơi riêng
                            đều
                            được trang trí trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến trúc
                            thuộc
                            địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón
                            tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao điện ảnh và các nhà lãnh
                            đạo
                            kinh doanh quốc tế.</p>

                    </div>
                </div>
                <div class="vc_empty_space" style="height: 32px"><span class="vc_empty_space_inner"></span></div>
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
</body>
</html>
