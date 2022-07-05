package services.impl;

import repositoy.IContractRepository;
import repositoy.impl.ContractRepositoryImpl;
import services.IContractService;

public class ContractServiceImpl implements IContractService {
    private IContractRepository contractRepository = new ContractRepositoryImpl();

    @Override
    public void creatNew() {
        contractRepository.creatNew();
    }

    @Override
    public void displayList() {
        contractRepository.displayList();
    }

    @Override
    public void edit() {
        contractRepository.edit();
    }
}
