package com.ninjatrip.plan.service;

import com.ninjatrip.plan.dto.Plan;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageGenerateServiceImpl implements ImageGenerateService {

    @Value("${openai-key}")
    private String OPENAI_KEY;

    public String openAiImageUrl(String imageToRequest) {
        System.out.println(imageToRequest);
        System.out.println("OpenAI Key: " + OPENAI_KEY);
        OpenAiService service = new OpenAiService(OPENAI_KEY);
        CreateImageRequest build = CreateImageRequest.builder()
                .prompt(imageToRequest)
                .n(1)
                .size("512x512")
                .build();

        return service.createImage(build)
                .getData()
                .get(0)
                .getUrl();
    }

    public String makePrompt(List<Plan> plan, String comment) {
        String s = "하루기록{";
        for (Plan p : plan) {
            s += " [2024.05.22."+p.getTime()+"] "+p.getPlaceName()+"방문.";
        }
        s += comment+"}"+"\n 위의 하루 기록을 포괄하는 cartoon을 만들어줘. 이미지 비율은 16:9로 해줘";
        return s;
    }
}
