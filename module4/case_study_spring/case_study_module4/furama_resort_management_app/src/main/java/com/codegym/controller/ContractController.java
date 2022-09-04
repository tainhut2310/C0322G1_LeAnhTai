package com.codegym.controller;

import com.codegym.model.AttachFacility;
import com.codegym.model.ContractDetail;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("employees")
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute("contractDetails")
    public List<ContractDetail> contractDetails() {
        return contractDetailService.findAll();
    }

    @ModelAttribute("attachFacilities")
    public List<AttachFacility> attachFacilities() {
        return attachFacilityService.findAll();
    }

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        return "contract/list";
    }
}
