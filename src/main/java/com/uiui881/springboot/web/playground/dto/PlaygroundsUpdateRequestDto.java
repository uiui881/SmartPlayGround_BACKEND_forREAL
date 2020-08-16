package com.uiui881.springboot.web.playground.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaygroundsUpdateRequestDto {

    private long playgroundId;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
    private int congestion;


    @Builder
    public PlaygroundsUpdateRequestDto(long playgroundId, double minLatitude, double maxLatitude,
                                     double minLongitude, double maxLongitude, int congestion){

        this.playgroundId = playgroundId;
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
        this.congestion = congestion;
    }
}
