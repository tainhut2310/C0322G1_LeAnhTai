package com.example.controller;

import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslationController {
    @Autowired
    private ITranslateService translateService;

    @GetMapping("/")
    public String home() {
        return "/translation";
    }

    @GetMapping("translate")
    public String translation(@RequestParam("txtSearch") String txtSearch, Model model) {
        String result = translateService.translate(txtSearch);
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Không tìm thấy");
        }
        return "/translation";
    }
}
