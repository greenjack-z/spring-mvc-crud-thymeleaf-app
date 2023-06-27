package edu.greenjack.service;

import edu.greenjack.dao.UsersDao;
import edu.greenjack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    public User findById(long id) {
        return usersDao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        usersDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        usersDao.deleteUser(user);
    }
}
