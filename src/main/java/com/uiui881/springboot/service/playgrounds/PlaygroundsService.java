package com.uiui881.springboot.service.playgrounds;

import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.playgrounds.PlaygroundsRepository;

import com.uiui881.springboot.web.dto.PlaygroundsResponseDto;
import com.uiui881.springboot.web.dto.PlaygroundsSaveRequestDto;
import com.uiui881.springboot.web.dto.PlaygroundsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PlaygroundsService {

    private final PlaygroundsRepository playgroundsRepository;

    @Transactional
    public Long save(PlaygroundsSaveRequestDto requestDto){

        return playgroundsRepository.save(requestDto.toEntity()).getPlaygroundId();

    }

    @Transactional
    public Long update(Long playgroundId, PlaygroundsUpdateRequestDto requestDto){
        Playgrounds playgrounds = playgroundsRepository.findById(playgroundId)
                .orElseThrow(()->new IllegalArgumentException("해당 놀이터가 없습니다. 놀이터 번호="+playgroundId));

                playgrounds.update(requestDto.getMinLatitude(), requestDto.getMaxLatitude()
                ,requestDto.getMinLongitude(), requestDto.getMaxLongitude(), requestDto.getCongestion());

                return playgroundId;
    }

    public PlaygroundsResponseDto findById(Long playgroundId){
        Playgrounds entity = playgroundsRepository.findById(playgroundId)
                .orElseThrow(()->new IllegalArgumentException("해당 놀이터가 없습니다. 놀이터 번호="+playgroundId));

        return new PlaygroundsResponseDto(entity);
    }


}
