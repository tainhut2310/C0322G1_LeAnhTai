package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository userRepository;


    @Override
    public Page<Music> findByName(String name, Pageable pageable) {
        return userRepository.findByNameMusic(name, pageable);
    }

    @Override
    public void save(Music music) {
        userRepository.save(music);
    }

    @Override
    public Optional findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }
}
