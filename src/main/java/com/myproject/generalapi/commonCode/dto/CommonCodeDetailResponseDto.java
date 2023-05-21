package com.myproject.generalapi.commonCode.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myproject.generalapi.commonCode.domain.CommonCodeDetailEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonCodeDetailResponseDto {

    private long commonCodeDetailId;
    private long commonCodeId;
    @JsonIgnore
    private String commonCodeName;
    private String commonCodeDetailName;
    private String commonCodeDetailDisplayName;


    public CommonCodeDetailResponseDto(CommonCodeDetailEntity e){
        this.commonCodeId = e.getCommonCodeId();
        this.commonCodeDetailId = e.getCommonCodeDetailId();
        this.commonCodeDetailName = e.getCommonCodeDetailName();
        this.commonCodeDetailDisplayName = e.getCommonCodeDetailDisplayName();
    }
}
