package com.uiui881.springboot.domain.managerinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ManagerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long managerId;

    @Column
    private String managerName;

    @Column
    private String institution;

    @Column
    private String contact;

    @Builder
    public ManagerInfo(String managerName,String institution, String contact){

        this.managerName = managerName;
        this.institution = institution;
        this.contact = contact;

    }

    public void update(String institution,String contact){
       this.institution = institution;
       this.contact = contact;
    }

}
