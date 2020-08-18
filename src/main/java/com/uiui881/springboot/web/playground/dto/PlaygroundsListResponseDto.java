package com.uiui881.springboot.web.playground.dto;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
public class PlaygroundsListResponseDto {

    private long playgroundId;
    private String name;
    private int congestion;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
    private String writer;
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //private LocalDateTime modifiedDate;
   // @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    //private LocalDateTime createdDate;

    public PlaygroundsListResponseDto(Playgrounds entity){
        this.playgroundId = entity.getPlaygroundId();
        this.name = entity.getName();
        this.congestion = entity.getCongestion();
        this.minLatitude = entity.getMinLatitude();
        this.maxLatitude = entity.getMaxLatitude();
        this.minLongitude = entity.getMinLongitude();
        this.maxLongitude = entity.getMaxLongitude();
        this.writer = entity.getWriter();
        //this.modifiedDate = entity.getModifiedDate();
        //this.createdDate = entity.getCreatedDate();
    }
}
