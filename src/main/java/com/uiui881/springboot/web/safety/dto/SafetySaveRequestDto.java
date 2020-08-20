package com.uiui881.springboot.web.safety.dto;

import com.uiui881.springboot.domain.safety.Safety;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SafetySaveRequestDto {

    private long id_p;
    private int questionId;
    private boolean checkResult;
    private long id_MI;

    @Builder
    public SafetySaveRequestDto(long id_p, int questionId, boolean checkResult, long id_MI){
        this.id_p = id_p;
        this.questionId = questionId;
        this.checkResult = checkResult;
        this.id_MI = id_MI;
    }

    public Safety toEntity(){
        return Safety.builder().id_p(id_p).questionId(questionId).checkResult(checkResult)
                .id_MI(id_MI).build();
    }
}
