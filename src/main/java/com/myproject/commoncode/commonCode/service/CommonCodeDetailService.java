package com.myproject.commoncode.commonCode.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.commoncode.commonCode.domain.CommonCodeDetailEntity;
import com.myproject.commoncode.commonCode.domain.CommonCodeEntity;
import com.myproject.commoncode.commonCode.dto.CommonCodeDetailDto;
import com.myproject.commoncode.commonCode.repository.CommonCodeDetailRepository;
import com.myproject.commoncode.commonCode.repository.CommonCodeRepository;
import com.myproject.commoncode.core.enums.CommonStatus;
import com.myproject.commoncode.core.exception.CustomException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonCodeDetailService {
    
    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeDetailRepository commonCodeDetailRepository;

    public PageImpl<CommonCodeDetailDto> getCommonCodeDetails(Pageable pageable) {
        Page<CommonCodeDetailEntity> commonCodeDetailPages = commonCodeDetailRepository.findAll(pageable);
        List<CommonCodeDetailDto> commonCodeDetailDtos = commonCodeDetailPages.getContent()
            .stream()
            .map(CommonCodeDetailDto::new)
            .collect(Collectors.toList());
        
        return new PageImpl<CommonCodeDetailDto>(commonCodeDetailDtos, pageable, commonCodeDetailPages.getTotalElements());
    }

    public Page<CommonCodeDetailDto> getCommonCodeDetails(long commonCodeId, Pageable pageable) {
        Page<CommonCodeDetailEntity> commonCodeDetailPages = commonCodeDetailRepository.findAllByCommonCodeId(commonCodeId, pageable);
        List<CommonCodeDetailDto> commonCodeDetailDtos = commonCodeDetailPages.getContent()
            .stream()
            .map(CommonCodeDetailDto::new)
            .collect(Collectors.toList());

        return new PageImpl<CommonCodeDetailDto>(commonCodeDetailDtos, pageable, commonCodeDetailPages.getTotalElements());

    }

    @Transactional
    public CommonCodeDetailDto saveCommonCodeDetail(CommonCodeDetailDto commonCodeDetailDto) {
        long commonCodeId = commonCodeDetailDto.getCommonCodeId();
        CommonCodeEntity commonCodeEntity = commonCodeRepository.findById(commonCodeId)
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        
        CommonCodeDetailEntity commonCodeDetailEntity = CommonCodeDetailEntity.builder()
                                                                                .commonCodeId(commonCodeEntity.getCommonCodeId())
                                                                                .commonCodeDetailName(commonCodeDetailDto.getCommonCodeDetailName())
                                                                                .commonCodeDetailDisplayName(commonCodeDetailDto.getCommonCodeDetailDisplayName())
                                                                                .build();
        CommonCodeDetailEntity savedCommonCodeDetail = commonCodeDetailRepository.save(commonCodeDetailEntity);
        return new CommonCodeDetailDto(savedCommonCodeDetail);
    }

    @Transactional
    public CommonCodeDetailDto updateCommonCodeDetail(long commonCodeDetailId, CommonCodeDetailDto commonCodeDetailDto) {
        CommonCodeDetailEntity commonCodeDetailEntity = commonCodeDetailRepository.findById(commonCodeDetailId)
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        commonCodeDetailEntity.update(commonCodeDetailDto.getCommonCodeDetailName(), commonCodeDetailDto.getCommonCodeDetailDisplayName());
        return new CommonCodeDetailDto(commonCodeDetailEntity);
    }

    
}
