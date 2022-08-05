package controllers;

import model.Facility;
import model.FacilityType;
import model.RentType;
import service.IFacilityService;
import service.IFacilityTypeService;
import service.IRentTypeService;
import service.impl.FacilityService;
import service.impl.FacilityTypeService;
import service.impl.RentTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();
    private IRentTypeService rentTypeService = new RentTypeService();
    private IFacilityTypeService facilityTypeService = new FacilityTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                default:
                    listFacility(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Facility> facilityList = facilityService.selectAll();
        request.setAttribute("facilityList", facilityList);
        List<RentType> rentTypeList = rentTypeService.selectAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.selectAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        dispatcher.forward(request, response);
    }
}
