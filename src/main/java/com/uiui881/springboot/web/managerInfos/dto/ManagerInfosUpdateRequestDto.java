package com.uiui881.springboot.web.managerInfos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManagerInfosUpdateRequestDto {

    private String institution;
    private String contact;

    @Builder
    public ManagerInfosUpdateRequestDto(String institution, String contact){

        this.institution = institution;
        this.contact = contact;
    }
}
