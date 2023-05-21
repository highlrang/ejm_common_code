package com.myproject.generalapi.commonCode.repository;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.myproject.generalapi.commonCode.domain.QCommonCodeEntity.*;

import java.util.List;

import com.myproject.generalapi.common.dto.PageDto;
import com.myproject.generalapi.commonCode.dto.CommonCodePageDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeRequestDto;
import com.myproject.generalapi.commonCode.dto.CommonCodeResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
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

    public CommonCodePageDto searchAll(CommonCodeRequestDto commonCodeDto, Pageable pageable) {

        long commonCodeCnt = countAll();

        // TODO 정렬 추가
        JPAQuery<CommonCodeResponseDto> queryBuilder = jpaQueryFactory.select(
                Projections.constructor(CommonCodeResponseDto.class, 
                                            commonCodeEntity.commonCodeId, 
                                            commonCodeEntity.commonCodeName, 
                                            commonCodeEntity.commonCodeDisplayName
                                        ))
            .from(commonCodeEntity)
            .where(commonCodeEntity.deleteYn.eq("N"));

        if(commonCodeDto != null){
            queryBuilder = queryBuilder.where(
                likeCommonCodeName(commonCodeDto.getCommonCodeName()),
                likeCommonCodeDisplayName(commonCodeDto.getCommonCodeName())
            );
        }

        List<CommonCodeResponseDto> commonCodeDtos = queryBuilder    
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        PageImpl<CommonCodeResponseDto> commonCodePages = new PageImpl<CommonCodeResponseDto>(commonCodeDtos, pageable, commonCodeCnt);

        PageDto pages = new PageDto(commonCodeCnt, commonCodePages.getTotalPages(), pageable.getPageNumber(), pageable.getPageSize());
        return new CommonCodePageDto(commonCodeDtos, pages);
        
    }

    private BooleanExpression likeCommonCodeName(String commonCodeName){
        if(commonCodeName == null) return null;
        return commonCodeEntity.commonCodeName.contains(commonCodeName);
    }

    private BooleanExpression likeCommonCodeDisplayName(String commonCodeDisplayName){
        if(commonCodeDisplayName == null) return null;
        return commonCodeEntity.commonCodeDisplayName.contains(commonCodeDisplayName);
    }
    
}
