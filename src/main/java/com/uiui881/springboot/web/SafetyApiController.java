package com.uiui881.springboot.web;

import com.uiui881.springboot.web.safety.dto.SafetySaveRequestDto;
import com.uiui881.springboot.web.safety.dto.SafetyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.uiui881.springboot.service.safety.*;
@RequiredArgsConstructor
@RestController
public class SafetyApiController {

    private final SafetyService safetyService;

    @PostMapping("/api/v1/safety")
    public Long save(@RequestBody SafetySaveRequestDto requestDto){
        return safetyService.save(requestDto);
    }

    @PutMapping("/api/v1/safety/{id_s}")
    public long update(@PathVariable long id_s, @RequestBody SafetyUpdateRequestDto requestDto){
        return safetyService.update(id_s, requestDto);
    }

    @DeleteMapping("/api/v1/safety/{id_s}")
    public long delete(@PathVariable long id_s){
        safetyService.delete(id_s);
        return id_s;
    }

}
