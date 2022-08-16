package com.codegym.controller;


import com.codegym.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CondimentController {
    @Autowired
    private ICondimentService condimentService;

    @GetMapping("/")
    public String showList(Model model) {
        List<String> condimentList = condimentService.condiment();
        model.addAttribute("condimentList", condimentList);
        return "condiment/list";
    }

    @PostMapping("/condiment")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        String condiments = condimentService.save(condiment);
        List<String> condimentList = condimentService.condiment();
        model.addAttribute("condimentList", condimentList);
        model.addAttribute("condiments", condiments);
        return "condiment/list";
    }
}
