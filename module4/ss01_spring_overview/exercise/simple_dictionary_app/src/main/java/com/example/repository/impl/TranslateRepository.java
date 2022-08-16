package com.example.repository.impl;

import com.example.repository.ITranslateRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslateRepository implements ITranslateRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển sách");
        dictionary.put("computer", "Máy tính");
        dictionary.put("why", "Tại sao");
        dictionary.put("where", "Ở đâu");
        dictionary.put("he", "Anh ấy");
        dictionary.put("she", "Cô ấy");
    }
    @Override
    public String translate(String txtSearch) {
        return dictionary.get(txtSearch);
    }
}
