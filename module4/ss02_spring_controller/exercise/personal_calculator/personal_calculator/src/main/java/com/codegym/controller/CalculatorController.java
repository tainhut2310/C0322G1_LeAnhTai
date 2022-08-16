package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String home() {
        return "result";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam double firstOperand, double lastOperand, char operator, Model model) {
        double result = calculatorService.calculator(firstOperand, lastOperand, operator);
        model.addAttribute("result", result);
        return "result";
    }
}
