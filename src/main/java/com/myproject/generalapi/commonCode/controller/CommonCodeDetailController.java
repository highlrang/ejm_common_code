package com.myproject.generalapi.commonCode.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.generalapi.common.dto.ApiResponse;
import com.myproject.generalapi.commonCode.dto.CommonCodeDetailDto;
import com.myproject.generalapi.commonCode.service.CommonCodeDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/common-code-detail")
public class CommonCodeDetailController {
    
    private final CommonCodeDetailService commonCodeDetailService;

    @GetMapping
    public ResponseEntity<ApiResponse> getCommonCodeDetails(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.getCommonCodeDetails(pageable)
        ));
    }

    @GetMapping("/{commonCodeId}")
    public ResponseEntity<ApiResponse> getCommonCodeDetailsByCommonCodeId(
                                                                            @PathVariable("commonCodeId") long commonCodeId,
                                                                            Pageable pageable
                                                                        ){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.getCommonCodeDetails(commonCodeId, pageable)
        ));

    }

    @PostMapping
    public ResponseEntity<ApiResponse> saveCommonCodeDetail(@RequestBody CommonCodeDetailDto commonCodeDetailDto){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.saveCommonCodeDetail(commonCodeDetailDto)
        ));
    }

    @PutMapping("/{commonCodeDetailId}")
    public ResponseEntity<ApiResponse> updateCommonCodeDetail(
                                                                @PathVariable("commonCodeDetailId") long commonCodeDetailId,
                                                                @RequestBody CommonCodeDetailDto commonCodeDetailDto
                                                             ){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.updateCommonCodeDetail(commonCodeDetailId, commonCodeDetailDto)
        ));
    }
}
