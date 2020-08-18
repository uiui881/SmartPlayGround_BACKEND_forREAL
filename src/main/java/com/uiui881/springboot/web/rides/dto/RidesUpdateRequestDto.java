package com.uiui881.springboot.web.rides.dto;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RidesUpdateRequestDto {

    private int rideCongestion;

    @Builder
    public RidesUpdateRequestDto(int rideCongestion){

        this.rideCongestion = rideCongestion;
    }
}
