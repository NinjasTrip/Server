package com.ninjatrip.plan.mapper;

import com.ninjatrip.plan.dto.Plan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanMapper {
    void createPlan(Plan plan);
    Plan getPlan(int userIdx);
}
