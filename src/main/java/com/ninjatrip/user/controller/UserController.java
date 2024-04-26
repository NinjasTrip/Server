package com.ninjatrip.user.controller;

import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountLockedException;
import java.sql.SQLException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * 로그인
     *
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password){
        try {
           userService.loginUser(email, password);
           return ResponseEntity.status(HttpStatus.OK).body("로그인 성공");

       } catch (IllegalArgumentException e) { // 예외가 유효한 자격 증명을 검증할 때 발생하는지
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("잘못된 이메일 또는 비밀번호");
       } catch (Exception e) { // 기타 예외
             e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다");
       }

    }

    /**
     * 회원가입
     *
     * @param user
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
        User user = userService.getUserByUserIdx(userIdx);
        return user;
    }

    /**
     *
     */
    @PatchMapping("/updateUser")
    public ResponseEntity<?> updateUser(User user) throws SQLException {
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> delteUser(User user) throws SQLException {
        userService.deleteUser(user.getUserIdx());
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공");
    }
}
