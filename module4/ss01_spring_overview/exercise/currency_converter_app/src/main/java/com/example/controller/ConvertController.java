package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("/")
    public String home() {
        return "/input-output";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam double rate, double usd, Model model) {
        double totalMoney = convertService.convert(rate, usd);
        model.addAttribute("totalMoney", totalMoney);
        return "/input-output";
    }
}



