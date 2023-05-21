package com.myproject.generalapi.region.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegionRequestDto {
    
    private String regionName;
    private Integer regionDepth;
    private Long regionParentId;
}
