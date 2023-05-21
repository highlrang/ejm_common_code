package com.myproject.generalapi.commonCode.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.generalapi.common.dto.PageDto;
import com.myproject.generalapi.common.enums.CommonStatus;
import com.myproject.generalapi.common.exception.CustomException;
import com.myproject.generalapi.commonCode.domain.CommonCodeDetailEntity;
import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;
import com.myproject.generalapi.commonCode.dto.CommonCodeDetailPageDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeDetailRequestDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeDetailResponseDto;
import com.myproject.generalapi.commonCode.repository.CommonCodeDetailRepository;
import com.myproject.generalapi.commonCode.repository.CommonCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonCodeDetailService {
    
    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeDetailRepository commonCodeDetailRepository;

    public CommonCodeDetailPageDto getCommonCodeDetails(Pageable pageable) {
        Page<CommonCodeDetailEntity> commonCodeDetailPages = commonCodeDetailRepository.findAllByDeleteYnOrderByCommonCodeId("N", pageable);
        List<CommonCodeDetailResponseDto> commonCodeDetailDtos = commonCodeDetailPages.getContent()
            .stream()
            .map(CommonCodeDetailResponseDto::new)
            .collect(Collectors.toList());
        
        PageDto pages = new PageDto(commonCodeDetailPages.getTotalElements(), commonCodeDetailPages.getTotalPages(), pageable.getPageNumber(), pageable.getPageSize());
        return new CommonCodeDetailPageDto(commonCodeDetailDtos, pages);
    }

    public CommonCodeDetailPageDto getCommonCodeDetails(long commonCodeId, Pageable pageable) {
        Page<CommonCodeDetailEntity> commonCodeDetailPages = commonCodeDetailRepository.findAllByCommonCodeIdAndDeleteYn(commonCodeId, "N", pageable);
        List<CommonCodeDetailResponseDto> commonCodeDetailDtos = commonCodeDetailPages.getContent()
            .stream()
            .map(CommonCodeDetailResponseDto::new)
            .collect(Collectors.toList());

        PageDto pages = new PageDto(commonCodeDetailPages.getTotalElements(), commonCodeDetailPages.getTotalPages(), pageable.getPageNumber(), pageable.getPageSize());
        return new CommonCodeDetailPageDto(commonCodeDetailDtos, pages);

    }

    @Transactional
    public CommonCodeDetailResponseDto saveCommonCodeDetail(CommonCodeDetailRequestDto commonCodeDetailDto) {
        long commonCodeId = commonCodeDetailDto.getCommonCodeId();
        CommonCodeEntity commonCodeEntity = commonCodeRepository.findByCommonCodeIdAndDeleteYn(commonCodeId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        
        CommonCodeDetailEntity commonCodeDetailEntity = CommonCodeDetailEntity.builder()
                                                                                .commonCodeId(commonCodeEntity.getCommonCodeId())
                                                                                .commonCodeDetailName(commonCodeDetailDto.getCommonCodeDetailName())
                                                                                .commonCodeDetailDisplayName(commonCodeDetailDto.getCommonCodeDetailDisplayName())
                                                                                .build();
        CommonCodeDetailEntity savedCommonCodeDetail = commonCodeDetailRepository.save(commonCodeDetailEntity);
        return new CommonCodeDetailResponseDto(savedCommonCodeDetail);
    }

    @Transactional
    public CommonCodeDetailResponseDto updateCommonCodeDetail(long commonCodeDetailId, CommonCodeDetailRequestDto commonCodeDetailDto) {
        CommonCodeDetailEntity commonCodeDetailEntity = commonCodeDetailRepository.findByCommonCodeDetailIdAndDeleteYn(commonCodeDetailId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        commonCodeDetailEntity.update(commonCodeDetailDto.getCommonCodeDetailName(), commonCodeDetailDto.getCommonCodeDetailDisplayName());
        return new CommonCodeDetailResponseDto(commonCodeDetailEntity);
    }

    @Transactional
    public void deleteCommonCodeDetail(long commonCodeDetailId) {
        CommonCodeDetailEntity commonCodeDetailEntity = commonCodeDetailRepository.findByCommonCodeDetailIdAndDeleteYn(commonCodeDetailId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        commonCodeDetailEntity.delete();
    }

    
}
