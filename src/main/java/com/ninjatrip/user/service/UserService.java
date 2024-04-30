package com.ninjatrip.user.service;

import com.ninjatrip.user.dto.User;

import java.sql.SQLException;

public interface UserService {
    void createUser(User user) throws SQLException;
    int loginUser(String email, String password) throws SQLException;
    User getUserByUserIdx(int userIdx) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int userIdx) throws SQLException;

}
