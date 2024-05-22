package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Diary;

public interface DiaryService {
    void createDiary(Diary diary);
    Diary getDiary(int userIdx , String date);
}
