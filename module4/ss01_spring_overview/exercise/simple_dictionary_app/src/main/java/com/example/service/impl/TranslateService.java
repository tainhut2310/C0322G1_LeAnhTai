package com.example.service.impl;

import com.example.repository.ITranslateRepository;
import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService {
    @Autowired
    private ITranslateRepository translateRepository;

    @Override
    public String translate(String txtSearch) {
        return translateRepository.translate(txtSearch);
    }
}
