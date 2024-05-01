package com.ninjatrip.plan.controller;

import com.ninjatrip.plan.dto.Plan;
import com.ninjatrip.plan.service.PlanService;
import com.ninjatrip.user.dto.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    @PostMapping("/{planIdx}")
    public ResponseEntity<String> createPlan(Plan plan , Token token) {
        // 여행 계획 생성 로직 구현
        try {
            planService.createPlan(plan);
            return ResponseEntity.ok("작성 성공");

        }catch (Exception e){
            return ResponseEntity.ok("작성 오류");
        }
     
    }

//    @PostMapping("/{planIdx}")
//    public ResponseEntity<String> setPlanRoute(Plan plan , Token token) {
//        // 여행 경로 설정 로직 구현
//        return ResponseEntity.ok("Route for plan " + plan.getPlanId() + " set successfully");
//    }

    @PatchMapping("/{planIdx}")
    public ResponseEntity<String> modifyPlan(Plan plan , Token token) {
        try {
            planService.updatePlan(plan);
            return ResponseEntity.ok("수정 성공");

        }catch (Exception e){
            return ResponseEntity.ok("수정 오류");
        }
    }

    @DeleteMapping("/{planIdx}")
    public ResponseEntity<String> deletePlan(Token token, @PathVariable String planIdx) {
        // 여행 계획 삭제 로직 구현
        try {
            planService.deletePlan(planIdx);
            return ResponseEntity.ok("삭제 성공");

        }catch (Exception e){
            return ResponseEntity.ok("삭제 오류");
        }
    }

    @GetMapping("/{planIdx}")
    public ResponseEntity<String> viewPlan(Token token, @PathVariable String planIdx) {
        // 여행 계획 조회 로직 구현
        try {
            Plan plan = planService.readPlan(planIdx);
            return ResponseEntity.ok("조회 성공");

        }catch (Exception e){
            return ResponseEntity.ok("삭제 오류");
        }    }
}
