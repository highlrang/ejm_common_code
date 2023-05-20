insert common_code(common_code_id, common_code_name, common_code_display_name) 
values 
    (1, 'PROJECT', '사업 구분'), 
    (2, 'RENEWAL_PLAN', '정비사업개요'), 
    (3, 'ARCH_PLAN', '건축계획'), 
    (4, 'LAND_USE_PLAN', '토지이용계획'), 
    (5, 'HOUSE_SUPPLY_PLAN', '주택공급계획 (분양)'),
    (6, 'PROGRESS_STAGE', '진행단계')
    ;

insert common_code(common_code_id, common_code_detail_name, common_code_detail_display_name) 
values 
    (1, 'REDEVELOPMENT', '재개발'), (1, 'RECONSTRUCTION', '재건축'), (1, 'ROW_HOUSE', '가로주택')
    ,(2, 'NAME', '조합/추진위명'),(2, 'PROJECT', '사업구분'),(2, 'LOCATION', '정비구역 위치'),(2, 'AREA', '정비구역 면적'), (2, 'OWNERS_CNT', '토지 등 소유자수'),(2, 'MEMBERS_CNT', '조합원 수'),(2, 'AREA_PURPOSE', '용도 지역')
    ,(3, 'LAND_AREA', '대지면적'),(3, 'FLOOR_AREA', '건축면적'),(3, 'GROSS_FLOOR_AREA', '연면적'),(3, 'BUILDING_COVERAGE_RATIO', '건폐율'),(3, 'FLOOR_AREA_RATIO', '용적률'),(3, 'BUILDING_HEIGHT', '건물높이'),(3, 'ABOVE_MAXIMUM_FLOOR_CNT', '최고층수 지상'),(3, 'BELOW_MAXIMUM_FLOOR_CNT', '최고층수 지하')
    ,(4, 'LAND', '택지'),(4, 'ROAD', '도로'),(4, 'PARK', '공원'),(4, 'GREEN', '녹지'),(4, 'PUBLIC', '공공공지'),(4, 'SCHOOL', '학교'),(4, 'ETC', '기타')
    ,(5, 'BUILDING_CNT', '동 수'),(5, 'HOUSEHOLDS_CNT', '세대 수'),(5, '60_SQUARE_BELOW_CNT', '60㎡ 이하'),(5, '60_80_SQUARE_BETWEEN_CNT', '60㎡ 초과 ~ 85㎡ 미만'),(5, '85_SQUARE_OVER_CNT', '85㎡ 초과'), (5, 'RENTAL_CNT', '임대세대 수')
    ,(6, 'BASIC_PLAN', '기본계획수립'),(6, 'SAFETY_EVALUATION', '안전진단'),(6, 'MAINTENANCE_AREA_DESIGNATION', '정비구역지정'),(6, 'COMMITTEE_APPROVAL', '조합설립 추진위원회 승인'),(6, 'ASSOCIATION_AUTHORIZATION', '조합설립인가'),(6, 'BUSINESS_AUTHORIZATION', '사업시행인가')
    ,(6, 'DISPOSITION_AUTHORIZATION', '관리처분인가'), (6, 'START_REPORT', '착공신고'),(6, 'SALES_APPROVAL', '일반분양승인'),(6, 'COMPLETION_AUTHORIZATION', '준공인가'),(6, 'MOVING_NOTICE', '이전고시'),(6, 'ASSOCIATION_TERMINATE', '조합해산 및 청산')
    ;

insert region(region_id, region_name, region_depth, region_parent_id) 
values 
    (1, '서울특별시', 1, 0), (2, '경기도', 1, 0), (3, '인천광역시', 1, 0), (4, '강원도', 1, 0), 
    (5, '충청북도', 1, 0), (6, '충청남도', 1, 0), (7, '세종특별자치시', 1, 0), (8, '대전광역시', 1, 0), 
    (9, '경상북도', 1, 0), (10, '경상남도', 1, 0), (11, '대구광역시', 1, 0), (12, '울산광역시', 1, 0), (13, '부산광역시', 1, 0),
    (14, '전라북도', 1, 0), (15, '전라남도', 1, 0),
    (16, '제주특별자치도', 1, 0),
    (17, '강남구', 2, 1), (18, '서초구', 2, 1), (19, '관악구', 2, 1), (20, '동작구', 2, 1), (21, '송파구', 2, 1),
    (22, '종로구', 2, 1), (23, '동대문구', 2, 1),
    (24, '용인시', 2, 2), (25, '수원시', 2, 2), (26, '성남시', 2, 2), 
    (27, '기흥구', 3, 24), (28, '수지구', 3, 24), (29, '처인구', 3, 24),
    (30, '영통구', 3, 25), (31, '팔달구', 3, 25), (32, '장안구', 3, 25),
    (33, '수정구', 3, 26), (34, '중안구', 3, 26), (35, '분당구', 3, 26),
    ;