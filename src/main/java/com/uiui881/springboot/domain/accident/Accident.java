package com.uiui881.springboot.domain.accident;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accidentId;

    @Column
    private LocalDateTime accidentDate;

    @Column
    private long id_p;

    @Column
    private String accidentHandling;

    @Column
    private String result;

    @Column
    private String cause;

    @Column
    private String improving;

    @Column
    private long id_MI;

    @Column
    private LocalDateTime createdDate;
}
