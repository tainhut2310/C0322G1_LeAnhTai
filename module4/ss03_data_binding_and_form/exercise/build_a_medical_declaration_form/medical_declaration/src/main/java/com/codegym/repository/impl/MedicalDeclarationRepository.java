package com.codegym.repository.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    private static List<String> genderList = new ArrayList<>();
    private static List<String> nationalityList = new ArrayList<>();
    private static List<String> travelInformationList = new ArrayList<>();
    private static List<Integer> dayList = new ArrayList<>();
    private static List<Integer> monthList = new ArrayList<>();
    private static List<Integer> yearList = new ArrayList<>();

    private static List<MedicalDeclaration> medicalDeclarationList = new ArrayList<>();

    static {
        for (int i = 1; i <= 30; i++) {
            dayList.add(i);
        }
        for (int i = 1; i <= 12; i++) {
            monthList.add(i);
        }
        for (int i = 1900; i <= 2022; i++) {
            yearList.add(i);
        }
        genderList.add("Nam");
        genderList.add("Nữ");

        nationalityList.add("Việt Nam");
        nationalityList.add("Mỹ");
        nationalityList.add("Nhật Bản");
        nationalityList.add("Hàn Quốc");
        nationalityList.add("Australia");

        travelInformationList.add("Tàu bay");
        travelInformationList.add("Tàu thuyền");
        travelInformationList.add("Ô tô");
        travelInformationList.add("Khác (ghi rõ)");

        medicalDeclarationList.add(new MedicalDeclaration("Trần Ánh Tuyết", 1992, "Nữ", "Việt Nam", "183658574", "Tàu bay", "TB112", "23", 11, 12, 2022, 12, 12, 2022, "Không"));
        medicalDeclarationList.add(new MedicalDeclaration("Nguyễn Phi Hùng", 1992, "Nam", "Việt Nam", "183946774", "Tàu bay", "TB112", "23", 11, 12, 2022, 12, 12, 2022, "Không"));
        medicalDeclarationList.add(new MedicalDeclaration("Trần Ánh Nguyệt", 1992, "Nữ", "Việt Nam", "183342574", "Tàu bay", "TB112", "23", 11, 12, 2022, 12, 12, 2022, "Không"));
    }


    @Override
    public List<MedicalDeclaration> selectAll() {
        return medicalDeclarationList;
    }

    @Override
    public MedicalDeclaration selectByIdCard(String idCard) {
        for (MedicalDeclaration item: medicalDeclarationList) {
            if (item.getIdCard().equals(idCard)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void update(MedicalDeclaration medicalDeclaration, String idCard) {
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdCard().equals(idCard)) {
                item.setName(medicalDeclaration.getName());
                item.setDateOfBirthday(medicalDeclaration.getDateOfBirthday());
                item.setGender(medicalDeclaration.getGender());
                item.setNationality(medicalDeclaration.getNationality());
                item.setIdCard(medicalDeclaration.getIdCard());
                item.setTravelInformation(medicalDeclaration.getTravelInformation());
                item.setVehicleNumber(medicalDeclaration.getVehicleNumber());
                item.setSeats(medicalDeclaration.getSeats());
                item.setDepartureDay(medicalDeclaration.getDepartureDay());
                item.setDepartureMonth(medicalDeclaration.getDepartureMonth());
                item.setDepartureYear(medicalDeclaration.getDepartureYear());
                item.setEndDay(medicalDeclaration.getEndDay());
                item.setEndMonth(medicalDeclaration.getEndMonth());
                item.setEndYear(medicalDeclaration.getEndYear());
            }
        }
    }

    @Override
    public List<String> gender() {
        return genderList;
    }

    @Override
    public List<String> nationality() {
        return nationalityList;
    }

    @Override
    public List<String> travelInformation() {
        return travelInformationList;
    }

    @Override
    public List<Integer> day() {
        return dayList;
    }

    @Override
    public List<Integer> month() {
        return monthList;
    }

    @Override
    public List<Integer> year() {
        return yearList;
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.add(medicalDeclaration);
    }
}
