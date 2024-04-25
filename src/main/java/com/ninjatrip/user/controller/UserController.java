package com.ninjatrip.user.controller;

import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        userService.loginUser(email, password);
        return null;
    }
}
