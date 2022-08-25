package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private Integer id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800, message = "Tên không được quá 800 ký tự")
    private String nameMusic;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800, message = "Tên không được quá 800 ký tự")
    private String performanceArtist;
    @NotBlank(message = "Không được để trống")
    private String kindOfMusic;

    public MusicDto() {
    }

    public MusicDto(String nameMusic, String performanceArtist, String kindOfMusic) {
        this.nameMusic = nameMusic;
        this.performanceArtist = performanceArtist;
        this.kindOfMusic = kindOfMusic;
    }

    public MusicDto(Integer id, String nameMusic, String performanceArtist, String kindOfMusic) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.performanceArtist = performanceArtist;
        this.kindOfMusic = kindOfMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getPerformanceArtist() {
        return performanceArtist;
    }

    public void setPerformanceArtist(String performanceArtist) {
        this.performanceArtist = performanceArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;

        if (!musicDto.nameMusic.matches("^([A-Z][a-z]*)+(\\\\s([A-Z][a-z]*))*$")) {
            errors.rejectValue("nameMusic",
                    "create.nameMusic",
                    "Tên không được chứa ký tự đặc biệt");
        }

        if (!musicDto.performanceArtist.matches("^([A-Z][a-z]*)+(\\\\s([A-Z][a-z]*))*$")) {
            errors.rejectValue("kindOfMusic",
                    "create.kindOfMusic",
                    "Tên không được chứa ký tự đặc biệt");
        }
    }
}
