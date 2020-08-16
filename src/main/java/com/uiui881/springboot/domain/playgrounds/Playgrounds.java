package com.uiui881.springboot.domain.playgrounds;

import com.uiui881.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Playgrounds extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playgroundId;

    @Column(nullable =false)
    private String name;

    @Column(nullable =false)
    private double minLatitude;

    @Column(nullable =false)
    private double maxLatitude;

    @Column(nullable =false)
    private double minLongitude;

    @Column(nullable =false)
    private double maxLongitude;

    @Column(nullable =false)
    private int congestion;

    private String writer;


    @Builder
    public Playgrounds(String name, double minLatitude,double maxLatitude, double minLongitude, double maxLongitude, int congestion
    ,String writer){
        this.name = name;
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
        this.congestion = congestion;
        this.writer = writer;
    }

    public void update(double minLatitude, double maxLatitude,double minLongitude,double maxLongitude,int congestion){
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
        this.congestion = congestion;
    }
}
