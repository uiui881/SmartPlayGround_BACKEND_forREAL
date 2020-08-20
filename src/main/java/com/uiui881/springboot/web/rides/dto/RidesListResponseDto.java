package com.uiui881.springboot.web.rides.dto;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.rides.Rides;
import lombok.Getter;

@Getter
public class RidesListResponseDto {

    private Long id_r;
    private String rideName;
    private long id_p;
    private int rideCongestion;

    public RidesListResponseDto(Rides entity){
        this.id_r = entity.getId_r();
        this.rideName =entity.getRideName();
        this.id_p = entity.getId_p();
        this.rideCongestion = entity.getRideCongestion();
    }
}
