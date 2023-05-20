package com.myproject.commoncode.core.exception;

import com.myproject.commoncode.core.enums.CommonStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomException extends RuntimeException {
    
    private CommonStatus commonStatus;

    public CustomException(CommonStatus commonStatus){
        this.commonStatus = commonStatus;
    }

}
