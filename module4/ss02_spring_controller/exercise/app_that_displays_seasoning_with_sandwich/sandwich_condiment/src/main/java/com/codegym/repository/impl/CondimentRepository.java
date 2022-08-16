package com.codegym.repository.impl;

import com.codegym.repository.ICondimentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentRepository implements ICondimentRepository {
    private static List<String> condimentList = new ArrayList<>();
    static {
        condimentList.add("Lettuce");
        condimentList.add("Tomato");
        condimentList.add("Mustard");
        condimentList.add("Sprouts");
    }

    @Override
    public List<String> condiment() {
        return condimentList;
    }
}
