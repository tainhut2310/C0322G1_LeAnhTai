package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @ModelAttribute("employees")
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("facilities")
    public List<Facility> facilities() {
        return facilityService.findAll();
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
    public String findAll(Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> nameCustomer) {
        String name = nameCustomer.orElse("");
        model.addAttribute("contracts", contractService.findAll(name, pageable));
        model.addAttribute("name", name);
        model.addAttribute("totalMoneys", contractService.totalMoney());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping(value = "/create")
    public String save(Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/contract";
    }

//    @PostMapping(value = "/createContractDetail")
//    public String save(ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
//        contractDetailService.save(contractDetail);
//        redirectAttributes.addFlashAttribute("message", "Register successfully!");
//        return "redirect:/contract";
//    }
}
