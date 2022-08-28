package service;

import model.Contract;

import java.sql.SQLException;
import java.util.List;

public interface IContractService {
    boolean insert(Contract contract) throws SQLException;

    List<Contract> selectAll() throws SQLException;

    List<Double> getMoney() throws SQLException;

}
