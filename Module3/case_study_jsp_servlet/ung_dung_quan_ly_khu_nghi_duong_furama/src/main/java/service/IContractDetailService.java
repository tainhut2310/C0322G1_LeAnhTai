package service;

import model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface IContractDetailService {
    public List<ContractDetail> selectAll() throws SQLException;
}
