package com.ninjatrip.review.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Review {
    private int reviewIdx;
    private int writerIdx;
    private String place;
    private int traffic;
    private int travel;
    private int food;
    private int total;
    private LocalDateTime createdAt;
}
