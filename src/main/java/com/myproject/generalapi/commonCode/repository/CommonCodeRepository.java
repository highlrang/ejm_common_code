package com.myproject.generalapi.commonCode.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;

public interface CommonCodeRepository extends JpaRepository<CommonCodeEntity, Long>, CommonCodeQueryRepository{
    
    Optional<CommonCodeEntity> findByCommonCodeIdAndDeleteYn(long commonCodeId, String deleteYn);
    Page<CommonCodeEntity> findAllByDeleteYn(String deleteYn, Pageable pageable);
    
}
