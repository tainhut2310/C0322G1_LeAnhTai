package com.codegym.blog_application.controller;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "")
    public String findAll(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @PostMapping(value = "/edit")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg", "Edit successfully!");
        return "redirect:/blog";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Integer idDelete, RedirectAttributes redirectAttributes) {
        blogService.remove(idDelete);
        redirectAttributes.addFlashAttribute("msg", "Delete successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String viewBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
