package com.myproject.generalapi.commonCode.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.generalapi.common.enums.CommonStatus;
import com.myproject.generalapi.common.exception.CustomException;
import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;
import com.myproject.generalapi.commonCode.dto.CommonCodePageDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeRequestDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeResponseDto;
import com.myproject.generalapi.commonCode.repository.CommonCodeDetailRepository;
import com.myproject.generalapi.commonCode.repository.CommonCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonCodeService {
    
    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeDetailRepository commonCodeDetailRepository;

    public CommonCodePageDto getCommonCodes(CommonCodeRequestDto commonCodeRequestDto, Pageable pageable){        
        return commonCodeRepository.searchAll(commonCodeRequestDto, pageable);
    }

    @Transactional
    public CommonCodeResponseDto saveCommonCode(CommonCodeRequestDto commonCodeDto){
        CommonCodeEntity commonCodeEntity = CommonCodeEntity.builder()
                            .commonCodeName(commonCodeDto.getCommonCodeName())
                            .commonCodeDisplayName(commonCodeDto.getCommonCodeDisplayName())
                            .build();
        CommonCodeEntity savedCommonCode = commonCodeRepository.save(commonCodeEntity);
        return new CommonCodeResponseDto(savedCommonCode);
    }

    @Transactional
    public CommonCodeResponseDto updateCommonCode(long commonCodeId, CommonCodeRequestDto commonCodeDto){
        CommonCodeEntity commonCodeEntity = commonCodeRepository.findByIdAndDeleteYn(commonCodeId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        commonCodeEntity.update(commonCodeDto.getCommonCodeName(), commonCodeDto.getCommonCodeDisplayName());
        return new CommonCodeResponseDto(commonCodeEntity);
    }

    @Transactional
    public void deleteCommonCode(long commonCodeId) {
        commonCodeDetailRepository.deleteAllByCommonCodeId(commonCodeId);
        CommonCodeEntity commonCodeEntity = commonCodeRepository.findByIdAndDeleteYn(commonCodeId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        commonCodeEntity.delete();
    }


}
