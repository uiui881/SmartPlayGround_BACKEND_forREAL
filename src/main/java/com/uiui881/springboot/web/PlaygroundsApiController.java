package com.uiui881.springboot.web;

import com.uiui881.springboot.service.playgrounds.PlaygroundsService;
import com.uiui881.springboot.web.dto.PlaygroundsResponseDto;
import com.uiui881.springboot.web.dto.PlaygroundsSaveRequestDto;
import com.uiui881.springboot.web.dto.PlaygroundsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlaygroundsApiController {

    private final PlaygroundsService playgroundsService;

    @PostMapping("/api/v1/playgrounds")
    public Long save(@RequestBody PlaygroundsSaveRequestDto requestDto){
        return playgroundsService.save(requestDto);
    }

    @PostMapping("/api/v1/playgrounds/{playgroundId}")
    public Long update(@PathVariable Long playgroundId, @RequestBody PlaygroundsUpdateRequestDto requestDto){
        return playgroundsService.update(playgroundId, requestDto);
    }

    @GetMapping("/api/v1/playgrounds/{playgroundId}")
    public PlaygroundsResponseDto findById(@PathVariable Long playgroundId){
        return playgroundsService.findById(playgroundId);

    }
}
