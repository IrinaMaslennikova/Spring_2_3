package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> allUsers() {
        List<User> users = entityManager.createNativeQuery( "SELECT * FROM User1", User.class ).getResultList();
        return users;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
    @Override
    public void edit(User updateUser, int id) {
        entityManager.merge(updateUser);
    }
    @Override
    public User getUserById(int id) {
        return allUsers().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

}
