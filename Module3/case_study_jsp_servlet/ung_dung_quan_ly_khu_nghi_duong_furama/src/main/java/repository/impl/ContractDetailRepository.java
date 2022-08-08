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
    @Override
    public List<ContractDetail> selectAll() throws SQLException {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contractId;
                int attachFacilityId;
                int quantity;
            }


        }
        return null;
    }
}
