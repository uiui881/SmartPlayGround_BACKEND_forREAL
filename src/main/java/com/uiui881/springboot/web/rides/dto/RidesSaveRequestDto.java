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
    private long id_p;
    private int rideCongestion;

    @Builder
    public RidesSaveRequestDto(String rideName, Long id_p, int rideCongestion){
        this.rideName = rideName;
        this.id_p = id_p;
        this.rideCongestion = rideCongestion;
    }

    public Rides toEntity(){
        return Rides.builder().rideName(rideName).id_p(id_p).rideCongestion(rideCongestion).build();
    }
}
