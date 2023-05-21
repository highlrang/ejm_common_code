package com.myproject.generalapi.commonCode.dto;

import java.util.List;

import com.myproject.generalapi.common.dto.PageDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeDetailPageDto {
    
    private List<CommonCodeDetailResponseDto> commonCodeDetails;
    private PageDto pages;
}
