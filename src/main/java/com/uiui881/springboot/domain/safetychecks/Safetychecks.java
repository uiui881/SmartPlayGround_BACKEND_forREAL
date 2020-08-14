package com.uiui881.springboot.domain.safetychecks;

import com.uiui881.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Safetychecks extends BaseTimeEntity {

    @Id
    private Long id;

    @Column
    private String playgroundName;

    @Column
    private int questionId;

    @Column
    private boolean checkResult;

    @Column
    private String checkerName;

}
