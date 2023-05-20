package com.myproject.commoncode.region.domain;

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
@Table(name = "REGION")
@NoArgsConstructor
public class RegionEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regionId;

    @NotNull
    private String regionName;

    private int regionDepth;

    private long regionParentId;
    
}
