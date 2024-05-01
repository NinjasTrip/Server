package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Plan;
import org.springframework.stereotype.Service;

@Service
public interface PlanService {
    void createPlan(Plan plan);

    void updatePlan(Plan plan);

    void deletePlan(String planIdx);

    Plan readPlan(String planIdx);
}
