package com.myproject.commoncode.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.commoncode.region.domain.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long>{
    
}
