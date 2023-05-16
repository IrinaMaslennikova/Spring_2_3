package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.dao.UserDAOImp;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) { this.userDAO = userDAO; }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional(readOnly = false)
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void edit(User user, long id) {
        userDAO.edit(user, id);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }
}
