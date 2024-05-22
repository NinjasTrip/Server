package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Diary;
import com.ninjatrip.plan.mapper.DiaryMapper;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {
    private final DiaryMapper mapper;

    public DiaryServiceImpl(DiaryMapper mapper) {this.mapper = mapper;}

    public void createDiary(Diary diary) {
        mapper.createDiary(diary);
    }

    public Diary getDiary(int userIdx , String date) {
        return mapper.getDiaryByUserAndDate(userIdx, date);
    }
}
