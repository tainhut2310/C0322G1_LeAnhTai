package service.impl;

import model.ContractDetail;
import repository.IContractDetailRepository;
import repository.impl.ContractDetailRepository;
import service.IContractDetailService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailService implements IContractDetailService {
    private IContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public List<ContractDetail> selectAll() throws SQLException {
        return contractDetailRepository.selectAll();
    }
}
