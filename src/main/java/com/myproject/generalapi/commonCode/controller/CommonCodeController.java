 package com.myproject.generalapi.commonCode.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.generalapi.common.dto.ApiResponse;
import com.myproject.generalapi.commonCode.dto.CommonCodeRequestDto;
import com.myproject.generalapi.commonCode.service.CommonCodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/common-code")
public class CommonCodeController {
    
    private final CommonCodeService commonCodeService;

    @PostMapping("/list")
    public ResponseEntity<ApiResponse> getCommonCodes(
                                                        @RequestBody(required = false) CommonCodeRequestDto commonCodeDto, 
                                                        @PageableDefault(size = 100) Pageable pageable
                                                     ){
        return ResponseEntity.ok(ApiResponse.success(
                                                        commonCodeService.getCommonCodes(commonCodeDto, pageable)
                                                    ));
    }
    // TODO dto null exception handling
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCommonCode(@RequestBody CommonCodeRequestDto commonCodeDto){
        return ResponseEntity.ok(ApiResponse.success(
                                                        commonCodeService.saveCommonCode(commonCodeDto)
                                                    ));
    }

    @PatchMapping("/update/{commonCodeId}")
    public ResponseEntity<ApiResponse> updateCommonCode(
                                                        @PathVariable("commonCodeId") long commonCodeId,
                                                        @RequestBody CommonCodeRequestDto commonCodeDto){
        return ResponseEntity.ok(ApiResponse.success(
                                                        commonCodeService.updateCommonCode(commonCodeId, commonCodeDto)
                                                    ));
    }

    @DeleteMapping("/{commonCodeId}")
    public ResponseEntity<ApiResponse> deleteCommonCode(@PathVariable("commonCodeId") long commonCodeId){
        commonCodeService.deleteCommonCode(commonCodeId);
        return ResponseEntity.ok(ApiResponse.success());
    }
    
}
