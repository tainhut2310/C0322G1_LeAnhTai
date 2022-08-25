package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
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
import java.util.Optional;

@Controller
@RequestMapping("music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping(value = "")
    public String findAll(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        model.addAttribute("musics", musicService.findByName(keyWord, pageable));
        model.addAttribute("keyword", keyWord);
        return "result";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new MusicDto());
        return "index";
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute @Valid MusicDto musicDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);

        this.musicService.save(music);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/music";
    }

}
