package com.ninjatrip.plan.controller;

import com.ninjatrip.plan.dto.Plan;
import com.ninjatrip.plan.service.PlanService;
import com.ninjatrip.util.JWTUtil;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;
    private final JWTUtil jwtUtil;

    public PlanController(PlanService planService) {
        this.planService = planService;
        this.jwtUtil = new JWTUtil();
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

    @GetMapping
    public ResponseEntity<Map<String, Object>> getPlan(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        int userIdx = jwtUtil.getUserIdx(request.getHeader("Authorization"));
        HttpStatus status = HttpStatus.OK;
        try {
            Plan plan = planService.getPlan(userIdx);
            status = HttpStatus.OK;
            resultMap.put("planInfo", plan);
        } catch (Exception e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
