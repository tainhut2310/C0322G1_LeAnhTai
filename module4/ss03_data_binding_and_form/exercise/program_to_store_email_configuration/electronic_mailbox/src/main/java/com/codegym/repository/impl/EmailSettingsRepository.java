package com.codegym.repository.impl;

import com.codegym.model.EmailSettings;
import com.codegym.repository.IEmailSettingsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailSettingsRepository implements IEmailSettingsRepository {
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> sizeList = new ArrayList<>();

    public EmailSettings emailSettings = new EmailSettings("English", 5, false, "Thor King, Asgard");

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        sizeList.add(5);
        sizeList.add(10);
        sizeList.add(15);
        sizeList.add(25);
        sizeList.add(50);
        sizeList.add(100);
    }

    @Override
    public EmailSettings select() {
        return emailSettings;
    }

    @Override
    public List<String> showLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> showSize() {
        return sizeList;
    }

    @Override
    public EmailSettings update(EmailSettings emailSettings) {
        emailSettings.setLanguages(emailSettings.getLanguages());
        emailSettings.setPageSize(emailSettings.getPageSize());
        emailSettings.setSpamsFilter(emailSettings.getSpamsFilter());
        emailSettings.setSignature(emailSettings.getSignature());
        return emailSettings;
    }
}
