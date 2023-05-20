package com.myproject.commoncode.core.domain;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
    
    private String deleteYn;
    private String createBy;
    private LocalDateTime createDate;
    private String updateBy;
    private LocalDateTime updateDate;
}
