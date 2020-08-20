package com.uiui881.springboot.domain.rides;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Rides{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_r;

    @Column(nullable =false)
    private String rideName;

    private long id_p;

    @Column(nullable =false)
    private int rideCongestion;

    @Builder
    public Rides(String rideName, Long id_p, int rideCongestion){
        this.rideName = rideName;
        this.id_p = id_p;
        this.rideCongestion = rideCongestion;
    }

    public void update(int rideCongestion){
        this.rideCongestion = rideCongestion;
    }


}
