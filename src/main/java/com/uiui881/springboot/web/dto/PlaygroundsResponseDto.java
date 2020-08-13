package com.uiui881.springboot.web.dto;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import lombok.Getter;

@Getter
public class PlaygroundsResponseDto {

    private Long playgroundId;
    private String name;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
    private int congestion;
    private String writer;

    public PlaygroundsResponseDto(Playgrounds entity){
        this.playgroundId = entity.getPlaygroundId();
        this.name = entity.getName();
        this.minLatitude = entity.getMinLatitude();
        this.maxLatitude = entity.getMaxLatitude();
        this.minLongitude = entity.getMinLongitude();
        this.maxLongitude = entity.getMaxLongitude();
        this.congestion = entity.getCongestion();
        this.writer = entity.getWriter();
    }
}
