package com.onefactor.user.service;

 
import com.onefactor.user.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(String email, User user);
    void deleteUser(Long id);
    User getUserByEmail(String email);

}
