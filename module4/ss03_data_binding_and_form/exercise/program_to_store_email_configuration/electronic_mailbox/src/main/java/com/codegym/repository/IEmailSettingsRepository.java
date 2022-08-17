package com.codegym.repository;

import com.codegym.model.EmailSettings;

import java.util.List;

public interface IEmailSettingsRepository {
    EmailSettings select();

    List<String> showLanguage();

    List<Integer> showSize();

    EmailSettings update(EmailSettings emailSettings);
}
