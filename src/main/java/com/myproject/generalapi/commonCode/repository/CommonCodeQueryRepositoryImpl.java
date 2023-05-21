package com.myproject.generalapi.commonCode.repository;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.myproject.generalapi.commonCode.domain.QCommonCodeEntity.*;

import java.util.List;

import com.myproject.generalapi.commonCode.domain.CommonCodeEntity;
import com.myproject.generalapi.commonCode.dto.CommonCodeDto;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

// @Repository
@RequiredArgsConstructor
public class CommonCodeQueryRepositoryImpl implements CommonCodeQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public long countAll(){
        return jpaQueryFactory.select(commonCodeEntity.count())
            .from(commonCodeEntity)
            .fetchOne();
    }

    @Override
    public PageImpl<CommonCodeDto> searchAll(CommonCodeDto commonCodeDto, Pageable pageable) {

        long commonCodeCnt = countAll();

        List<CommonCodeDto> commonCodeDtos = jpaQueryFactory.select(
                Projections.constructor(CommonCodeDto.class, 
                                            commonCodeEntity.commonCodeId, 
                                            commonCodeEntity.commonCodeName, 
                                            commonCodeEntity.commonCodeDisplayName
                                        ))
            .from(commonCodeEntity)
            .where(
                likeCommonCodeName(commonCodeDto.getCommonCodeName()),
                likeCommonCodeDisplayName(commonCodeDto.getCommonCodeName())
            )
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        return new PageImpl<CommonCodeDto>(commonCodeDtos, pageable, commonCodeCnt);
        
    }

    private BooleanExpression likeCommonCodeName(String commonCodeName){
        if(commonCodeName == null) return null;
        return commonCodeEntity.commonCodeName.like(commonCodeName);
    }

    private BooleanExpression likeCommonCodeDisplayName(String commonCodeDisplayName){
        if(commonCodeDisplayName == null) return null;
        return commonCodeEntity.commonCodeDisplayName.like(commonCodeDisplayName);
    }
    
}
