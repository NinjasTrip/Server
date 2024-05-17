package com.ninjatrip.user.mapper;

import com.ninjatrip.user.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {

    User getUserByUserIdx(int userIdx) throws SQLException;
    void createUser(User user) throws SQLException;
    void deleteUser(int userIdx) throws SQLException;
    void updateUser(User user) throws SQLException;
    User loginUser(String email, String password) throws SQLException;

}
