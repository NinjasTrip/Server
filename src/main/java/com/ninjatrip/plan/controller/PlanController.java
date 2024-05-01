package com.ninjatrip.plan.controller;

import com.ninjatrip.plan.dto.Plan;
import com.ninjatrip.user.dto.Token;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @PostMapping
    public ResponseEntity<String> createPlan(Plan plan , Token token) {
        // 여행 계획 생성 로직 구현
        return ResponseEntity.ok("Plan created successfully");
    }

    @PostMapping("/{planIdx}")
    public ResponseEntity<String> setPlanRoute(Plan plan , Token token) {
        // 여행 경로 설정 로직 구현
        return ResponseEntity.ok("Route for plan " + plan.getPlanId() + " set successfully");
    }

    @PatchMapping("/{planIdx}")
    public ResponseEntity<String> modifyPlan(Plan plan , Token token) {
        // 여행 계획 수정 로직 구현
        return ResponseEntity.ok("Plan  updated successfully");
    }

    @DeleteMapping("/{planIdx}")
    public ResponseEntity<String> deletePlan(Plan plan , Token token) {
        // 여행 계획 삭제 로직 구현
        return ResponseEntity.ok("Plan deleted successfully");
    }

    @GetMapping("/{planIdx}")
    public ResponseEntity<String> viewPlan(Plan plan , Token token) {
        // 여행 계획 조회 로직 구현
        return ResponseEntity.ok("Details for plan planIdx");
    }
}
