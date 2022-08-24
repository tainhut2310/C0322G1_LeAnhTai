package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        model.addAttribute("customers", customerService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping(value = "/create")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "update";
    }

    @PostMapping(value = "/edit")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully!");
        return "redirect:/customer";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Long idDelete, RedirectAttributes redirectAttributes) {
        customerService.remove(idDelete);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/customer";
    }
}
