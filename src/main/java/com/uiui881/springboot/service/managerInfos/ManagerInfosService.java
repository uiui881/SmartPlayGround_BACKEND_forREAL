package com.uiui881.springboot.service.managerInfos;

import com.uiui881.springboot.domain.managerinfo.ManagerInfo;
import com.uiui881.springboot.domain.managerinfo.ManagerInfoRepository;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosListResponseDto;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosResponseDto;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosSaveRequestDto;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ManagerInfosService {

    private final ManagerInfoRepository managerInfoRepository;

    @Transactional
    public Long save(ManagerInfosSaveRequestDto requestDto){
        return managerInfoRepository.save(requestDto.toEntity()).getManagerId();
    }

    @Transactional
    public Long update(long managerId, ManagerInfosUpdateRequestDto requestDto){
        ManagerInfo managerInfo = managerInfoRepository.findById(managerId).orElseThrow(()->new IllegalArgumentException(
                "해당 관리자가 없습니다. id"+managerId));

        managerInfo.update(requestDto.getInstitution(), requestDto.getContact());

        return managerId;
    }

    public ManagerInfosResponseDto findById(Long managerId){
        ManagerInfo entity = managerInfoRepository.findById(managerId).orElseThrow(()-> new IllegalArgumentException(
                "해당 관리자가 없습니다. id="+managerId));

        return new ManagerInfosResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ManagerInfosListResponseDto> findAllDesc(){
        return managerInfoRepository.findAllDesc().stream()
                .map(ManagerInfosListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(long managerId){
        ManagerInfo managerInfo = managerInfoRepository.findById(managerId).orElseThrow(()-> new
                IllegalArgumentException("해당 놀이기구가 없습니다. id="+managerId));

        managerInfoRepository.delete(managerInfo);
    }
}
