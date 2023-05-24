package DAO;

import pojo.Role;
import pojo.Users;

import java.util.Collection;

public interface UsersDAO {
    Collection<Users>getAllUsers();
    Users getUsersById(int id);
    Collection<?> getUsersByRole(Integer iRole);

    Collection<?>getAllUsersNoRole();
    void createUsers (Users users);
    void updateUsers(Users users);
    void deleteUsers(int id, Users users);
}
