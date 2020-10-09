# VisitLog
Mark down 조회수 서비스



## 1차 마일 스톤

![](https://user-images.githubusercontent.com/37145713/92592310-53be6380-f2da-11ea-808a-f0d15d9bafb1.png)

- 방문자 조회수를 Svg 파일로 만드는 visit server
- client측 부하 분산 및 service discovery 서버 담당해줄 eureka
- 마이크로 서비스 config 서버
- 리버스 프록시 zuul 서버
- 확장 가능한 구조로 만드는 것을 목표

> 각 application.yml , bootstrap.yml 의 경우 Private git에 저장 => gitConfig 서버가 On돼있을 시 서버 Init 가능.

## 기술 스택
### 백엔드
- Spring Boot 2.3.3
- Mysql 8.0
- Spring cloud (zuul + eureka + ribon + config)

### 프론트
- Nginx (미정) + React (미정)
