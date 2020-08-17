package com.uiui881.springboot.service.rides;

import com.uiui881.springboot.domain.rides.RidesRepository;
import com.uiui881.springboot.web.rides.dto.RidesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RidesService {

    private final RidesRepository ridesRepository;

    @Transactional
    public Long save(RidesSaveRequestDto requestDto){
        return ridesRepository.save(requestDto.toEntity()).getId_r();
    }
}
