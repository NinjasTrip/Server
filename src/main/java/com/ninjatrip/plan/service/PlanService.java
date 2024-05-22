package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Plan;

import java.util.List;

public interface PlanService {
    void createPlan(Plan plan);
    List<Plan> getPlan(int userIdx);
    List<Plan> getDatePlan(int usetIdx,String date);
}
