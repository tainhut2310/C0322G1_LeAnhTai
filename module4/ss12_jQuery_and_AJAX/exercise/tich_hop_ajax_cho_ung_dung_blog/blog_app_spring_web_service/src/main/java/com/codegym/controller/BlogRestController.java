package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "")
    public ResponseEntity<Page<Blog>> findAll(@PageableDefault(size = 100) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        Page<Blog> blogPage = this.blogService.findByTitle(keyWord, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}
