package com.myproject.commoncode.commonCode.dto;

import com.myproject.commoncode.commonCode.domain.CommonCodeEntity;

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
