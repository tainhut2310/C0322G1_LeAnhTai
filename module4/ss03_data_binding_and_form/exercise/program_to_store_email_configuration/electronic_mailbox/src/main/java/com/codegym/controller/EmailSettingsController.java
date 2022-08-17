package com.codegym.controller;

import com.codegym.model.EmailSettings;
import com.codegym.service.IEmailSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSettingsController {
    @Autowired
    private IEmailSettingsService iEmailSettingsService;

    @GetMapping("/")
    public String showEmail(Model model) {
        model.addAttribute("emailSettings", iEmailSettingsService.select());
        model.addAttribute("languages", iEmailSettingsService.showLanguage());
        model.addAttribute("sizes", iEmailSettingsService.showSize());
        return "update";
    }

    @PostMapping("/update")
    public String updateEmail(@ModelAttribute EmailSettings emailSettings, Model model) {
        model.addAttribute("emailSettings", iEmailSettingsService.update(emailSettings));
        return "view";
    }
}
