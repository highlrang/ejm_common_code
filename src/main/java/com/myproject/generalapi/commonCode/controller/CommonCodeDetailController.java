package com.myproject.generalapi.commonCode.controller;

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
import com.myproject.generalapi.commonCode.dto.CommonCodeDetailRequestDto;
import com.myproject.generalapi.commonCode.service.CommonCodeDetailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/common-code-detail")
public class CommonCodeDetailController {
    
    private final CommonCodeDetailService commonCodeDetailService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> getCommonCodeDetails(@PageableDefault(size = 100) Pageable pageable){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.getCommonCodeDetails(pageable)
        ));
    }

    @GetMapping("/list/{commonCodeId}")
    public ResponseEntity<ApiResponse> getCommonCodeDetailsByCommonCodeId(
                                                                            @PathVariable("commonCodeId") long commonCodeId,
                                                                            @PageableDefault(size = 100) Pageable pageable
                                                                        ){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.getCommonCodeDetails(commonCodeId, pageable)
        ));

    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveCommonCodeDetail(@RequestBody CommonCodeDetailRequestDto commonCodeDetailDto){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.saveCommonCodeDetail(commonCodeDetailDto)
        ));
    }

    @PatchMapping("/update/{commonCodeDetailId}")
    public ResponseEntity<ApiResponse> updateCommonCodeDetail(
                                                                @PathVariable("commonCodeDetailId") long commonCodeDetailId,
                                                                @RequestBody CommonCodeDetailRequestDto commonCodeDetailDto
                                                             ){
        return ResponseEntity.ok(ApiResponse.success(
            commonCodeDetailService.updateCommonCodeDetail(commonCodeDetailId, commonCodeDetailDto)
        ));
    }

    @DeleteMapping("/{commonCodeDetailId}")
    public ResponseEntity<ApiResponse> deleteCommonCodeDetail(@PathVariable("commonCodeDetailId") long commonCodeDetailId){
        commonCodeDetailService.deleteCommonCodeDetail(commonCodeDetailId);
        return ResponseEntity.ok(ApiResponse.success());
    }
}
