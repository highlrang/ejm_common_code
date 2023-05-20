package com.myproject.commoncode.commonCode.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myproject.commoncode.core.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "COMMON_CODE")
@NoArgsConstructor
public class CommonCodeEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commonCodeId;

    // @NotNull
    private String commonCodeName;

    // @NotNull
    private String commonCodeDisplayName;

    
}
