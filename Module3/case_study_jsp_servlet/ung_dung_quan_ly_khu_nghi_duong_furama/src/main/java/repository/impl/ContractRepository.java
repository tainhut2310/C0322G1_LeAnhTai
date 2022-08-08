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
    private static final String SELECT_ALL = "select c.`name` as name_customer, f.`name`, ct.start_date, " +
            "ct.end_date, ct.deposit, (f.cost + ifnull((cd.quantity * af.cost),0)) as total_money from contract ct " +
            " left join customer c on ct.customer_id = c.id " +
            " left join facility f on ct.facility_id = f.id " +
            " left join contract_detail cd on ct.id = cd.contract_id " +
            " left join attach_facility af on cd.attach_facility_id = af.id " +
            " group by cd.contract_id;";
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
                String nameCustomer = resultSet.getString("name");
                String nameFacility = resultSet.getString("name_customer");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                double deposit = resultSet.getDouble("deposit");
                double totalMoney = resultSet.getDouble("total_money");
                contractList.add(new Contract(nameCustomer, nameFacility, startDate, endDate, deposit, totalMoney));
            }
        }
        return contractList;
    }
}
