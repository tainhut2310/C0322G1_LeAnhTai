package controllers;

import model.CustomerType;
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
import java.util.Map;

@WebServlet(name = "FacilityServlet", urlPatterns = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();
    private IRentTypeService rentTypeService = new RentTypeService();
    private IFacilityTypeService facilityTypeService = new FacilityTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    save(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                default:
                    listFacility(request, response);
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
                    showNewForm(request, response);
                    break;
                case "search":
                    showListSearch(request, response);
                    break;
                case "update":
                    showUpdateForm(request, response);
                    break;
                default:
                    listFacility(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<FacilityType> facilityTypeList = facilityTypeService.selectAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.selectAll();
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityType"));

        double poolArea = 0;
        int numberOfFloors = 0;
        String standardRoom = null;
        String descriptionOtherConvenience = null;
        String facilityFree = null;
        if (facilityTypeId == 1) {
            poolArea = Double.parseDouble(request.getParameter("poolArea"));

            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));

            standardRoom = request.getParameter("standardRoom");

            descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        } else if (facilityTypeId == 2) {
            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));

            standardRoom = request.getParameter("standardRoom");

            descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        } else {
            facilityFree = request.getParameter("facilityFree");
        }
        Map<String, String> errorsMap = facilityService.insert(new Facility(name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId));
        String messenger = "THÊM MỚI KHÔNG THÀNH CÔNG";
        if (errorsMap.size() > 0) {
            List<RentType> rentTypeList = rentTypeService.selectAll();
            request.setAttribute("rentTypeList", rentTypeList);
            List<FacilityType> facilityTypeList = facilityTypeService.selectAll();
            request.setAttribute("facilityTypeList", facilityTypeList);

            request.setAttribute("errorsMap", errorsMap);
            request.setAttribute("messenger", messenger);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
            dispatcher.forward(request, response);
        } else {
            List<RentType> rentTypeList = rentTypeService.selectAll();
            request.setAttribute("rentTypeList", rentTypeList);
            List<FacilityType> facilityTypeList = facilityTypeService.selectAll();
            request.setAttribute("facilityTypeList", facilityTypeList);

            messenger = "THÊM MỚI THÀNH CÔNG";
            request.setAttribute("messenger", messenger);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.selectById(id);
        request.setAttribute("facility", facility);
        List<RentType> rentTypeList = rentTypeService.selectAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.selectAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/update.jsp");
        dispatcher.forward(request, response);
    }

    private void showListSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        List<Facility> facilityList = facilityService.selectByName(nameSearch);
        request.setAttribute("facilityList", facilityList);
        List<RentType> rentTypeList = rentTypeService.selectAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<FacilityType> facilityTypeList = facilityTypeService.selectAll();
        request.setAttribute("facilityTypeList", facilityTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/facility/list.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityType"));

        double poolArea = 0;
        int numberOfFloors = 0;
        String standardRoom = null;
        String descriptionOtherConvenience = null;
        String facilityFree = null;
        if (facilityTypeId == 1) {
            poolArea = Double.parseDouble(request.getParameter("poolArea"));

            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));

            standardRoom = request.getParameter("standardRoom");

            descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        } else if (facilityTypeId == 2) {
            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));

            standardRoom = request.getParameter("standardRoom");

            descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        } else {
            facilityFree = request.getParameter("facilityFree");
        }
        facilityService.update(new Facility(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience,
                poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId));
       response.sendRedirect("/facility");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        facilityService.delete(id);
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
