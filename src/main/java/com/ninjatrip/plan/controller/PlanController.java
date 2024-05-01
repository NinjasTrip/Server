package com.ninjatrip.plan.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @PostMapping
    public ResponseEntity<String> createPlan(@RequestBody String planDetails) {
        // 여행 계획 생성 로직 구현
        return ResponseEntity.ok("Plan created successfully");
    }

    @PostMapping("/{planIdx}")
    public ResponseEntity<String> setPlanRoute(@PathVariable String planIdx, @RequestBody String routeDetails) {
        // 여행 경로 설정 로직 구현
        return ResponseEntity.ok("Route for plan " + planIdx + " set successfully");
    }

    @PatchMapping("/{planIdx}")
    public ResponseEntity<String> modifyPlan(@PathVariable String planIdx, @RequestBody String newPlanDetails) {
        // 여행 계획 수정 로직 구현
        return ResponseEntity.ok("Plan " + planIdx + " updated successfully");
    }

    @DeleteMapping("/{planIdx}")
    public ResponseEntity<String> deletePlan(@PathVariable String planIdx) {
        // 여행 계획 삭제 로직 구현
        return ResponseEntity.ok("Plan " + planIdx + " deleted successfully");
    }

    @GetMapping("/{planIdx}")
    public ResponseEntity<String> viewPlan(@PathVariable String planIdx) {
        // 여행 계획 조회 로직 구현
        return ResponseEntity.ok("Details for plan " + planIdx);
    }
}
