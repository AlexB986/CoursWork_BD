package DAO;

import pojo.Users;

import javax.persistence.*;
import java.util.Collection;

public class UsersDAOImpl implements UsersDAO {

    private final String user = "postgres";
    private final String password = "frostasecs1688";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    public Collection<Users> getAllUsers() {
        EntityManager entityManager = startEntityManager();
        Query query = entityManager.createNativeQuery("SELECT*FROM users", Users.class);
        return query.getResultList();
    }

    @Override
    public Users getUsersById(int id) {
        EntityManager entityManager = startEntityManager();
        Users users = entityManager.find(Users.class, id);
        return users;
    }

    @Override
    public void createUsers(Users users) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUsers(Users users) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(users);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUsers(int id, Users users) {
        EntityManager entityManager = startEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        users = startEntityManager().find(Users.class,id);
        entityManager.remove(users);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private static EntityManager startEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();

    }
}