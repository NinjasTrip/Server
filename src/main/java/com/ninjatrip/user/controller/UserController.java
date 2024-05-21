package com.ninjatrip.user.controller;

import com.ninjatrip.plan.service.ImageGenerateService;
import com.ninjatrip.user.dto.User;
import com.ninjatrip.user.service.UserService;
import com.ninjatrip.util.JWTUtil;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JWTUtil jwtUtil;

    public UserController(UserService userService, JWTUtil jwtUtil, ImageGenerateService imageGenerateService) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    /**
     * 로그인
     *
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user){

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            int userIdx = userService.loginUser(user.getEmail(), user.getPassword());
            if (userIdx != 0) {
                String accessToken = jwtUtil.createAccessToken(userIdx);
                String refreshToken = jwtUtil.createRefreshToken(userIdx);

                userService.saveRefreshToken(userIdx, refreshToken);

                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);

                status = HttpStatus.CREATED;
            } else {
                resultMap.put("message", "아이디 또는 패스워드를 확인해 주세요.");
                status = HttpStatus.UNAUTHORIZED;
            }
        } catch (Exception e) { // 기타 예외
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
       }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /**
     * 회원가입
     *
     */
    @PostMapping ("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user){
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
    @GetMapping("/info/{userIdx}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable("userIdx") int userIdx, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
            try {
//				로그인 사용자 정보.
                User user = userService.getUserByUserIdx(userIdx);
                resultMap.put("userInfo", user);
                status = HttpStatus.OK;
            } catch (Exception e) {
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        }
        else {
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
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

    @Operation(summary = "로그아웃", description = "회원 정보를 담은 Token 을 제거한다.")
    @GetMapping("/logout/{userIdx}")
    @Hidden
    public ResponseEntity<?> removeToken(@PathVariable("userIdx") @Parameter(required = true) int userIdx) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            userService.deleteRefreshToken(userIdx);
            status = HttpStatus.OK;
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @Operation(summary = "Access Token 재발급", description = "만료된 access token 을 재발급 받는다.")
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody User user, HttpServletRequest request)
            throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refreshToken");
        if (jwtUtil.checkToken(token)) {
            if (token.equals(userService.getRefreshToken(user.getUserIdx()))) {
                String accessToken = jwtUtil.createAccessToken(user.getUserIdx());
                resultMap.put("access-token", accessToken);
                status = HttpStatus.CREATED;
            }
        } else {
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
