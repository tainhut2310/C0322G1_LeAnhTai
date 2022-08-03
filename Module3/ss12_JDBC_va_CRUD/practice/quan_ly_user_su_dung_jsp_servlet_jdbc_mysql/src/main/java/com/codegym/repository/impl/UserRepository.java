package com.codegym.repository.impl;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_ss12?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Kc332200490440";

    private static final String INSERT_USERS_SQL = "insert into users (`name`, email, country) values (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,`name`,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set `name` = ?,email= ?, country =? where id = ?;";

    private static final String FIND_BY_COUNTRY = "select * from users where country like ?;";
    private static final String SORT_BY_NAME = "select * from users order by `name` asc;";

    private static final String FIND_BY_ID_STORE = "call get_user_by_id(?);";

    private static final String INSERT_USER_STORE = "call insert_user(?,?,?);";

    private static final String SQL_INSERT = "insert into employee (`name`, salary, created_date) values (?,?,?)";

    private static final String SQL_UPDATE = "update employee set salary=? where `name`=?";

    private static final String SQL_TABLE_CREATE = "create table employee(" +
            " id serial primary key, " +
            " `name` varchar(100) not null, " +
            " salary numeric(15, 2) not null, " +
            " created_date timestamp " +
            " );";

    private static final String SQL_TABLE_DROP = "drop table if exists employee;";

    private static final String SELECT_ALL_USERS_STORE = "call select_users;";

    private static final String UPDATE_USER_STORE = "call update_user(?,?,?,?);";

    private static final String DELETE_USER_BY_ID_STORE = "call delete_user_by_id(?);";

    public UserRepository() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    //Bài tập_ss12: 1. Tìm kiếm theo Country
    @Override
    public List<User> findByCountry(String nameCountry) throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_COUNTRY);) {
            statement.setString(1, "%" + nameCountry + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        }
        return userList;
    }

    //    2.Sắp xếp theo tên
    @Override
    public List<User> sortByName() throws SQLException {
        List<User> userList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SORT_BY_NAME);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        }
        return userList;
    }

    @Override
    public User getUserByIdStore(int id) throws SQLException {
        User user = null;
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(FIND_BY_ID_STORE)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(INSERT_USER_STORE)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());

            callableStatement.executeUpdate();
        }
    }

    //    [Thực hành_ss13] MySql JDBC Transaction
    @Override
    public void addUserTransaction(User user, int[] permision) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            pstmt = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            int rowAffected = pstmt.executeUpdate();

            resultSet = pstmt.getGeneratedKeys();

            int userId = 0;

            if (resultSet.next()) {
                userId = resultSet.getInt(1);
            }

            if (rowAffected == 1) {
                String sqlVivot = "insert into user_permision(user_id, permision_id) value(?,?);";
                pstmtAssignment = connection.prepareStatement(sqlVivot);

                for (int permisionId : permision) {
//                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException ex) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //[Thực hành_ss13] Thực thi SQL không sử dụng Transaction
    @Override
    public void insertUpdateWithoutTransaction() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    [Thực hành_ss13] Thực thi SQL có sử dụng Transaction
    @Override
    public void insertUpdateUseTransaction() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            connection.setAutoCommit(false);

            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();

            connection.commit();

            connection.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println();
        }
    }

    //    [Bài tập_ss13] Gọi MySql Stored Procedures từ JDBC
//    1. Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
    @Override
    public List<User> selectAllUserStore() throws SQLException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(SELECT_ALL_USERS_STORE)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        }
        return userList;
    }

    //    2.Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
    @Override
    public void updateUserStore(User user) throws SQLException {
        try (Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(UPDATE_USER_STORE)){
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());
            callableStatement.executeUpdate();
        }
    }

    //    3. Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
    @Override
    public void deleteUserByIdStore(int id) throws SQLException {
        try (Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(DELETE_USER_BY_ID_STORE)){
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
