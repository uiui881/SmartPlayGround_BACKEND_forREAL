package com.uiui881.springboot.domain.safety;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class questionName {

    @Id
    private int questionId;

    @Column
    private int questionInString;
}
