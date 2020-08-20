package com.uiui881.springboot.web.safety.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SafetyUpdateRequestDto {

    private boolean checkResult;
    private long id_MI;

    @Builder
    public SafetyUpdateRequestDto(boolean checkResult, long id_MI){
        this.checkResult = checkResult;
        this.id_MI = id_MI;
    }
}
