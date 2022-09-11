package com.codegym.service;

import com.codegym.model.EducationDegree;

import java.util.List;

public interface IEducationDegreeService<T> {
    List<EducationDegree> findAll();
}
