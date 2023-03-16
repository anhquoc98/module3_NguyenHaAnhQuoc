package model.repository;

import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public List<Users> list() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Users> usersList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL);
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
    public void save(Users users) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_INTO);
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
    public boolean updateUser(int id, Users users) {
        Connection connection =DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(UPDATE_USER);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,users.getName());
            preparedStatement.setString(3,users.getEmail());
            preparedStatement.setString(4,users.getCountry());

            return preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int id, Users users) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, users.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Users> sortByName() {
        List<Users> usersList =new ArrayList<>();
        Connection connection=DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet=preparedStatement.executeQuery();
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
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
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
