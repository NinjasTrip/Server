package com.ninjatrip.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private int boardIdx;
    private int writerIdx;
    private String nickname;
    private String title;
    private String content;
    private int hit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}