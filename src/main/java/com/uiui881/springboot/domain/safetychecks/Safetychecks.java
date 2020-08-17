package com.uiui881.springboot.domain.safetychecks;

import com.uiui881.springboot.domain.BaseTimeEntity;
import com.uiui881.springboot.domain.managerinfo.ManagerInfo;
import com.uiui881.springboot.domain.playgrounds.Playgrounds;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playground_id", foreignKey = @ForeignKey(name = "FK_SAFETYCHECKS_PLAYGROUNDS"))
    private Playgrounds playgrounds;

    @Column
    private int questionId;

    @Column
    private boolean checkResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checker_id", foreignKey = @ForeignKey(name = "FK_SAFETYCHECKS_MANAGER"))
    private ManagerInfo managerInfo;

}
