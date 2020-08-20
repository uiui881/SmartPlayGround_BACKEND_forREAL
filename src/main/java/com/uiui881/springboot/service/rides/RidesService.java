package com.uiui881.springboot.service.rides;

import com.uiui881.springboot.domain.rides.Rides;
import com.uiui881.springboot.domain.rides.RidesRepository;
import com.uiui881.springboot.web.rides.dto.RidesListResponseDto;
import com.uiui881.springboot.web.rides.dto.RidesResponseDto;
import com.uiui881.springboot.web.rides.dto.RidesSaveRequestDto;
import com.uiui881.springboot.web.rides.dto.RidesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RidesService {

    private final RidesRepository ridesRepository;

    @Transactional
    public Long save(RidesSaveRequestDto requestDto){
        return ridesRepository.save(requestDto.toEntity()).getId_r();
    }

    @Transactional
    public Long update(long id_r, RidesUpdateRequestDto requestDto){
        Rides rides = ridesRepository.findById(id_r).orElseThrow(()->new IllegalArgumentException(
                "해당 놀이기구가 없습니다. id"+id_r));

        rides.update(requestDto.getRideCongestion());

        return id_r;
    }

    public RidesResponseDto findById(Long id_r){
        Rides entity = ridesRepository.findById(id_r).orElseThrow(()-> new IllegalArgumentException(
                "해당 놀이기구가 없습니다. id="+id_r));

        return new RidesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<RidesListResponseDto> findAllDesc(){
        return ridesRepository.findAllDesc().stream()
                .map(RidesListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(long id_r){
        Rides rides = ridesRepository.findById(id_r).orElseThrow(()-> new
                IllegalArgumentException("해당 놀이기구가 없습니다. id="+id_r));

        ridesRepository.delete(rides);
    }
}
