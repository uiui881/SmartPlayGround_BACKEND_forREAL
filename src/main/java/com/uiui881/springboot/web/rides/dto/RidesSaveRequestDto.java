package com.uiui881.springboot.web.rides.dto;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.rides.Rides;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RidesSaveRequestDto {

    private String rideName;
    private Playgrounds playground;
    private int rideCongestion;

    @Builder
    public RidesSaveRequestDto(String rideName, Playgrounds playground, int rideCongestion){
        this.rideName = rideName;
        this.playground = playground;
        this.rideCongestion = rideCongestion;
    }

    public Rides toEntity(){
        return Rides.builder().rideName(rideName).playground(playground).rideCongestion(rideCongestion).build();
    }
}
