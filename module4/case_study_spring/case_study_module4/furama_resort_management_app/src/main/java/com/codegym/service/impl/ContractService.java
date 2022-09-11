package com.codegym.service.impl;

import com.codegym.model.AttachFacility;
import com.codegym.model.Contract;
import com.codegym.model.ContractDetail;
import com.codegym.model.Facility;
import com.codegym.repository.*;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public Page<Contract> findAll(String name, Pageable pageable) {
        return contractRepository.findByCustomerNameContaining(name, pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }

    @Override
    public Optional findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        this.contractRepository.deleteById(id);
    }

    @Override
    public List<Double> totalMoney() {
        double totalMoney;
        List<Contract> contractList = findAll();
        List<ContractDetail> contractDetailList = contractDetailRepository.findAll();
        List<Double> listTotalMoney = new ArrayList<>();
        for (Contract contract : contractList) {
            totalMoney = contract.getFacility().getCost() - contract.getDeposit();
            for (ContractDetail contractDetail : contractDetailList) {
                    if (contract.getId() == contractDetail.getContract().getId()) {
                        totalMoney += contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
                    }
            }
            listTotalMoney.add(totalMoney);
        }
        return listTotalMoney;
    }
}
