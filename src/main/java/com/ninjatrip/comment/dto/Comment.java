package com.ninjatrip.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentIdx;
    private int boardIdx;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
