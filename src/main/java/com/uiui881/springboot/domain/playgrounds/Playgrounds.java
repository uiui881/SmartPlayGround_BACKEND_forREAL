package com.uiui881.springboot.domain.playgrounds;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Playgrounds {

    @Id
    private Long playgroundId;

    @Column(nullable =false)
    private String name;

    @Column(nullable =false)
    private String address;

    @Column(nullable =false)
    private int congestion;

    @Builder
    public Playgrounds(String name, String address, int congestion){
        this.name = name;
        this.address = address;
        this.congestion = congestion;
    }
}
