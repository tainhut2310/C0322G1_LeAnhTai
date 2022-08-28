package repository;

import model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailRepository {
    public List<ContractDetail> selectAll() throws SQLException;

    boolean insert(ContractDetail contractDetail) throws SQLException;


}
