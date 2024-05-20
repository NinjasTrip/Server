package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Plan;
import com.ninjatrip.plan.mapper.PlanMapper;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanMapper mapper;

    public PlanServiceImpl(PlanMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createPlan(Plan plan) {
        System.out.println("hello3");
        mapper.createPlan(plan);
    }
}
