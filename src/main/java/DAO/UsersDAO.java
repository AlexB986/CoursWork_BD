package DAO;

import pojo.Users;

import java.util.Collection;

public interface UsersDAO {
    Collection<Users>getAllUsers();
    Users getUsersById(int id);
    void createUsers (Users users);
    void updateUsers(Users users);
    void deleteUsers(int id, Users usere);
}
