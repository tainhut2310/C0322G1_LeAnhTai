package com.codegym.service;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<MedicalDeclaration> selectAll();

    MedicalDeclaration selectByIdCard(String idCard);

    void update(MedicalDeclaration medicalDeclaration, String idCard);

    List<String> gender();

    List<String> nationality();

    List<String> travelInformation();

    List<Integer> day();

    List<Integer> month();

    List<Integer> year();

    void save(MedicalDeclaration medicalDeclaration);
}
