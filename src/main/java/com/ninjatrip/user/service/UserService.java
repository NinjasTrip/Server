package com.ninjatrip.user.service;

import com.ninjatrip.user.dto.User;

public interface UserService {
    void createUser(User user);
    void loginUser(String email, String password);
    User getUserByEmail();
    void updateUser();
    void deleteUser();

}
