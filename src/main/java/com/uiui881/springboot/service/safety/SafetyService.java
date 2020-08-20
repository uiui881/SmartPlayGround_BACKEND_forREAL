package com.uiui881.springboot.service.safety;

import com.uiui881.springboot.domain.safety.Safety;
import com.uiui881.springboot.domain.safety.SafetyRepository;
import com.uiui881.springboot.web.safety.dto.SafetyListResponseDto;
import com.uiui881.springboot.web.safety.dto.SafetyResponseDto;
import com.uiui881.springboot.web.safety.dto.SafetySaveRequestDto;
import com.uiui881.springboot.web.safety.dto.SafetyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SafetyService {

    private final SafetyRepository safetyRepository;

    @Transactional
    public Long save(SafetySaveRequestDto requestDto){
        return safetyRepository.save(requestDto.toEntity()).getId_s();
    }

    @Transactional
    public Long update(long id_s, SafetyUpdateRequestDto requestDto){
        Safety safety = safetyRepository.findById(id_s).orElseThrow(
                ()->new IllegalArgumentException("해당 안전점검 항목이 없습니다. id="+id_s));

        safety.update(requestDto.isCheckResult(), requestDto.getId_MI());

        return id_s;
    }

    public SafetyResponseDto findById(Long id_s){
        Safety entity = safetyRepository.findById(id_s).orElseThrow(
                ()->new IllegalArgumentException("해당 안전점검 항목이 없습니다. id="+id_s));

        return new SafetyResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<SafetyListResponseDto> findAllDesc(){
        return safetyRepository.findAllDesc().stream().map(SafetyListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(long id_s){
        Safety safety = safetyRepository.findById(id_s).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id_s));

        safetyRepository.delete(safety);
    }

}
