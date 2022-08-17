package com.codegym.service;

import com.codegym.model.EmailSettings;

import java.util.List;

public interface IEmailSettingsService {
    EmailSettings select();

    List<String> showLanguage();

    List<Integer> showSize();

    EmailSettings update(EmailSettings emailSettings);
}
