# MYSQL 
데이터베이스명은 `assignment`
데이터베이스명 변경 혹은 mysql dbms에서 ```create database assignment``` 로 데이터베이스 생성 필요

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
