# MYSQL 
## 데이터베이스
데이터베이스명은 `assignment`
데이터베이스명 변경 혹은 mysql dbms에서 ```create database assignment``` 로 데이터베이스 생성 필요

## 테이블
JPA의 ddl-auto를 사용하여 <b>테이블은 자동 생성 및 제거</b>됩니다.
테이블 정보를 위해 테이블 생성문을 제공합니다.
    - 공통코드는 변하지 않는 값을 위주로 생성했으며, 지역의 경우는 다양하고 복잡한 데이터이기 때문에 테이블을 분리했습니다.
초기 데이터는 `resources/import.sql`를 통해 자동 생성됩니다.

```mysql
# 공통코드 그룹 테이블
create table common_code(
    common_code_id bigint auto_increment primary key,
    common_code_name varchar(30) not null comment '코드명',
    common_code_display_name varchar(60) not null comment '코드 전시명; 한글',
    delete_yn varchar(1) not null default 'N' comment '삭제 여부',
    create_by varchar(10) not null default 'system' comment '생성자',
    create_date timestamp not null default now() comment '생성일',
    update_by varchar(10) not null default 'system' comment '수정자',
    update_date timestamp not null default now() comment '수정일'
);

# 상세 공통코드 테이블
create table common_code_detail( 
    common_code_detail_id bigint auto_increment primary key,
    common_code_id bigint,
    common_code_detail_name varchar(30) not null comment '코드명',
    common_code_detail_display_name varchar(60) not null comment '코드 전시명; 한글',
    delete_yn varchar(1) not null default 'N' comment '삭제 여부',
    create_by varchar(10) not null default 'system' comment '생성자',
    create_date timestamp not null default now() comment '생성일',
    update_by varchar(10) not null default 'system' comment '수정자',
    update_date timestamp not null default now() comment '수정일'
);

# 지역 테이블 
create table REGION(
	region_id bigint auto_increment primary key,
	region_name varchar(20),
	region_depth int,
	region_parent_id bigint,
	delete_yn varchar(1) not null default 'N' comment '삭제 여부',
    create_by varchar(10) not null default 'system' comment '생성자',
    create_date timestamp not null default now() comment '생성일',
    update_by varchar(10) not null default 'system' comment '수정자',
    update_date timestamp not null default now() comment '수정일'
);
```


<br>

# 로컬 서버 구동
다음 세 가지 방법 중 하나 사용
1. dbuser=DB사용자명 dbpassword=DB비밀번호 ./gradlew bootrun
    + gradlew Permission Denied 시 ```chmod +x gradlew```

<br>

2. IDE에 dbuser 및 dbpassword 환경변수 추가하여 `CommonCodeApplication.java` main 실행

<br>

3. `application.yml`에 `spring.datasource.username` 및 `spring.datasource.password` 값 넣어주기

<br>

# API Spec.
