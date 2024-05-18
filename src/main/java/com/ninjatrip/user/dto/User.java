package com.ninjatrip.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int userIdx;
    private String email;
    private String password;
    private String nickName;
    private String refreshToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
