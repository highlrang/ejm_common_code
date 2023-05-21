package com.myproject.generalapi.commonCode.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.generalapi.commonCode.domain.CommonCodeDetailEntity;

public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetailEntity, Long>, CommonCodeDetailQueryRepository {

    Optional<CommonCodeDetailEntity> findByIdAndDeleteYn(long commonCodeDetailId, String deleteYn);
    
    Page<CommonCodeDetailEntity> findAllByDeleteYn(String deleteYn, Pageable pageable);

    Page<CommonCodeDetailEntity> findAllByCommonCodeIdAndDeleteYn(long commonCodeId, String deleteYn, Pageable pageable);
}
