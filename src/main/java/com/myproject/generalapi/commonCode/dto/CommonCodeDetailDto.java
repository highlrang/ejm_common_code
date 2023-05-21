package com.myproject.generalapi.commonCode.dto;

import com.myproject.generalapi.commonCode.domain.CommonCodeDetailEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonCodeDetailDto {
    
    private long commonCodeId;
    private long commonCodeDetailId;
    private String commonCodeDetailName;
    private String commonCodeDetailDisplayName;

    public CommonCodeDetailDto(CommonCodeDetailEntity e){
        this.commonCodeId = e.getCommonCodeId();
        this.commonCodeDetailId = e.getCommonCodeDetailId();
        this.commonCodeDetailName = e.getCommonCodeDetailName();
        this.commonCodeDetailDisplayName = e.getCommonCodeDetailDisplayName();
    }
}
