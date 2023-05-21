package com.myproject.generalapi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {

    private long totalCounts;
    private int totalPages;
    private int page;
    private int size;
}
