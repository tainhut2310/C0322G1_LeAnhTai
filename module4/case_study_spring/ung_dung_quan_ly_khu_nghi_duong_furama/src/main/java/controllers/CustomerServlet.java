package controllers;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

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

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

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
                    listCustomer(request, response);
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
                case "update":
                    showUpdateForm(request, response);
                    break;
                case "search":
                    showListSearch(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Customer> customerList = customerService.selectAll();
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.selectAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
            dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<CustomerType> customerTypeList = customerTypeService.selectAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String dateOfBirthday = request.getParameter("dateOfBirthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerType = Integer.parseInt(request.getParameter("typeOfCustomer"));
        Customer customer = new Customer(name, dateOfBirthday, gender, idCard, phoneNumber, email, address, customerType);
        Map<String, String> errorsMap = customerService.insert(customer);
        String messenger = "THÊM MỚI KHÔNG THÀNH CÔNG";
        if (errorsMap.size() > 0) {
            List<CustomerType> customerTypeList = customerTypeService.selectAll();
            request.setAttribute("customerTypeList", customerTypeList);
            request.setAttribute("customer", customer);

            request.setAttribute("errorsMap", errorsMap);
            request.setAttribute("messenger", messenger);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
            dispatcher.forward(request, response);
        } else {
            List<CustomerType> customerTypeList = customerTypeService.selectAll();
            request.setAttribute("customerTypeList", customerTypeList);

            messenger = "THÊM MỚI THÀNH CÔNG";
            request.setAttribute("messenger", messenger);

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectById(id);
        request.setAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.selectAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/update.jsp");
        dispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirthday = request.getParameter("dateOfBirthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerType = Integer.parseInt(request.getParameter("typeOfCustomer"));
        Customer customer = new Customer(id, name, dateOfBirthday, gender, idCard, phoneNumber, email, address, customerType);
        customerService.update(customer);
        response.sendRedirect("/customer");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.delete(id);
        List<Customer> customerList = customerService.selectAll();
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.selectAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showListSearch(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        List<Customer> customerList = customerService.selectByName(nameSearch);
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.selectAll();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }
}