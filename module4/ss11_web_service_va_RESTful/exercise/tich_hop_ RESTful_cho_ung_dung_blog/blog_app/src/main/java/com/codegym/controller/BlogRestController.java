package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api-blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping(value = "")
    public ResponseEntity<?> findAll() {
        List<Blog> blogList = blogService.findAll();

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> save(Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<?> listBlogByCategory(@PathVariable Integer id) {
        Optional<Category> category = categoryService.findById(id);

        List<Blog> blogList = blogService.findByCategory(category.get());

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailBlog(@PathVariable Integer id) {

        Optional<Blog> blog = blogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
