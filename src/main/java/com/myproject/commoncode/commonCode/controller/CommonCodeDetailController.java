package com.myproject.commoncode.commonCode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.commoncode.commonCode.dto.CommonCodeDetailDto;
import com.myproject.commoncode.commonCode.service.CommonCodeDetailService;
import com.myproject.commoncode.core.dto.ApiResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/common-code-detail")
public class CommonCodeDetailController {
    
    private final CommonCodeDetailService commonCodeDetailService;

    @GetMapping
    public ResponseEntity<ApiResponse> getCommonCodeDetails(){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.getCommonCodeDetailList(Pageable 추가)
        ));
    }

    @GetMapping("/${commonCodeId}")
    public ResponseEntity<ApiResponse> getCommonCodeDetailsByCommonCodeId(@PathVariable("commonCodeId") long commonCodeId){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.getCommonCodeDetailList(commonCodeId)
        ));

    }

    @PostMapping
    public ResponseEntity<ApiResponse> saveCommonCodeDetail(@RequestBody CommonCodeDetailDto commonCodeDetailDto){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.saveCommonCodeDetail(commonCodeDetailDto)
        ));

    }
}
