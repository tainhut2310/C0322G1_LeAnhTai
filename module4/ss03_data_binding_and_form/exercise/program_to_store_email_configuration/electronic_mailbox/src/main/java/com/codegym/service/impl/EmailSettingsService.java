package com.codegym.service.impl;

import com.codegym.model.EmailSettings;
import com.codegym.repository.IEmailSettingsRepository;
import com.codegym.service.IEmailSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailSettingsService implements IEmailSettingsService {
    @Autowired
    private IEmailSettingsRepository emailSettingsRepository;

    @Override
    public EmailSettings select() {
        return emailSettingsRepository.select();
    }

    @Override
    public List<String> showLanguage() {
        return emailSettingsRepository.showLanguage();
    }

    @Override
    public List<Integer> showSize() {
        return emailSettingsRepository.showSize();
    }

    @Override
    public EmailSettings update(EmailSettings emailSettings) {
        return emailSettingsRepository.update(emailSettings);
    }
}
