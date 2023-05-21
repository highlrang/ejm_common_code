package com.myproject.commoncode.commonCode.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myproject.commoncode.commonCode.domain.CommonCodeEntity;

public interface CommonCodeRepository extends JpaRepository<CommonCodeEntity, Long>{
    
    Page<CommonCodeEntity> findAll(Pageable pageable);
    
}
