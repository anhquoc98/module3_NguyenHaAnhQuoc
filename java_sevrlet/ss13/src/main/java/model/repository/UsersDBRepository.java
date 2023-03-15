package model.repository;

import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsersDBRepository implements IUsersRepository {
    private static final String SELECT_ALL = "select * from users";
    private final String SELECT_BY_ID = "select id,name,email,country from users where id =?";

    private final String INSERT_INTO = "insert into users(id,name,email,country)" + "values(?,?,?,?)";
    private final String DELETE_USER = "delete from users where id =?";
    private final String UPDATE_USER = "update users set name = ?,email= ?, country =? where id = ?";
    private final String SEARCH_BY_COUNTRY = "select id,name,email,country from users where country =?";
    private final String SORT_BY_NAME = "select* from users order by name";


    @Override
    public List<Users> list(){
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        List<Users> usersList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareCall(SELECT_ALL);
                resultSet = statement.executeQuery();
                Users users = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    users = new Users(id, name, email, country);
                    usersList.add(users);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return usersList;
    }

    @Override
    public void sa1ve(Users users)  {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(INSERT_INTO);
                statement.setInt(1, users.getId());
                statement.setString(2, users.getName());
                statement.setString(3, users.getEmail());
                statement.setString(4, users.getCountry());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }
    @Override
    public void save(Users users)  {
        Connection connection = DBConnection.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, users.getId());
            preparedStatement.setString(2, users.getName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getCountry());
            preparedStatement.executeUpdate();

            savepoint = connection.setSavepoint();

            connection.setAutoCommit(false);
            preparedStatement = connection.prepareCall(INSERT_INTO);
            preparedStatement.setInt(1, users.getId());
            preparedStatement.setString(2, users.getName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getCountry());
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (savepoint != null){
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    connection.commit();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }finally {
            DBConnection.close();
        }
    }
    @Override
    public boolean updateUser(int id, Users users){
        Connection connection =DBConnection.getConnection();
        try {
            CallableStatement callableStatement =connection.prepareCall(UPDATE_USER);
            callableStatement.setString(1,users.getName());
            callableStatement.setString(2,users.getEmail());
            callableStatement.setString(3,users.getCountry());
            callableStatement.setInt(4,id);
            return callableStatement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int id, Users users) {
        Connection connection = DBConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE_USER);
            callableStatement.setInt(1, users.getId());
            return callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Users> sortByName() {
        List<Users> usersList =new ArrayList<>();
        Connection connection=DBConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(SORT_BY_NAME);
            ResultSet resultSet=callableStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String country=resultSet.getString("country");
                usersList.add(new Users(id,name,email,country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    @Override
    public List<Users> searchByCountry(String country) {
        List <Users> usersList=new ArrayList<>();
        Connection connection=DBConnection.getConnection();
        try {
            CallableStatement callableStatement=connection.prepareCall(SEARCH_BY_COUNTRY);
            callableStatement.setString(1,country);
            ResultSet resultSet =callableStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name= resultSet.getString("name");
                String email= resultSet.getString("email");
                usersList.add(new Users(id,name,email,country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    @Override
    public Users selectById(int id) {
        Users users =null;
        Connection connection=DBConnection.getConnection();
        try {
            CallableStatement callableStatement =connection.prepareCall(SELECT_BY_ID);
            callableStatement.setInt(1,id);
            ResultSet resultSet =callableStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                String email =resultSet.getString("email");
                String country =resultSet.getString("country");
                users =new Users(id,name,email,country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

}
