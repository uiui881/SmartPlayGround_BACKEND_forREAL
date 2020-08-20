package com.uiui881.springboot.web.safety.dto;

import com.uiui881.springboot.domain.safety.Safety;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class SafetyListResponseDto {

    private long id_s;
    private long id_p;
    private int questionId;
    private boolean checkResult;
    private long id_MI;
    private LocalDate lastCheckDate;

    public SafetyListResponseDto(Safety entity){
        this.id_s = entity.getId_s();
        this.id_p = entity.getId_p();
        this.questionId = entity.getQuestionId();
        this.checkResult = entity.isCheckResult();
        this.id_MI = entity.getId_MI();
        this.lastCheckDate = entity.getLastCheckDate();
    }
}
