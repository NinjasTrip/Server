package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Plan;

import java.util.List;

public interface ImageGenerateService {
    String openAiImageUrl(String imageToRequest);
    String makePrompt(List<Plan> plan, String comment);
}
