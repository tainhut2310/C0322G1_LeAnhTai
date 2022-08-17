package com.codegym.service.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<MedicalDeclaration> selectAll() {
        return medicalDeclarationRepository.selectAll();
    }

    @Override
    public MedicalDeclaration selectByIdCard(String idCard) {
        return medicalDeclarationRepository.selectByIdCard(idCard);
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration, String idCard) {
        medicalDeclarationRepository.update(medicalDeclaration, idCard);
    }

    @Override
    public List<String> gender() {
        return medicalDeclarationRepository.gender();
    }

    @Override
    public List<String> nationality() {
        return medicalDeclarationRepository.nationality();
    }

    @Override
    public List<String> travelInformation() {
        return medicalDeclarationRepository.travelInformation();
    }

    @Override
    public List<Integer> day() {
        return medicalDeclarationRepository.day();
    }

    @Override
    public List<Integer> month() {
        return medicalDeclarationRepository.month();
    }

    @Override
    public List<Integer> year() {
        return medicalDeclarationRepository.year();
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.save(medicalDeclaration);
    }
}
