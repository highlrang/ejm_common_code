package com.myproject.generalapi.region.repository;

import org.springframework.data.domain.Pageable;

import com.myproject.generalapi.region.dto.RegionPageDto;
import com.myproject.generalapi.region.dto.RegionRequestDto;

public interface RegionQueryRepository {
    
    RegionPageDto searchAll(RegionRequestDto regionDto, Pageable pageable);
    
}
