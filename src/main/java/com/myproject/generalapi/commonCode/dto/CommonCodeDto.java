package com.myproject.generalapi.commonCode.dto;

import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonCodeDto {

    private long commonCodeId;
    private String commonCodeName;
    private String commonCodeDisplayName;

    public CommonCodeDto(CommonCodeEntity e){
        this.commonCodeId = e.getCommonCodeId();
        this.commonCodeName = e.getCommonCodeName();
        this.commonCodeDisplayName = e.getCommonCodeDisplayName();
    }

    @QueryProjection
    public CommonCodeDto(long commonCodeId, String commonCodeName, String commonCodeDisplayName) {
        this.commonCodeId = commonCodeId;
        this.commonCodeName = commonCodeName;
        this.commonCodeDisplayName = commonCodeDisplayName;

    }
}
