package edu.greenjack.dao;

import edu.greenjack.model.User;

public interface UserDao {
    void saveUser(User user);
    User getUserById(long id);
    void updateUser(long id, User user);
}
