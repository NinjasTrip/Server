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
public class Plan {
    private String planId; // 계획의 고유 ID
    private Long userIdx; // 사용자의 고유 ID (외래 키)
    private List<Destination> destinations; // 여행지 목록
}
