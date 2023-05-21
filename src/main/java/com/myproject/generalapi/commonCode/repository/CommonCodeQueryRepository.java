package com.myproject.generalapi.commonCode.repository;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.myproject.generalapi.commonCode.dto.CommonCodeDto;

public interface CommonCodeQueryRepository {
    
    PageImpl<CommonCodeDto> searchAll(CommonCodeDto commonCodeDto, Pageable pageable);
    
}
