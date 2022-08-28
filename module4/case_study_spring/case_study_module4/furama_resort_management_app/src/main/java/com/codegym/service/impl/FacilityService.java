package com.codegym.service.impl;

import com.codegym.model.Facility;
import com.codegym.repository.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findByName(String name, Pageable pageable) {
        return facilityRepository.findByNameContaining(name, pageable);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Optional findById(Integer id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        facilityRepository.deleteById(id);
    }
}
