package com.ninjatrip.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Diary {

    private int diaryIdx;
    private String date;
    private int userIdx;
    private String imageUrl;
    private String comment;

    public Diary(String date, int userIdx, String imageUrl, String comment) {
        this.date = date;
        this.userIdx = userIdx;
        this.imageUrl = imageUrl;
        this.comment = comment;
    }

}
