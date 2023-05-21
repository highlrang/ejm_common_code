package com.myproject.generalapi.common.exception;

import com.myproject.generalapi.common.enums.CommonStatus;

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
