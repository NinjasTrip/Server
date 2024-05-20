package com.ninjatrip.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    private int planIdx;
    private int userIdx;
    private String placeName;
    private String address;
    private String phone;
    private String category;
    private String date;
    private String time;
}
