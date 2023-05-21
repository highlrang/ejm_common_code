package com.myproject.generalapi.commonCode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommonCodeDetailRequestDto {
    
    private long commonCodeId;
    private String commonCodeDetailName;
    private String commonCodeDetailDisplayName;
    
}
