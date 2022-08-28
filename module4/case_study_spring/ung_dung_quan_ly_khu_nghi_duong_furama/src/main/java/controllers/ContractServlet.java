package controllers;

import model.*;
import service.*;
import service.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractService();
    private ICustomerService customerService = new CustomerService();
    private IFacilityService facilityService = new FacilityService();
    private IContractDetailService contractDetailService = new ContractDetailService();
    private IAttachFacilityService attachFacilityService = new AttachFacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createContractDetail":
                    saveContractDetail(request, response);
                    break;
                default:
                    listContract(request, response);
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
                default:
                    listContract(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Contract> contractList = contractService.selectAll();
        request.setAttribute("contractList", contractList);
        List<Facility> facilityList = facilityService.selectAll();
        request.setAttribute("facilityList", facilityList);
        List<Customer> customerList = customerService.selectAll();
        request.setAttribute("customerList", customerList);
        List<ContractDetail> contractDetailList = contractDetailService.selectAll();
        request.setAttribute("contractDetailList", contractDetailList);
        List<AttachFacility> attachFacilityList = attachFacilityService.selectAll();
        request.setAttribute("attachFacilityList", attachFacilityList);
        List<Double> totalMoneyList = contractService.getMoney();
        request.setAttribute("totalMoneyList", totalMoneyList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        dispatcher.forward(request, response);
    }

    private void saveContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        int idContract = Integer.parseInt(request.getParameter("contractId"));
        int idAttachFacility = Integer.parseInt(request.getParameter("idAttachFacility"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        contractDetailService.insert(new ContractDetail(idContract, idAttachFacility, quantity));
        listContract(request, response);
    }
}
