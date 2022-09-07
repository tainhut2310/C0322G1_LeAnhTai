package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import com.codegym.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword,
                          Principal principal) {
        String keyWord = keyword.orElse("");
        model.addAttribute("blogs", blogService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "blog/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
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
        return "blog/update";
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
        return "blog/view";
    }
}
