package com.uiui881.springboot.web.dto;


import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaygroundsSaveRequestDto {

    private String name;
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;
    private int congestion;
    private String writer;

    @Builder
    public PlaygroundsSaveRequestDto(String name, double minLatitude, double maxLatitude,
                                     double minLongitude, double maxLongitude, int congestion,
                                     String writer){
        this.name = name;
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
        this.congestion = congestion;
        this.writer = writer;
    }

    public Playgrounds toEntity(){
        return Playgrounds.builder().name(name).minLatitude(minLatitude)
                .maxLatitude(maxLatitude).minLongitude(minLongitude).maxLongitude(maxLongitude)
                .congestion(congestion).writer(writer).build();
    }
}
