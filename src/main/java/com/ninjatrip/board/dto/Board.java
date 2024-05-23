package com.ninjatrip.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Board {
    private int boardIdx;
    private int writerIdx;
    private String title;
    private String content;
    private int hit;
    private String img;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
