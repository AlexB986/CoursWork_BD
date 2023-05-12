package DAO;

import pojo.Role;
import pojo.Users;

import java.util.Collection;

public interface RoleDAO {
    Collection<Role> getAllRole();
    Role getRoleById(int id);
    void createRole (Role role);
    void updateRole(Role role);
    void deleteRole(int id, Role role);
}
