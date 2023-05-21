package com.myproject.generalapi.region.dto;

import java.util.List;

import com.myproject.generalapi.common.dto.PageDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegionPageDto {

    private List<RegionResponseDto> regions;
    private PageDto pages;

}
