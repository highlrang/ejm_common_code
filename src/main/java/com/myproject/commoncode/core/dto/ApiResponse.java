package com.myproject.commoncode.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.myproject.commoncode.core.enums.CommonStatus.*;

import com.myproject.commoncode.core.enums.CommonStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    
    private String code;
    private int status;
    private Object data;

    public static ApiResponse success() {
        return ApiResponse.builder()
            .code(SUCCESS.getCode())
            .status(SUCCESS.getStatus())
            .build();
    }

    public static ApiResponse success(Object data) {
        return ApiResponse.builder()
            .code(SUCCESS.getCode())
            .status(SUCCESS.getStatus())
            .data(data)
            .build();
    }

    public static ApiResponse fail() {
        return ApiResponse.builder()
            .code(FAIL.getCode())
            .status(FAIL.getStatus())
            .build();
    }

    public static ApiResponse fail(CommonStatus commonStatus) {
        return ApiResponse.builder()
            .code(commonStatus.getCode())
            .status(commonStatus.getStatus())
            .build();
    }
}
