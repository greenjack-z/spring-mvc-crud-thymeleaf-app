package edu.greenjack.service;

import edu.greenjack.model.User;

public interface UserService {
    void saveUser(User user);
    User getUserById(long id);
    void updateUser(long id, User user);
}
