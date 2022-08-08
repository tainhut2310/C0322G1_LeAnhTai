package controllers;

import model.AttachFacility;
import model.Contract;
import model.ContractDetail;
import service.IAttachFacilityService;
import service.IContractDetailService;
import service.IContractService;
import service.impl.AttachFacilityService;
import service.impl.ContractDetailService;
import service.impl.ContractService;

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
    private IContractDetailService contractDetailService = new ContractDetailService();
    private IAttachFacilityService attachFacilityService = new AttachFacilityService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
//                case "create":
//                    save(request, response);
//                    break;
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
//                case "create":
//                    save(request, response);
//                    break;
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
        List<AttachFacility> attachFacilityList = attachFacilityService.selectAll();
        request.setAttribute("attachFacilityList", attachFacilityList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/list.jsp");
        dispatcher.forward(request, response);
    }
}
