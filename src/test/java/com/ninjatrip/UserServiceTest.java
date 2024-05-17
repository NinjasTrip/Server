package com.ninjatrip;

import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void test() throws SQLException {
        User user = new User();
        user.setEmail("kodd1102@naver.com");
        user.setPassword("testpassword");
        user.setNickName("데옹");

        userService.createUser(user);
    }
}
