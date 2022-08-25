package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private Integer id;
    @NotBlank(message = "*Không được để trống!")
    @Size(max = 800, message = "*Tên không được quá 800 ký tự!")
    @Pattern(regexp = "^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôư" +
            " ăêđâ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ ]+$",
            message = "*Tên không được chứa các ký tự đặc biệt!")
    private String nameMusic;

    @NotBlank(message = "*Không được để trống!")
    @Size(max = 800, message = "*Tên không được quá 800 ký tự!")
    @Pattern(regexp = "^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹè" +
            " ẽổẵẻỡơôưăêđâ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ]+$",
            message = "*Tên không được chứa các ký tự đặc biệt!")
    private String performanceArtist;

    @NotBlank(message = "*Không được để trống!")
    @Size(max = 1000, message = "*Tên không được quá 1000 ký tự!")
    @Pattern(regexp = "^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹè" +
            " ẽổẵẻỡơôưăêđâ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ,]+$",
            message = "*Tên không được chứa các ký tự đặc biệt trừ dấu phẩy!")
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
    }
}
