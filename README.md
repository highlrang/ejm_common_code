# MYSQL 
## 데이터베이스
- 데이터베이스명은 `assignment`로 설정해두었습니다. <br>

- 데이터베이스명을 변경하거나 <br>
- mysql dbms에서 ```create database assignment``` 로 데이터베이스 생성이 필요합니다.
<br><br>


## 테이블
JPA의 ddl-auto를 사용하여 <b>테이블은 자동 생성 및 제거</b>됩니다. <br>

테이블 정보를 위해 아래 테이블 생성문을 첨부합니다.
- 공통코드는 변하지 않는 값을 위주로 생성했으며, 지역의 경우는 다양하고 복잡한 데이터이기 때문에 테이블을 분리했습니다.
- 초기 데이터는 `resources/import.sql`를 통해 자동 생성됩니다.

<br>

공통코드 그룹 테이블
```mysql
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
```

상세 공통코드 테이블
```mysql
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
```

지역 테이블 
```mysql
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


<br><br>

# 로컬 서버 구동
다음 세 가지 방법 중 하나 사용
1. dbuser=DB사용자명 dbpassword=DB비밀번호 ./gradlew bootrun
    + gradlew Permission Denied 시 ```chmod +x gradlew```

<br>

2. IDE에 dbuser 및 dbpassword 환경변수 추가하여 `CommonCodeApplication.java` main 실행

<br>

3. `application.yml`에 `spring.datasource.username` 및 `spring.datasource.password` 값 넣어주기

<br><br>

# API Spec.
<b>host</b> `localhost`<br>
<b>port</b> `8080`<br>
<br>

<details>
<summary>
Region API Spec.
</summary>

-----------------------------------------------------
<h3>POST /api/v1/region/list</h3>
- 지역 코드 목록 조회
<br><br>
<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|regionName|String|지역명|X|
|regionDepth|Integer|지역레벨|X|
|regionParentId|Long|부모지역아이디|X|
|page|페이지|int|X default 0|
|size|사이즈|int|X default 100|

<br>

<b>response</b>

|column ||| type | description |
|------|----|----|-----|------|
|code|||String|코드|
|status|||int|상태|
|data|||Object||
||regions||List|지역정보
|||regionId|int|아이디
|||regionName|String|지역명
|||regionDepth|int|지역레벨
|||regionParentId|int|부모지역아이디
||pages||Object|페이지정보
|||totalElements|int|총개수
|||totalPages|int|총페이지수
|||page|int|현재 페이지
|||size|int|페이지 사이즈

-------------------------------------------
<br>


<h3>GET /api/v1/region/{regionId}</h3>
- 지역 코드 상세 조회
<br><br>
<b>uri path</b>

|column | type | description | required |
|-------|------|-------------|----------|
|regionId|int|지역코드 아이디|O|

<br>

<b>response</b>

|column || type | description |
|------|----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||regionId|int|아이디
||regionName|String|지역명
||regionDepth|int|지역레벨
||regionParentId|int|부모지역아이디

-------------------------------------------
<br>


<h3>POST /api/v1/region/create</h3>
- 지역 코드 생성
<br><br>
<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|regionName|String|지역명|O|
|regionDepth|Integer|지역레벨|O|
|regionParentId|Integer|부모지역아이디|O|

<br>

<b>response</b>

|column || type | description |
|------|----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||regionId|int|아이디
||regionName|String|지역명
||regionDepth|int|지역레벨
||regionParentId|int|부모지역아이디


-------------------------------------------
<br>


<h3>PATCH /api/v1/region/update/{regionId}</h3>
- 지역 코드 수정
<br><br>

<b>uri path</b>

|column | type | description | required |
|-------|------|-------------|----------|
|regionId|int|지역코드 아이디|O|

<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|regionName|String|지역명|O|

<br>

<b>response</b>

|column || type | description |
|------|----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||regionId|int|아이디
||regionName|String|지역명
||regionDepth|int|지역레벨
||regionParentId|int|부모지역아이디

<br>


-------------------------------------------
<br>


<h3>DELETE /api/v1/region/{regionId}</h3>
- 지역 코드 삭제
<br><br>

<b>uri path</b>

|column | type | description | required |
|-------|------|-------------|----------|
|regionId|int|지역코드 아이디|O|

<br><br>


--------------------------------------------
<br><br>
</details>

<details>
<summary>
CommonCode API Spec.
</summary>

--------------------------------------------

<h3>POST /api/v1/common-code/list</h3>
- 공통 코드 목록 조회
<br><br>
<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeName|String|코드명|X|
|commonCodeDisplayName|Integer|코드전시명|X|
|page|페이지|int|X default 0|
|size|사이즈|int|X default 100|

<br>

<b>response</b>

|column ||| type | description |
|------|----|----|-----|------|
|code|||String|코드|
|status|||int|상태|
|data|||Object||
||commonCodes||List|코드정보
|||commonCodeId|int|코드아이디
|||commonCodeName|String|코드명
|||commonCodeDisplayName|String|코드전시명
||pages||Object|페이지정보
|||totalElements|int|총개수
|||totalPages|int|총페이지수
|||page|int|현재 페이지
|||size|int|페이지 사이즈

<br>

-------------------------------------------

<br>

<h3>POST /api/v1/common-code/create</h3>
- 공통 코드 생성
<br><br>
<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeName|String|코드명|O|
|commonCodeDisplayName|String|코드전시명|O|

<br>

<b>response</b>

|column || type | description |
|------|-----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||commonCodeId|int|코드아이디
||commonCodeName|String|코드명
||commonCodeDisplayName|String|코드전시명

<br>

--------------------------------------------

<br>


<h3>PATCH /api/v1/common-code/update/{commonCodeId}</h3>
- 공통 코드 수정
<br><br>

<b>uri path</b>

|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeId|int|코드아이디|O|

<br>

<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeName|String|코드명|X|
|commonCodeDisplayName|String|코드전시명|X|

<br>

<b>response</b>

|column || type | description |
|------|-----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||commonCodeId|int|코드아이디
||commonCodeName|String|코드명
||commonCodeDisplayName|String|코드전시명

<br>

--------------------------------------------

<br>


<h3>DELETE /api/v1/common-code/{commonCodeId}</h3>
- 공통 코드 삭제

<br>

<b>uri path</b>
|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeId|int|코드아이디|O|


--------------------------------------------
<br><br>
</details>

<details>
<summary>
CommonCodeDetail API Spec.
</summary>

--------------------------------------------
<br>

<h3>POST /api/v1/common-code-detail/list</h3>
- 상세 공통 코드 목록 조회
<br><br>

<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|page|int|페이지|X default 0|
|size|int|페이지사이즈|X default 100|

<br>

<b>response</b>
|column ||| type | description |
|------|----|----|-----|------|
|code|||String|코드|
|status|||int|상태|
|data|||Object||
||commonCodeDetails||List|코드정보
|||commonCodeDetailId|int|상세코드아이디
|||commonCodeId|int|코드그룹아이디
|||commonCodeName|String|코드그룹명
|||commonCodeDetailName|String|상세코드명
|||commonCodeDetailDisplayName|String|상세코드전시명
||pages||Object|페이지정보
|||totalElements|int|총개수
|||totalPages|int|총페이지수
|||page|int|현재 페이지
|||size|int|페이지 사이즈

<br>
--------------------------------------------
<br>

<h3>POST /api/v1/common-code-detail/list/{commonCodeId}</h3>
- 상세 공통 코드 목록 조회
<br><br>

<b>uri path</b>
|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeId|int|코드아이디|O|

<b>request</b>
|column | type | description | required |
|-------|------|-------------|----------|
|page|int|페이지|X default 0|
|size|int|페이지사이즈|X default 100|

<br>

<b>response</b>
|column ||| type | description |
|------|----|----|-----|------|
|code|||String|코드|
|status|||int|상태|
|data|||Object||
||commonCodeDetails||List|코드정보
|||commonCodeDetailId|int|상세코드아이디
|||commonCodeId|int|코드그룹아이디
|||commonCodeName|String|코드그룹명
|||commonCodeDetailName|String|상세코드명
|||commonCodeDetailDisplayName|String|상세코드전시명
||pages||Object|페이지정보
|||totalElements|int|총개수
|||totalPages|int|총페이지수
|||page|int|현재 페이지
|||size|int|페이지 사이즈


<br>

--------------------------------------------------

<br>

<h3>POST /api/v1/common-code-detail/create</h3>
- 상세 공통 코드 생성
<br><br>
<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeId|Integer|코드아이디|O|
|commonCodeDetailName|String|코드명|O|
|commonCodeDetailDisplayName|String|코드전시명|O|

<br>

<b>response</b>

|column || type | description |
|------|-----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||commonCodeDetailId|int|상세코드아이디
||commonCodeId|int|코드그룹아이디
||commonCodeName|String|코드그룹명
||commonCodeDetailName|String|상세코드명
||commonCodeDetailDisplayName|String|상세코드전시명

--------------------------------------------
<br>

<h3>PATCH /api/v1/common-code-detail/update/{commonCodeDetailId}</h3>
- 상세 공통 코드 수정
<br><br>
<b>uri path</b>
|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeDetailId|int|상세코드아이디|O|

<b>request</b>

|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeDetailName|String|상세코드명|X|
|commonCodeDetailDisplayName|String|상세코드전시명|X|

<br>

<b>response</b>

|column || type | description |
|------|-----|-----|------|
|code||String|코드|
|status||int|상태|
|data||Object||
||commonCodeDetailId|int|상세코드아이디
||commonCodeId|int|코드그룹아이디
||commonCodeName|String|코드그룹명
||commonCodeDetailName|String|상세코드명
||commonCodeDetailDisplayName|String|상세코드전시명

--------------------------------------------
<br>

<h3>DELETE /api/v1/common-code-detail/{commonCodeDetailId}</h3>
- 상세 공통 코드 삭제

<br>

<b>uri path</b>
|column | type | description | required |
|-------|------|-------------|----------|
|commonCodeDetailId|int|상세코드아이디|O|


--------------------------------------------

</details>