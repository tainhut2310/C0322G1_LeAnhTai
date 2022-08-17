package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping("/")
    public String listMedicalDeclaration(Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclarationService.selectAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        model.addAttribute("day", medicalDeclarationService.day());
        model.addAttribute("month", medicalDeclarationService.month());
        model.addAttribute("year", medicalDeclarationService.year());
        model.addAttribute("gender", medicalDeclarationService.gender());
        model.addAttribute("nationality", medicalDeclarationService.nationality());
        model.addAttribute("travelInformation", medicalDeclarationService.travelInformation());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        this.medicalDeclarationService.save(medicalDeclaration);
        redirectAttributes.addFlashAttribute("message", "Register successfully");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam String idCard, Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclarationService.selectByIdCard(idCard));
        model.addAttribute("day", medicalDeclarationService.day());
        model.addAttribute("month", medicalDeclarationService.month());
        model.addAttribute("year", medicalDeclarationService.year());
        model.addAttribute("gender", medicalDeclarationService.gender());
        model.addAttribute("nationality", medicalDeclarationService.nationality());
        model.addAttribute("travelInformation", medicalDeclarationService.travelInformation());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        this.medicalDeclarationService.update(medicalDeclaration, medicalDeclaration.getIdCard());
        redirectAttributes.addFlashAttribute("message", "Update successful");
        return "redirect:/";
    }
}
