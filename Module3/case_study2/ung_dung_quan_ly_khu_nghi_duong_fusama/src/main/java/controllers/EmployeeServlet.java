package controllers;

import models.*;
import services.IDivisionService;
import services.IEducationDegreeService;
import services.IEmployeeService;
import services.IPositionService;
import services.impl.DivisionServiceImpl;
import services.impl.EducationDegreeServiceImpl;
import services.impl.EmployeeServiceImpl;
import services.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();
    private final IDivisionService divisionService = new DivisionServiceImpl();
    private final IEducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private final IPositionService positionService = new PositionServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            default:
                try {
                    showListEmployee(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList", positionList);

        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        request.setAttribute("educationDegreeList", educationDegreeList);

        List<Division> divisionList = divisionService.findAll();
        request.setAttribute("divisionList", divisionList);

        List<Employee> employeeList = employeeService.display();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
