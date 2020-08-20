package com.uiui881.springboot.web;

import com.uiui881.springboot.service.rides.RidesService;
import com.uiui881.springboot.web.rides.dto.RidesResponseDto;
import com.uiui881.springboot.web.rides.dto.RidesSaveRequestDto;
import com.uiui881.springboot.web.rides.dto.RidesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import java.awt.*;

@RequiredArgsConstructor
@RestController
public class RidesApiController {

    private final RidesService ridesService;

    @PostMapping(value= "/api/v1/rides")
    public Long save(@RequestBody RidesSaveRequestDto requestDto){
        return ridesService.save(requestDto);
    }

    @PutMapping("/api/v1/rides/{id_r}")
    public Long update(@PathVariable Long id_r, @RequestBody RidesUpdateRequestDto requestDto){
        return ridesService.update(id_r, requestDto);
    }

    @GetMapping("/api/v1/rides/{id_r}")
    public RidesResponseDto findById(@PathVariable Long id_r){ return ridesService.findById(id_r); }

    @DeleteMapping("/api/v1/rides/{id_r}")
    public long delete(@PathVariable long id_r){
        ridesService.delete(id_r);
        return id_r;
    }
}
