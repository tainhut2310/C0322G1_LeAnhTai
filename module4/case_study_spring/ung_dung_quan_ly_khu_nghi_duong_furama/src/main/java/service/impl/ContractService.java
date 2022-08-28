package service.impl;

import model.AttachFacility;
import model.Contract;
import model.ContractDetail;
import model.Facility;
import repository.IAttachFacilityRepository;
import repository.IContractDetailRepository;
import repository.IContractRepository;
import repository.IFacilityRepository;
import repository.impl.AttachFacilityRepository;
import repository.impl.ContractDetailRepository;
import repository.impl.ContractRepository;
import repository.impl.FacilityRepository;
import service.IContractService;
import service.IFacilityService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractService implements IContractService {
    private final IContractRepository contractRepository = new ContractRepository();
    private final IContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    private final IAttachFacilityRepository attachFacilityRepository = new AttachFacilityRepository();
    private final IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public boolean insert(Contract contract) throws SQLException {
        return contractRepository.insert(contract);
    }

    @Override
    public List<Contract> selectAll() throws SQLException {
        return contractRepository.selectAll();
    }

    @Override
    public List<Double> getMoney() throws SQLException {
        List<Contract> contractList = contractRepository.selectAll();
        List<ContractDetail> contractDetailList = contractDetailRepository.selectAll();
        List<AttachFacility> attachFacilityList = attachFacilityRepository.selectAll();
        List<Facility> facilityList = facilityRepository.selectAll();
        List<Double> listTotalMoney = new ArrayList<>();
        double totalMoney = 0;
        for (Contract contract : contractList) {
            for (ContractDetail contractDetail : contractDetailList) {
                for (AttachFacility attachFacility : attachFacilityList) {
                    for (Facility facility : facilityList) {
                        if (contract.getFacilityId() == facility.getId() && contract.getId() == contractDetail.getContractId() && contractDetail.getAttachFacilityId() == attachFacility.getId()) {
                            totalMoney += facility.getCost() + contractDetail.getQuantity() * attachFacility.getCost();
                        }
                    }
                }
            }
            listTotalMoney.add(totalMoney - contract.getDeposit());
        }
        return listTotalMoney;
    }
}
