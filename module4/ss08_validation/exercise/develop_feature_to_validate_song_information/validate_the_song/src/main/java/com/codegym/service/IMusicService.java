package com.codegym.service;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMusicService<T> {

    Page<Music> findByName(String name, Pageable pageable);

    void save(Music music);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}
