package com.myproject.commoncode.core.exception;

import java.sql.SQLException;
import java.util.Arrays;

import javax.validation.ValidationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myproject.commoncode.core.dto.ApiResponse;
import com.myproject.commoncode.core.enums.CommonStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> customException(CustomException e){
        return ResponseEntity.ok(ApiResponse.fail(e.getCommonStatus()));
    }

    @ExceptionHandler({ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ApiResponse> validationException(Exception e){
        log.error("ERROR = {} \n{}", e.toString(), Arrays.toString(e.getStackTrace()));
        return ResponseEntity.ok(ApiResponse.fail(CommonStatus.VALIDATION_ERROR));
    }

    @ExceptionHandler({SQLException.class, NullPointerException.class})
    public ResponseEntity<ApiResponse> serverException(Exception e){
        log.error("ERROR = {} \n{}", e.toString(), Arrays.toString(e.getStackTrace()));
        return ResponseEntity.ok(ApiResponse.fail(CommonStatus.INTERNAL_SERVER_EXCEPTION));
    }
}
