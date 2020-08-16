package com.uiui881.springboot.domain.accident;


import com.uiui881.springboot.domain.BaseTimeEntity;
import com.uiui881.springboot.domain.managerinfo.ManagerInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Accident extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accidentId;

    private LocalDateTime accidentDate;

    private String place;

    private String accidentHandling;

    private String result;

    private String cause;

    private String improving;

    @ManyToOne
    @JoinColumn(name="managerInfo_no")
    ManagerInfo managerInfo;
}
