package com.uiui881.springboot.web.safety.dto;

import com.uiui881.springboot.domain.safety.Safety;

public class SafetyResponseDto {

    private long id_s;
    private long id_p;
    private int questionId;
    private long id_MI;
    private boolean checkResult;

    public SafetyResponseDto(Safety entity){
        this.id_s = entity.getId_s();
        this.id_p = entity.getId_p();
        this.questionId = entity.getQuestionId();
        this.id_MI = entity.getId_MI();
        this.checkResult = entity.isCheckResult();
    }
}
