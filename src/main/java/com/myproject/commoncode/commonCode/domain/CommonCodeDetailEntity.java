package com.myproject.commoncode.commonCode.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.myproject.commoncode.core.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/*
 * common_code_detail과 common_code는 다대일 연관관계
 * JPA 연관관계 매핑
 * @JoinColumn(name = "common_code_Id")
 * @ManyToOne(fetch=FetchType.LAZY)
 * private CommonCodeEntity commonCode;
 */
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMMON_CODE_DETAIL")
public class CommonCodeDetailEntity extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commonCodeDetailId;

    private long commonCodeId;

    @NotNull
    private String commonCodeDetailName;

    @NotNull
    private String commonCodeDetailDisplayName;
    
    public void update(String commonCodeDetailName, String commonCodeDetailDisplayName){
        this.commonCodeDetailName = commonCodeDetailName;
        this.commonCodeDetailDisplayName = commonCodeDetailDisplayName;
    }
}
