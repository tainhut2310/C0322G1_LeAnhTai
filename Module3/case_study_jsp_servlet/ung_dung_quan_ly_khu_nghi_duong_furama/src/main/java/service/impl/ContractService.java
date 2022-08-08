package service.impl;

import model.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository contractRepository = new ContractRepository();
    @Override
    public boolean insert(Contract contract) throws SQLException {
        return contractRepository.insert(contract);
    }

    @Override
    public List<Contract> selectAll() throws SQLException {
        return contractRepository.selectAll();
    }
}
