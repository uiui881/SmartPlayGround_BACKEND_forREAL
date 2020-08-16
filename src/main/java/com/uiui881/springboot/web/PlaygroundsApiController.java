package com.uiui881.springboot.web;

import com.uiui881.springboot.service.playgrounds.PlaygroundsService;
import com.uiui881.springboot.web.playground.dto.PlaygroundsResponseDto;
import com.uiui881.springboot.web.playground.dto.PlaygroundsSaveRequestDto;
import com.uiui881.springboot.web.playground.dto.PlaygroundsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlaygroundsApiController {

    private final PlaygroundsService playgroundsService;

    @PostMapping("/api/v1/playgrounds")
    public long save(@RequestBody PlaygroundsSaveRequestDto requestDto){
        return playgroundsService.save(requestDto);
    }

    @PutMapping("/api/v1/playgrounds/{playgroundId}")
    public long update(@PathVariable long playgroundId, @RequestBody PlaygroundsUpdateRequestDto requestDto){
        return playgroundsService.update(playgroundId, requestDto);
    }

    @GetMapping("/api/v1/playgrounds/{playgroundId}")
    public PlaygroundsResponseDto findById(@PathVariable long playgroundId){
        return playgroundsService.findById(playgroundId);
    }

    @DeleteMapping("/api/v1/playgrounds/{playgroundId}")
    public long delete(@PathVariable long playgroundId){
        playgroundsService.delete(playgroundId);
        return playgroundId;
    }

}
