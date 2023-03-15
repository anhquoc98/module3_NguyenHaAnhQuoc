package model.repository;

import model.Users;

import java.util.List;

public interface IUsersRepository {
    List<Users> list();
    void save(Users users);
    boolean updateUser(int id, Users users);

    boolean deleteUser(int id,Users users);
    List<Users> sortByName();
    List<Users> searchByCountry(String country) ;
    Users selectById(int id);


}
