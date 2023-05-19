package DAO;

import pojo.Role;

import javax.persistence.*;
import java.util.Collection;

public class RoleDAOImpl implements RoleDAO {
    private final String user = "postgres";
    private final String password = "frostasecs1688";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    @Override
    public Collection<Role> getAllRole() {
        EntityManager entityManager = startEntityManager();
        Query query = entityManager.createNativeQuery("SELECT*FROM role", Role.class);
        return query.getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        EntityManager entityManager = startEntityManager();
        Role role = entityManager.find(Role.class, id);
        return role;
    }

    @Override
    public void createRole(Role role) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(role);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateRole(Role role) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteRole(int id, Role role) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        role = entityManager.find(Role.class,id);
        entityManager.remove(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    private static EntityManager startEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();

    }
}
