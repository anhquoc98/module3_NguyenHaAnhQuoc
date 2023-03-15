package model.repository;

import model.Users;

import java.sql.SQLException;
import java.util.List;

public interface IUsersRepository {
    List<Users> list() throws SQLException;
    void save(Users users) throws SQLException;
    boolean updateUser(int id, Users users) throws SQLException;

    boolean deleteUser(int id,Users users) throws SQLException;
    List<Users> sortByName() throws SQLException;
    List<Users> searchByCountry(String country) ;
    Users selectById(int id);


}
