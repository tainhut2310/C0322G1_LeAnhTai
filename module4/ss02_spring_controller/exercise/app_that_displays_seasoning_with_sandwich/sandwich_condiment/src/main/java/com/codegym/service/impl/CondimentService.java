package com.codegym.service.impl;

import com.codegym.repository.ICondimentRepository;
import com.codegym.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentService implements ICondimentService {
    @Autowired
    private ICondimentRepository condimentRepository;

    @Override
    public List<String> condiment() {
        return condimentRepository.condiment();
    }

    @Override
    public String save(String[] condiment) {
        String condimentList = "";
        for (String item : condiment) {
            condimentList += item + " ";
        }
        return condimentList;
    }
}
