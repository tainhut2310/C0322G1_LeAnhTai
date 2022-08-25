package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        model.addAttribute("users", userService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        return "result";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setAge(LocalDate.parse(userDto.getAge()));

        this.userService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/user";
    }

}
