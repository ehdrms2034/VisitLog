# VisitLog
Mark down 조회수 서비스

## 1차 디자인
<img src="https://user-images.githubusercontent.com/37145713/92593745-92edb400-f2dc-11ea-8cb2-2ad363b61d9f.png" width="500px"/>

## 디자인 초안
![](https://user-images.githubusercontent.com/37145713/95292192-f81cd100-08ab-11eb-8f65-c965ef98f241.png)

## 1차 마일 스톤

![](https://user-images.githubusercontent.com/37145713/92592310-53be6380-f2da-11ea-808a-f0d15d9bafb1.png)

- 방문자 조회수를 Svg 파일로 만드는 visit server 👌
  - Base 62 인코딩을 통한 URL 최적화
- client측 부하 분산 및 service discovery 서버 담당해줄 eureka 👌
- 마이크로 서비스 config 서버 👌
  - RSA 암호화를 통한 기존 정보 암호화 👌
- 리버스 프록시 zuul 서버 👌
- 확장 가능한 구조로 만드는 것을 목표

## 기술 스택
### 백엔드
- Spring Boot 2.3.3
- Mysql 8.0
- Spring cloud (zuul + eureka + ribon + config)

### 프론트
- Nginx (미정) + React (미정)


## 2차 마일스톤
- Auth 서버 제작 (회원별 로그 분석 가능)
- 사용자 로그 분석 (ELK 혹은 OpenZipkin)
- 데이터 그래프화
- Zenkins
- 벌크헤드 풀백헤드 (서비스 장애 처리)
