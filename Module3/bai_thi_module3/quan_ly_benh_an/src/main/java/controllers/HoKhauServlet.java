package controllers;

import models.HoKhau;
import models.HoKhauChiTiet;
import service.IBenhAnService;
import service.IBenhNhanService;
import service.impl.BenhAnServiceImpl;
import service.impl.BenhNhanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BenhAnServlet", urlPatterns = "/benhAn")
public class BenhAnServlet extends HttpServlet {
    private IBenhAnService benhAnService = new BenhAnServiceImpl();
    private IBenhNhanService benhNhanService = new BenhNhanServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createBenhAn(request, response);
                    break;
                case "edit" :
                    editBenhAn(request, response);
                    break;
                case "delete":
                    deleteBenhAn(request, response);
                    break;
                default:
                    showListBenhAn(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreate(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "search":
                    showSearchForm(request, response);
                    break;
                default:
                    showListBenhAn(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showListBenhAn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<HoKhau> hoKhauList = benhAnService.display();
        request.setAttribute("benhAnList", hoKhauList);

        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<HoKhau> hoKhauList1 = benhAnService.display();
        String idBenhAn = "";
        int max = 0;
        if (hoKhauList1.size() == 0) {
            idBenhAn = "BA-001";
        } else {
            for (HoKhau item : hoKhauList1) {
                if (Integer.parseInt(item.getIdBenhAn().split("-")[1]) > max) {
                    max = Integer.parseInt(item.getIdBenhAn().split("-")[1]);
                }
                idBenhAn = "BA-" + String.format("%3s", max + 1).replaceAll(" ", "0");
            }
        }
        String idBenhNhan = request.getParameter("idBenhNhan");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDoNhapVien = request.getParameter("lyDoNhapVien");
        HoKhau hoKhau = new HoKhau(idBenhAn, ngayNhapVien, ngayRaVien, lyDoNhapVien, idBenhNhan );

        Map<String, String> map = benhAnService.addNew(hoKhau);

        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        if (map.isEmpty()) {
            List<HoKhau> hoKhauList = benhAnService.display();
            request.setAttribute("benhAnList", hoKhauList);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/list.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("messenger", "THÊM MỚI KHÔNG THÀNH CÔNG!");
            request.setAttribute("errorMap", map);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/benh-an/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("idEdit");

        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        HoKhau hoKhau = benhAnService.showEditForm(id);
        request.setAttribute("benhAn", hoKhau);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idBenhAn = request.getParameter("idBenhAn");
        String ngayNhapVien = request.getParameter("ngayNhapVien");
        String ngayRaVien = request.getParameter("ngayRaVien");
        String lyDoNhapVien = request.getParameter("lyDoNhapVien");
        String idBenhNhan = request.getParameter("idBenhNhan");

        HoKhau hoKhau = new HoKhau(idBenhAn, ngayNhapVien, ngayRaVien, lyDoNhapVien, idBenhNhan);
        benhAnService.edit(hoKhau);
        List<HoKhau> hoKhauList = benhAnService.display();
        request.setAttribute("benhAnList", hoKhauList);

        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("idDelete");

        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        HoKhau hoKhau = benhAnService.showEditForm(id);
        request.setAttribute("benhAn", hoKhau);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idDelete = request.getParameter("idBenhAn");
        benhAnService.delete(idDelete);

        List<HoKhau> hoKhauList = benhAnService.display();
        request.setAttribute("benhAnList", hoKhauList);

        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        List<HoKhau> hoKhauList = benhAnService.search(nameSearch);
        request.setAttribute("benhAnList", hoKhauList);
        List<HoKhauChiTiet> hoKhauChiTietList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", hoKhauChiTietList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/benh-an/list.jsp");
        requestDispatcher.forward(request, response);

    }
}
