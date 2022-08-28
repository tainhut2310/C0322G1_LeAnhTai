package com.codegym.service;

import com.codegym.model.FacilityType;

import java.util.List;

public interface IFacilityTypeService<T> {
    List<FacilityType> findAll();
}
