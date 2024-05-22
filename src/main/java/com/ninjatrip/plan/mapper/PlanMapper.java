package com.ninjatrip.plan.mapper;

import com.ninjatrip.plan.dto.Plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {
    void createPlan(Plan plan);
    List<Plan> getPlan(int userIdx);
    List<Plan> getDatePlan(int userIdx, String date);
}
