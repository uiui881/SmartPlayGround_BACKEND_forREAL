package com.uiui881.springboot.service.rides;

import com.uiui881.springboot.domain.rides.Rides;
import com.uiui881.springboot.domain.rides.RidesRepository;
import com.uiui881.springboot.web.rides.dto.RidesResponseDto;
import com.uiui881.springboot.web.rides.dto.RidesSaveRequestDto;
import com.uiui881.springboot.web.rides.dto.RidesUpdateRequestDto;
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

    @Transactional
    public Long update(Long id_r, RidesUpdateRequestDto requestDto){
        Rides rides = ridesRepository.findById(id_r).orElseThrow(()->new IllegalArgumentException(
                "해당 놀이기구가 없습니다. id_r"+id_r));

        rides.update(requestDto.getRideCongestion());

        return id_r;
    }

    public RidesResponseDto findById(Long id_r){
        Rides entity = ridesRepository.findById(id_r).orElseThrow(()-> new IllegalArgumentException(
                "해당 놀이터가 없습니다. id="+id_r));

        return new RidesResponseDto(entity);
    }
}
