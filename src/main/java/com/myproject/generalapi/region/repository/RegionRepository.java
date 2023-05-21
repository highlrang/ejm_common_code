package com.myproject.generalapi.region.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.generalapi.region.domain.RegionEntity;

public interface RegionRepository extends JpaRepository<RegionEntity, Long>, RegionQueryRepository {
    
    Optional<RegionEntity> findByRegionIdAndDeleteYn(long regionId, String deleteYn);
}
