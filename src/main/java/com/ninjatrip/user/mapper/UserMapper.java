package com.ninjatrip.user.mapper;

import com.ninjatrip.user.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {

    /**
     * id에 해당하는 사용자 정보를 반환한다.
     *
     * @param userIdx 조회할 사용자의 id
     * @return 조회된 사용자 정보 객체 User
     * @throws SQLException
     */
    User getUserByUserIdx(int userIdx) throws SQLException;


    /**
     * 회원가입
     * @param user 가입할 회원정보
     * @return
     * @throws SQLException
     */
    void createUser(User user) throws SQLException;

    void deleteUser(int userIdx) throws SQLException;
    void updateUser(User user) throws SQLException;
    User loginUser(String email, String password) throws SQLException;

}
