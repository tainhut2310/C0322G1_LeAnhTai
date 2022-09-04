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

    @ModelAttribute("facilityTypes")
    public List<FacilityType> facilityTypes() {
        return facilityTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
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
        if (facility.getFacilityType().getId() == 1) {
            facility.setFacilityFree(null);
        } else if (facility.getFacilityType().getId() == 2) {
            facility.setPoolArea(null);
            facility.setFacilityFree(null);
        } else {
            facility.setStandardRoom(null);
            facility.setDescriptionOtherConvenience(null);
            facility.setPoolArea(null);
            facility.setNumberOfFloors(null);
        }
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Register successfully!");
        return "redirect:/facility";
    }

    @GetMapping(value = "/edit/{id}")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        return "facility/edit";
    }

    @PostMapping(value = "/edit")
    public String update(Facility facility, RedirectAttributes redirectAttributes) {
        if (facility.getFacilityType().getId() == 1) {
            facility.setFacilityFree(null);
        } else if (facility.getFacilityType().getId() == 2) {
            facility.setPoolArea(null);
            facility.setFacilityFree(null);
        } else {
            facility.setStandardRoom(null);
            facility.setDescriptionOtherConvenience(null);
            facility.setPoolArea(null);
            facility.setNumberOfFloors(null);
        }
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Edit successfully!");
        return "redirect:/facility";
    }

    @PostMapping(value = "/delete")
    public String remove(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        this.facilityService.remove(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/facility";
    }
}
