package com.uiui881.springboot.web.managerInfos.dto;

import com.uiui881.springboot.domain.managerinfo.ManagerInfo;
import com.uiui881.springboot.domain.rides.Rides;
import lombok.Getter;

@Getter
public class ManagerInfosResponseDto {

    private Long managerId;
    private String managerName;
    private String institution;
    private String contact;

    public ManagerInfosResponseDto(ManagerInfo entity){
        this.managerId = entity.getManagerId();
        this.managerName = entity.getManagerName();
        this.institution = entity.getInstitution();
        this.contact = entity.getContact();
    }
}
