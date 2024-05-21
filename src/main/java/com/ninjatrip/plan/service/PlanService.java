package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Plan;

public interface PlanService {
    void createPlan(Plan plan);
    Plan getPlan(int userIdx);
}
