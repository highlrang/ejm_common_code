package com.myproject.generalapi.region.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.myproject.generalapi.common.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "REGION")
public class RegionEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regionId;

    @NotNull
    private String regionName;

    private int regionDepth;

    private long regionParentId;
    
    public void update(String regionName){
        if (regionName != null) this.regionName = regionName;
    }
}
