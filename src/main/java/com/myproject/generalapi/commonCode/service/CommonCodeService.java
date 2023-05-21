package com.myproject.generalapi.commonCode.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.generalapi.common.enums.CommonStatus;
import com.myproject.generalapi.common.exception.CustomException;
import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;
import com.myproject.generalapi.commonCode.dto.CommonCodeDto;
import com.myproject.generalapi.commonCode.repository.CommonCodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonCodeService {
    
    private final CommonCodeRepository commonCodeRepository;

    public List<CommonCodeDto> getCommonCodes(CommonCodeDto commonCodeDto, Pageable pageable){        
        commonCodeRepository.searchAll(commonCodeDto, pageable);
        return null; 
    }

    @Transactional
    public CommonCodeDto saveCommonCode(CommonCodeDto commonCodeDto){
        CommonCodeEntity commonCodeEntity = CommonCodeEntity.builder()
                            .commonCodeName(commonCodeDto.getCommonCodeName())
                            .commonCodeDisplayName(commonCodeDto.getCommonCodeDisplayName())
                            .build();
        CommonCodeEntity savedCommonCode = commonCodeRepository.save(commonCodeEntity);
        return new CommonCodeDto(savedCommonCode);
    }

    @Transactional
    public CommonCodeDto updateCommonCode(long commonCodeId, CommonCodeDto commonCodeDto){
        CommonCodeEntity commonCodeEntity = commonCodeRepository.findById(commonCodeId)
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        commonCodeEntity.update(commonCodeDto.getCommonCodeName(), commonCodeDto.getCommonCodeDisplayName());
        return new CommonCodeDto(commonCodeEntity);
    }

}
