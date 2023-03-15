package model.service;

import model.Users;
import model.repository.UsersDBRepository;

import java.util.List;

public class UsersService implements IUsersService {
    UsersDBRepository usersDBRepository = new UsersDBRepository();

    @Override
    public List<Users> list() {
        return usersDBRepository.list();
    }

    @Override
    public void save(Users users) {
        usersDBRepository.save(users);
    }

    @Override
    public boolean updateUser(int id, Users users) {
        return usersDBRepository.updateUser(id,users);
    }

    @Override
    public boolean deleteUser(int id,Users users) {
        return usersDBRepository.deleteUser(id,users);
    }

    @Override
    public List<Users> sortByNameUser() {
        return usersDBRepository.sortByName();
    }

    @Override
    public List<Users> searchByCountry(String country) {
        return usersDBRepository.searchByCountry(country);
    }


    @Override
    public Users selectById(int id) {
        return usersDBRepository.selectById(id);
    }
}
