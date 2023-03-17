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
                statement = connection.prepareCall("{call get_list_user}");
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
            PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1,users.getName());
            preparedStatement.setString(2,users.getEmail());
            preparedStatement.setString(3,users.getCountry());
            preparedStatement.setInt(4,id);
            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int id, Users users) {
        Connection connection = DBConnection.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call delete_user(?)}");
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
            CallableStatement callableStatement = connection.prepareCall( "{call edit_user(?,?,?,?)}");
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
            PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_BY_COUNTRY);
            preparedStatement.setString(1,country);
            ResultSet resultSet =preparedStatement.executeQuery();
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
            CallableStatement callableStatement =connection.prepareCall("{call get_user_by_id(?)}");
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
