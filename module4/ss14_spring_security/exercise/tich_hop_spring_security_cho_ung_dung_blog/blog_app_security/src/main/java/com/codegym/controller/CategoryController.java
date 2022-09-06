package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
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
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");
        model.addAttribute("categories", categoryService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        return "category/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping(value = "/create")
    public String save(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }

    @PostMapping(value = "/edit")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully!");
        return "redirect:/category";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        categoryService.remove(idDelete);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/category";
    }

    @GetMapping("/{id}/view")
    public String viewBlog(@PathVariable Integer id, Model model) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return "/error.404";
        }
        List<Blog> blogs = blogService.findByCategory(categoryOptional.get());
        model.addAttribute("category", categoryOptional.get());
        model.addAttribute("blogs", blogs);
        return "category/view";
    }
}

