package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Page<Music> findByNameMusic(String name, Pageable pageable);
}
