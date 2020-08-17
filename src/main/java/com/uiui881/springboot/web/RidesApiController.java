package com.uiui881.springboot.web;

import com.uiui881.springboot.service.rides.RidesService;
import com.uiui881.springboot.web.rides.dto.RidesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RidesApiController {

    private final RidesService ridesService;

    @PostMapping("/api/v1/rides")
    public Long save(@RequestBody RidesSaveRequestDto requestDto){
        return ridesService.save(requestDto);
    }
}
