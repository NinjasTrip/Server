package com.ninjatrip.plan.controller;

import com.ninjatrip.plan.dto.Diary;
import com.ninjatrip.plan.dto.Plan;
import com.ninjatrip.plan.service.DiaryService;
import com.ninjatrip.plan.service.ImageGenerateService;
import com.ninjatrip.plan.service.PlanService;
import com.ninjatrip.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final JWTUtil jwtUtil;
    private final ImageGenerateService imageGenerateService;
    private final DiaryService diaryService;

    public PlanController(PlanService planService, JWTUtil jwtUtil, ImageGenerateService imageGenerateService, DiaryService diaryService) {
        this.planService = planService;
        this.jwtUtil = new JWTUtil();
        this.imageGenerateService = imageGenerateService;
        this.diaryService = diaryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createPlan(@RequestBody Plan plan) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED;
        try {
            planService.createPlan(plan);
            status = HttpStatus.OK;
            resultMap.put("status", status);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/{userIdx}")
    public ResponseEntity<Map<String, Object>> getPlan(@PathVariable int userIdx) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        try {
            List<Plan> plan = planService.getPlan(userIdx);
            status = HttpStatus.OK;
            resultMap.put("planinfo", plan);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/create/diary")
    public String postImage(@RequestBody Diary diary) {
        List<Plan> plan = planService.getDatePlan(diary.getUserIdx(), diary.getDate());
        String str = imageGenerateService.makePrompt(plan, diary.getComment());
        diary.setImageUrl(imageGenerateService.openAiImageUrl(str));
        diaryService.createDiary(diary);
        return diary.getImageUrl();
    }

    @GetMapping("/get/diary")
    public Diary getDiary(@RequestParam int userIdx, @RequestParam String date) {
        return diaryService.getDiary(userIdx, date);
    }
}
