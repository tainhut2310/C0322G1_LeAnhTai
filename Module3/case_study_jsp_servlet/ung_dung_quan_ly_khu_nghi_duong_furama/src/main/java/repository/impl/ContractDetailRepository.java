package repository.impl;

import model.ContractDetail;
import repository.BaseRepository;
import repository.IContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    private static final String SELECT_ALL = "select * from contract_detail;";

    private static final String INSERT = "insert into contract_detail (contract_id, attach_facility_id, quantity) " +
            " values (?, ?, ?);";
    @Override
    public List<ContractDetail> selectAll() throws SQLException {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                int attachFacilityId = resultSet.getInt("attach_facility_id");
                int quantity = resultSet.getInt("quantity");
                contractDetailList.add(new ContractDetail(contractId, attachFacilityId, quantity));
            }
        }
        return contractDetailList;
    }

    @Override
    public boolean insert(ContractDetail contractDetail) throws SQLException {
        boolean rowInsert;
        try (Connection connection = new BaseRepository().getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setInt(1, contractDetail.getContractId());
            statement.setInt(2, contractDetail.getAttachFacilityId());
            statement.setInt(3, contractDetail.getQuantity());
            rowInsert = statement.executeUpdate() > 0;
        }
        return rowInsert;
    }
}
