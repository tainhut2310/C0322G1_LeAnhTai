package com.codegym.dto;

import com.codegym.model.FacilityType;
import com.codegym.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class FacilityDto implements Validator {
    private Integer id;
    @NotBlank(message = "*Không được để trống!")
    private String name;

    @NotBlank(message = "*Không được để trống!")
    private String area;

    @NotBlank(message = "*Không được để trống!")
    private String cost;

    @NotBlank(message = "*Không được để trống!")
    private String maxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private Double poolArea;
    private Integer numberOfFloors;

    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        if (!facilityDto.area.matches("^\\d*(\\.\\d+)?$")) {
            errors.rejectValue("area",
                    "create.area",
                    "*Diện tích sử dụng phải là số nguyên hoặc số thập phân!");
        }

        if (!facilityDto.cost.matches("^?\\d*(\\.\\d+)?$")) {
            errors.rejectValue("cost",
                    "create.cost",
                    "*Chi phí thuê phải là số nguyên hoặc số thập phân!");
        }

        if (!facilityDto.maxPeople.matches("^\\d+$")) {
            errors.rejectValue("maxPeople",
                    "create.maxPeople",
                    "*Số người tối đa phải là số nguyên!");
        }

        if (facilityDto.facilityType == null) {
            errors.rejectValue("facilityType",
                    "create.facilityType",
                    "*Không được để trống!");
        }

        if (facilityDto.rentType == null) {
            errors.rejectValue("rentType",
                    "create.rentType",
                    "*Không được để trống!");
        }
    }
}
