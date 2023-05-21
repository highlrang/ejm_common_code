package com.myproject.generalapi.region.dto;

import com.myproject.generalapi.region.domain.RegionEntity;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegionResponseDto {
        
    private long regionId;
    private String regionName;
    private Integer regionDepth;
    private Long regionParentId;

    @QueryProjection
    public RegionResponseDto(long regionId, String regionName, int regionDepth, long regionParentId){
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionDepth = regionDepth;
        this.regionParentId = regionParentId;
    }

    public RegionResponseDto(RegionEntity e){
        this.regionId = e.getRegionId();
        this.regionName = e.getRegionName();
        this.regionDepth = e.getRegionDepth();
        this.regionParentId = e.getRegionParentId();
    }
}

