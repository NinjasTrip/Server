package com.ninjatrip.plan.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Destination {
    private String planId; // 계획의 고유 ID
    private Long userIdx; // 사용자의 고유 ID (외래 키)

    private int order; // 여행지 방문 순서
    private String location; // 여행지 위치
    private String note; // 방문지에 대한 메모
    private String time; // 방문 예정 시간

}
