package com.ninjatrip.user.service;

import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void loginUser(String email, String password) {

    }

    @Override
    public User getUserByEmail() {
        return null;
    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
