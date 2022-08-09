package controllers;

import model.*;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionService;
import service.impl.EducationDegreeService;
import service.impl.EmployeeService;
import service.impl.PositionService;

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

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IPositionService positionService = new PositionService();
    private IDivisionService divisionService = new DivisionService();
    private IEducationDegreeService educationDegreeService = new EducationDegreeService();
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
                case "delete":
                    delete(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                default:
                    listEmployee(request, response);
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
                case "search":
                    showListSearch(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAll();
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.selectAll();
        request.setAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.selectAll();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String dateOfBirthday = request.getParameter("dateOfBirthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegree"));
        int divisionId = Integer.parseInt(request.getParameter("division"));
        employeeService.insert(new Employee(name, dateOfBirthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId));

        List<Employee> employeeList = employeeService.selectAll();
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.selectAll();
        request.setAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.selectAll();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idUpdate"));
        String name = request.getParameter("nameUpdate");
        String dateOfBirthday = request.getParameter("dateOfBirthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegree"));
        int divisionId = Integer.parseInt(request.getParameter("division"));
        employeeService.update(new Employee(id, name, dateOfBirthday, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId));

        List<Employee> employeeList = employeeService.selectAll();
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.selectAll();
        request.setAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.selectAll();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.delete(id);
        List<Employee> employeeList = employeeService.selectAll();
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.selectAll();
        request.setAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.selectAll();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showListSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        List<Employee> employeeList = employeeService.selectByName(nameSearch);
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.selectAll();
        request.setAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.selectAll();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAll();
        request.setAttribute("educationDegreeList", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
