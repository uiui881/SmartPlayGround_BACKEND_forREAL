package com.uiui881.springboot.web.managerInfos.dto;

import com.uiui881.springboot.domain.managerinfo.ManagerInfo;
import com.uiui881.springboot.domain.rides.Rides;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManagerInfosSaveRequestDto {

    private String managerName;
    private String institution;
    private String contact;

    @Builder
    public ManagerInfosSaveRequestDto(String managerName,String institution, String contact){
        this.managerName = managerName;
        this.institution = institution;
        this.contact = contact;
    }

    public ManagerInfo toEntity(){
        return ManagerInfo.builder().managerName(managerName).institution(institution).contact(contact).build();
    }
}
