package com.myproject.generalapi.commonCode.dto;

import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;

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
}
