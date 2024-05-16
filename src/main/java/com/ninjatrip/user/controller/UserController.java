package com.ninjatrip.user.controller;

import com.ninjatrip.user.dto.Token;
import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.service.UserService;
import com.ninjatrip.util.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }


    /**
     * 로그인
     *
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password){
        try {
           int userIdx = userService.loginUser(email, password);
           if (userIdx != 0) {
               String token = jwtService.createAccessToken(userIdx);
               return ResponseEntity.status(HttpStatus.OK).body(token);
           } else {
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("잘못된 이메일 또는 비밀번호");
           }
       } catch (Exception e) { // 기타 예외
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다");
       }
    }

    /**
     * 회원가입
     *
     */
    @PostMapping ("/signup")
    public ResponseEntity<?> signUp(User user){
        try {
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다");
        }
    }

    /**
     * 회원조회
     *
     * @param userIdx
     * @return User
     */
    @PostMapping("/{userIdx}")
    public User getUser(@PathVariable("userIdx") int userIdx) throws SQLException {
        return userService.getUserByUserIdx(userIdx);
    }

    /**
     *회원수정
     */
    @PatchMapping("/updateUser")
    public ResponseEntity<?> updateUser(User user) throws SQLException {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }

    /**
     *회원삭제
     */
    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(User user) throws SQLException {
        userService.deleteUser(user.getUserIdx());
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }
}
