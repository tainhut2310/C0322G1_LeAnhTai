package repository.impl;

import model.Contract;
import repository.BaseRepository;
import repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private static final String SELECT_ALL = "select * from contract;";
    @Override
    public boolean insert(Contract contract) throws SQLException {
        return false;
    }

    @Override
    public List<Contract> selectAll() throws SQLException {
        List<Contract> contractList = new ArrayList<>();
        try (Connection connection = new BaseRepository().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                double deposit = resultSet.getDouble("deposit");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int facilityId = resultSet.getInt("facility_id");
                contractList.add(new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId));
            }
        }
        return contractList;
    }
}
