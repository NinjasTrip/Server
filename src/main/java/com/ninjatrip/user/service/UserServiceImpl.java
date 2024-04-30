package com.ninjatrip.user.service;

import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createUser(User user) throws SQLException {
        mapper.createUser(user);
    }

    @Override
    public int loginUser(String email, String password) throws SQLException {
        User user = mapper.loginUser(email, password);
        if (user == null) {
            return 0;
        } else {
            return user.getUserIdx();
        }
    }

    @Override
    public User getUserByUserIdx(int userIdx) throws SQLException {
        return mapper.getUserByUserIdx(userIdx);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        mapper.updateUser(user);
    }

    @Override
    public void deleteUser(int userIdx) throws SQLException {
        mapper.deleteUser(userIdx);
    }
}
