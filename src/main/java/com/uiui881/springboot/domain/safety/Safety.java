package com.uiui881.springboot.domain.safety;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Safety extends SafetyTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_s;

    @Column
    private long id_p;

    @Column
    private int questionId;

    @Column
    private long id_MI;

    @Column
    private boolean checkResult;


    @Builder
    public Safety(long id_p, int questionId, long id_MI, boolean checkResult){
        this.id_p =id_p;
        this.questionId = questionId;
        this.id_MI = id_MI;
        this.checkResult = checkResult;
    }

    public void update(boolean checkResult, long id_MI){
        this.checkResult = checkResult;
        this.id_MI = id_MI;
    }

}
