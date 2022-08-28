package com.codegym.controller;

import com.codegym.model.Facility;
import com.codegym.model.FacilityType;
import com.codegym.model.RentType;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
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
@RequestMapping(value = "/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute
    public List<FacilityType> facilityTypes() {
        return facilityTypeService.findAll();
    }

    @ModelAttribute
    public List<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        model.addAttribute("facilities", facilityService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        return "facility/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("facility", new Facility());
        return "facility/create";
    }

    @PostMapping(value = "/create")
    public String create(Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/facility";
    }
}
