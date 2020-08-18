package com.uiui881.springboot.web.rides.dto;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.rides.Rides;
import lombok.Getter;

@Getter
public class RidesResponseDto {

    private Long id_r;
    private String rideName;
    private Playgrounds playgrounds;
    private int rideCongestion;

    public RidesResponseDto(Rides entity){
        this.id_r = entity.getId_r();
        this.rideName = entity.getRideName();
        this.playgrounds = entity.getPlayground();
        this.rideCongestion = entity.getRideCongestion();
    }
}
