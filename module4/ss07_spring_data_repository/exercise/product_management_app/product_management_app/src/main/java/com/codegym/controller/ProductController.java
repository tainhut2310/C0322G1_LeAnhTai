package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        model.addAttribute("products", productService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String save(Product product , RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping(value = "/edit")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully!");
        return "redirect:/product";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        productService.remove(idDelete);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/product";
    }
}
