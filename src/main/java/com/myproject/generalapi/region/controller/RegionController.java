package com.myproject.generalapi.region.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.generalapi.common.dto.ApiResponse;
import com.myproject.generalapi.region.dto.RegionRequestDto;
import com.myproject.generalapi.region.service.RegionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/region")
public class RegionController {
    
    private final RegionService regionService;

    @PostMapping("/list")
    public ResponseEntity<ApiResponse> getRegions(
                                                    @RequestBody(required = false) RegionRequestDto regionRequestDto, 
                                                    @PageableDefault(size = 100) Pageable pageable){
        return ResponseEntity.ok(ApiResponse.success(
                regionService.getRegions(regionRequestDto, pageable)
        ));
    }

    @GetMapping("/{regionId}")
    public ResponseEntity<ApiResponse> getRegion(@PathVariable("regionId") long regionId){
        return ResponseEntity.ok(ApiResponse.success(
            regionService.getRegion(regionId)
        ));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveRegion(@RequestBody RegionRequestDto regionRequestDto){
        return ResponseEntity.ok(ApiResponse.success(
            regionService.saveRegion(regionRequestDto)
        ));
    }

    @PatchMapping("/update/{regionId}")
    public ResponseEntity<ApiResponse> updateRegion(
                                                    @PathVariable("regionId") long regionId, 
                                                    @RequestBody RegionRequestDto regionRequestDto
                                                    ){
        return ResponseEntity.ok(ApiResponse.success(
            regionService.updateRegion(regionId, regionRequestDto)
        ));
    }

    @DeleteMapping("/{regionId}")
    public ResponseEntity<ApiResponse> deleteRegion(@PathVariable("regionId") long regionId){
        regionService.deleteRegion(regionId);
        return ResponseEntity.ok(ApiResponse.success());
    }
}
