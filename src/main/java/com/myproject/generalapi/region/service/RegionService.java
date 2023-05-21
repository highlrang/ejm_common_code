package com.myproject.generalapi.region.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.generalapi.common.enums.CommonStatus;
import com.myproject.generalapi.common.exception.CustomException;
import com.myproject.generalapi.region.domain.RegionEntity;
import com.myproject.generalapi.region.dto.RegionPageDto;
import com.myproject.generalapi.region.dto.RegionRequestDto;
import com.myproject.generalapi.region.dto.RegionResponseDto;
import com.myproject.generalapi.region.repository.RegionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionService {
    
    private final RegionRepository regionRepository;

    public RegionPageDto getRegions(RegionRequestDto regionRequestDto, Pageable pageable) {
        return regionRepository.searchAll(regionRequestDto, pageable);
    }

    public RegionResponseDto getRegion(long regionId) {
        RegionEntity regionEntity = regionRepository.findByIdAndDeleteYn(regionId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));

        return new RegionResponseDto(regionEntity);
    }

    @Transactional
    public RegionResponseDto saveRegion(RegionRequestDto regionRequestDto) {
        RegionEntity regionEntity = RegionEntity.builder()
            .regionName(regionRequestDto.getRegionName())
            .regionDepth(regionRequestDto.getRegionDepth())
            .regionParentId(regionRequestDto.getRegionParentId())
            .build();
        
        RegionEntity savedRegion = regionRepository.save(regionEntity);
        return new RegionResponseDto(savedRegion);
    }

    @Transactional
    public RegionResponseDto updateRegion(long regionId, RegionRequestDto regionDto) {
        RegionEntity regionEntity = regionRepository.findByIdAndDeleteYn(regionId, "N")
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        
        regionEntity.update(regionDto.getRegionName());
        return new RegionResponseDto(regionEntity);
    }

    @Transactional
	public void deleteRegion(long regionId) {
        RegionEntity regionEntity = regionRepository.findById(regionId)
            .orElseThrow(() -> new CustomException(CommonStatus.DATA_NOT_FOUND));
        regionEntity.delete();
	}
}
