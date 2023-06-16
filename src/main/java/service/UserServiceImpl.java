package service;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id, user);
    }
}
