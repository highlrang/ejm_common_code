package com.myproject.commoncode.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonStatus {
    
    SUCCESS("SUCCESS", 1000),
    FAIL("FAIL", 4000),
    VALIDATION_ERROR("VALIDATION_ERROR", 4001),
    INTERNAL_SERVER_EXCEPTION("INTERNAL_SERVER_EXCEPTION", 4002),
    ;

    private final String code;
    private final int status;
}
