package repository;

import model.Contract;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    public boolean insert(Contract contract) throws SQLException;

    public List<Contract> selectAll() throws SQLException;
}
