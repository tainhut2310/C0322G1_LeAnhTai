package com.codegym.service;

import com.codegym.model.ContractDetail;

import java.util.List;

public interface IContractDetailService<T> {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
