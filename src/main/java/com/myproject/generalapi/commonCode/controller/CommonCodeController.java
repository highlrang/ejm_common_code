package com.myproject.generalapi.commonCode.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.generalapi.common.dto.ApiResponse;
import com.myproject.generalapi.commonCode.dto.CommonCodeDto;
import com.myproject.generalapi.commonCode.service.CommonCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/common-code")
public class CommonCodeController {
    
    private final CommonCodeService commonCodeService;

    @GetMapping
    public ResponseEntity<ApiResponse> getCommonCodes(@RequestBody CommonCodeDto commonCodeDto, Pageable pageable){
        return ResponseEntity.ok(ApiResponse.success(
                                                        commonCodeService.getCommonCodes(commonCodeDto, pageable)
                                                    ));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCommonCode(@RequestBody CommonCodeDto commonCodeDto){
        return ResponseEntity.ok(ApiResponse.success(
                                                        commonCodeService.saveCommonCode(commonCodeDto)
                                                    ));
    }

    @PatchMapping("/{commonCodeId}")
    public ResponseEntity<ApiResponse> updateCommonCode(
                                                        @PathVariable("commonCodeId") long commonCodeId,
                                                        @RequestBody CommonCodeDto commonCodeDto){
        return ResponseEntity.ok(ApiResponse.success(
                                                        commonCodeService.updateCommonCode(commonCodeId, commonCodeDto)
                                                    ));
    }

    
    
}
