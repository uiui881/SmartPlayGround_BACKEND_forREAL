package com.uiui881.springboot.web;

import com.uiui881.springboot.service.managerInfos.ManagerInfosService;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosResponseDto;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosSaveRequestDto;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ManagerInfosApiController {

    private final ManagerInfosService managerInfosService;

    @PostMapping(value= "/api/v1/managerInfos")
    public Long save(@RequestBody ManagerInfosSaveRequestDto requestDto){
        return managerInfosService.save(requestDto);
    }

    @PutMapping("/api/v1/managerInfos/{managerId}")
    public Long update(@PathVariable Long managerId, @RequestBody ManagerInfosUpdateRequestDto requestDto){
        return managerInfosService.update(managerId, requestDto);
    }

    @GetMapping("/api/v1/managerInfos/{managerId}")
    public ManagerInfosResponseDto findById(@PathVariable Long managerId){
        return managerInfosService.findById(managerId); }

    @DeleteMapping("/api/v1/managerInfos/{managerId}")
    public long delete(@PathVariable long managerId){
        managerInfosService.delete(managerId);
        return managerId;
    }

}
