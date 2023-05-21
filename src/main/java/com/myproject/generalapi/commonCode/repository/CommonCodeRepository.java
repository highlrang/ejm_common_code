package com.myproject.generalapi.commonCode.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;

public interface CommonCodeRepository extends JpaRepository<CommonCodeEntity, Long>, CommonCodeQueryRepository{
    
    Page<CommonCodeEntity> findAll(Pageable pageable);
    
}
