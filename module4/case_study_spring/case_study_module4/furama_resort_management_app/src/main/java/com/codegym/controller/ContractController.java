package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.*;
import com.codegym.service.*;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String findAll(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        model.addAttribute("totalMoneys", contractService.totalMoney());
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "contract/create";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute @Valid ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contract.setDeposit(Double.parseDouble(contractDto.getDeposit()));

        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/contract";
    }

    @PostMapping(value = "/createContractDetail")
    public String save(ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/contract";
    }
}
