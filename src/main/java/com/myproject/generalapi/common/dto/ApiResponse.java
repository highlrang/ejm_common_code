package com.myproject.generalapi.common.dto;

import static com.myproject.generalapi.common.enums.CommonStatus.*;

import com.myproject.generalapi.common.enums.CommonStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
