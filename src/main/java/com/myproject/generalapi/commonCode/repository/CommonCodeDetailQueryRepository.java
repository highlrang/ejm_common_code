package com.myproject.generalapi.commonCode.repository;

import com.myproject.generalapi.commonCode.dto.CommonCodeDetailResponseDto;

public interface CommonCodeDetailQueryRepository {
    
    CommonCodeDetailResponseDto findByCommonCodeDetailId(long commonCodeDetailId);
    long deleteAllByCommonCodeId(long commonCodeId);
}
