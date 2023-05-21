package com.myproject.generalapi.commonCode.repository;

import org.springframework.data.domain.Pageable;

import com.myproject.generalapi.commonCode.dto.CommonCodePageDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeRequestDto;

public interface CommonCodeQueryRepository {
    
    CommonCodePageDto searchAll(CommonCodeRequestDto commonCodeDto, Pageable pageable);
    
}
