package com.uiui881.springboot.service.playgrounds;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.playgrounds.PlaygroundsRepository;

import com.uiui881.springboot.web.dto.PlaygroundsListResponseDto;
import com.uiui881.springboot.web.dto.PlaygroundsResponseDto;
import com.uiui881.springboot.web.dto.PlaygroundsSaveRequestDto;
import com.uiui881.springboot.web.dto.PlaygroundsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaygroundsService {

    private final PlaygroundsRepository playgroundsRepository;

    @Transactional
    public long save(PlaygroundsSaveRequestDto requestDto){

        return playgroundsRepository.save(requestDto.toEntity()).getPlaygroundId();

    }

    @Transactional
    public long update(long playgroundId, PlaygroundsUpdateRequestDto requestDto){
        Playgrounds playgrounds = playgroundsRepository.findById(playgroundId)
                .orElseThrow(()->new IllegalArgumentException("해당 놀이터가 없습니다. 놀이터 번호="+ playgroundId));

                playgrounds.update(requestDto.getMinLatitude(), requestDto.getMaxLatitude()
                ,requestDto.getMinLongitude(), requestDto.getMaxLongitude(), requestDto.getCongestion());

                return playgroundId;
    }

    @Transactional
    public void delete(long playgroundId){
        Playgrounds playgrounds = playgroundsRepository.findById(playgroundId)
                .orElseThrow(()->new IllegalArgumentException("해당 놀이터가 없습니다. 놀이터 번호="+ playgroundId));

        playgroundsRepository.delete(playgrounds);
    }



    public PlaygroundsResponseDto findById(long playgroundId){
        Playgrounds entity = playgroundsRepository.findById(playgroundId)
                .orElseThrow(()->new IllegalArgumentException("해당 놀이터가 없습니다. 놀이터 번호="+ playgroundId));

        return new PlaygroundsResponseDto(entity);
    }


    @Transactional(readOnly = true)
    public List<PlaygroundsListResponseDto> findAllDesc(){
        return playgroundsRepository.findAllDesc().stream().map(PlaygroundsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
