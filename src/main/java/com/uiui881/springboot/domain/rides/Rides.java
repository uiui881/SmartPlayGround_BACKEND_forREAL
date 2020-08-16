package com.uiui881.springboot.domain.rides;

import com.uiui881.springboot.domain.BaseTimeEntity;
import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Rides extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_r;

    @Column(nullable =false)
    private String rideName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ride_playgrounds")
    private Playgrounds playground;

    @Column(nullable =false)
    private int rideCongestion;

    @Builder
    public Rides(String rideName, Playgrounds playground, int rideCongestion){
        this.rideName = rideName;
        this.playground = playground;
        this.rideCongestion = rideCongestion;
    }


}
