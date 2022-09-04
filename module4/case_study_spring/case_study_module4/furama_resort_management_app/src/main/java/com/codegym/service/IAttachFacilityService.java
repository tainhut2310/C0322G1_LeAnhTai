package com.codegym.service;

import com.codegym.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService<T> {
    List<AttachFacility> findAll();
}
