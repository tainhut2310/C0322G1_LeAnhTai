package com.codegym.model;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_music")
    private String nameMusic;
    @Column(name = "performance_artist")
    private String performanceArtist;
    @Column(name = "kind_of_music")
    private String kindOfMusic;

    public Music() {
    }

    public Music(String nameMusic, String performanceArtist, String kindOfMusic) {
        this.nameMusic = nameMusic;
        this.performanceArtist = performanceArtist;
        this.kindOfMusic = kindOfMusic;
    }

    public Music(Integer id, String nameMusic, String performanceArtist, String kindOfMusic) {
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
}
