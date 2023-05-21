package com.myproject.commoncode.commonCode.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.commoncode.commonCode.domain.CommonCodeEntity;
import com.myproject.commoncode.commonCode.dto.CommonCodeDto;
import com.myproject.commoncode.commonCode.repository.CommonCodeRepository;
import com.myproject.commoncode.core.enums.CommonStatus;
import com.myproject.commoncode.core.exception.CustomException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonCodeService {
    
    private final CommonCodeRepository commonCodeRepository;

    public List<CommonCodeDto> getCommonCodes(CommonCodeDto commonCodeDto, Pageable pageable){        
        // TODO querydsl
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
