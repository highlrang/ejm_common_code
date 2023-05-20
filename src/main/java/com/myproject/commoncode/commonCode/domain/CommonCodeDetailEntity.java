package com.myproject.commoncode.commonCode.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.myproject.commoncode.core.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@Table(name = "COMMON_CODE_DETAIL")
@NoArgsConstructor
public class CommonCodeDetailEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commonCodeDetailId;

    @NotNull
    private String commonCodeDetailName;

    @NotNull
    private String commonCodeDetailDisplayName;
    
}
