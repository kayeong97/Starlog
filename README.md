<div align="center">

<img src="https://github.com/kayeong97/picture_repo/blob/main/software_design/Starlog_Logo.PNG?raw=true" alt="Starlog Logo" width="220" />

# Starlog

**막연한 꿈을 구체적인 목표로, 매일의 기록으로 자신만의 은하계를 완성하세요.**

[![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?style=flat-square&logo=mysql)](https://www.mysql.com/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green?style=flat-square)](https://www.thymeleaf.org/)

</div>

---

## 프로젝트 소개

Starlog는 **목표 달성 과정을 별자리로 시각화**하는 웹 서비스입니다.

> _"작심삼일도 10번 하면 한 달이 되고, 그것을 12번 반복하면 1년이 된다."_

사람들은 꿈을 가지라고 말하지만, 정작 무엇을 언제 어떻게 이루고 싶은지 명확하게 정하지 못한 채 막연한 바람으로만 남겨두는 경우가 많습니다. Starlog는 그 꿈을 **구체적인 목표로 설정**하고, **하루하루의 실천을 기록**하며, **별을 모아 별자리를 완성**하는 과정을 통해 성취감과 지속적인 동기를 제공합니다.

---

## 주요 기능

| 기능                   | 설명                                                                   |
| ---------------------- | ---------------------------------------------------------------------- |
| 🎯 **목표 설정**       | 목표명·카테고리·달성 기한·루틴을 등록하고 진행률을 자동 계산           |
| 📔 **일일 기록**       | 매일 실천 내용과 감정(무드)을 기록, 하루 한 번 별 1개 자동 지급        |
| ⭐ **별 보상**         | 기록을 완료할 때마다 별 1개 획득, 누적되어 별자리를 채워 나감          |
| 🌌 **별자리 진행**     | 생년월일 기반 황도 12궁 별자리가 배정되고, 기록이 쌓일수록 별이 채워짐 |
| 🗺 **나의 우주 지도**  | 이달의 기록을 달력으로 확인하고 별자리 완성도를 한눈에 파악            |
| 👤 **별지기 프로필**   | 수집한 별·연속 기록 일수·최근 기록·별자리 현황 등 통계 확인            |
| 🛡 **관리자 대시보드** | ADMIN 전용 페이지에서 전체 회원 목록 조회 및 시스템 현황 확인          |

---

## 기술 스택

| 분류      | 기술                               |
| --------- | ---------------------------------- |
| Language  | Java 21                            |
| Framework | Spring Boot 4.0.6                  |
| ORM       | Spring Data JPA / Hibernate        |
| View      | Thymeleaf, HTML / CSS / JavaScript |
| Database  | MySQL 8.x                          |
| Security  | Spring Security Crypto (BCrypt)    |
| Build     | Gradle 8.14.3                      |
| IDE       | Visual Studio Code                 |

### 아키텍처

```
Controller → Service → Repository → DB
```

- **Controller** (`HomeController`): HTTP 요청 처리 및 세션 인증
- **Service** (`UserService`, `GoalService`, `DailyRecordService`, `RoutineService`, `ConstellationService`): 비즈니스 로직
- **Repository**: Spring Data JPA 기반 DB 접근
- **Domain**: `StarlogUser`, `Goal`, `DailyRecord`, `Routine`, `RoutineCheck`, `RecordTag`, `UserFeedback`
- **Enum**: `GoalStatus`, `Mood`, `UserRole`

---

## 시작하기

### 사전 요구사항

- Java 21 이상
- MySQL 8.x
- Gradle (또는 프로젝트 내 `gradlew` 사용)

### 1. 데이터베이스 설정

MySQL에 접속하여 스키마를 생성합니다.

```bash
mysql -u root -p < starlog/src/main/resources/db/schema.sql
```

### 2. 환경 변수 설정

`starlog/.env` 파일을 생성하고 아래 내용을 입력합니다.

```properties
SERVER_PORT=8081

DB_HOST=url
DB_PORT=db_port
DB_NAME=starlog
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password
```

### 3. 실행

```bash
cd starlog
./gradlew bootRun
```

브라우저에서 `http://localhost:8081` 에 접속합니다.

### 4. 관리자 계정 설정 (선택)

DB에서 특정 계정의 `role` 컬럼을 `ADMIN`으로 변경하면 `/admin` 페이지에 접근할 수 있습니다.

```sql
UPDATE users SET role = 'ADMIN' WHERE username = 'your_username';
```

---

## 프로젝트 구조

```
Starlog/
├── docs/                          # 설계 문서
│   ├── 1_conceptualization.md     # 개념화 문서 (비즈니스 목적, 유스케이스)
│   ├── 2_analysis.md              # 분석 문서 (유스케이스 상세, UI 프로토타입)
│   └── 3_design.md                # 설계 문서 (클래스·시퀀스·상태 다이어그램)
│
└── starlog/                       # Spring Boot 애플리케이션
    ├── src/main/java/starlog/com/starlog/
    │   ├── HomeController.java         # 단일 컨트롤러 (모든 라우트 처리)
    │   ├── domain/                     # JPA 엔티티
    │   │   ├── StarlogUser.java
    │   │   ├── Goal.java
    │   │   ├── DailyRecord.java
    │   │   ├── Routine.java
    │   │   ├── RoutineCheck.java
    │   │   ├── RecordTag.java
    │   │   └── UserFeedback.java
    │   ├── repository/                 # Spring Data JPA 리포지토리
    │   └── service/                    # 비즈니스 로직
    │       ├── UserService.java
    │       ├── GoalService.java
    │       ├── DailyRecordService.java
    │       ├── RoutineService.java
    │       ├── ConstellationService.java
    │       └── PasswordHashService.java
    │
    ├── src/main/resources/
    │   ├── templates/                  # Thymeleaf 템플릿
    │   │   ├── home.html               # 랜딩 페이지
    │   │   ├── login.html              # 로그인
    │   │   ├── signup.html             # 회원가입
    │   │   ├── dashboard.html          # 목표 대시보드
    │   │   ├── goals.html              # 목표 관리
    │   │   ├── record.html             # 일일 기록 작성
    │   │   ├── map.html                # 나의 우주 지도 (캘린더)
    │   │   ├── profile.html            # 별지기 프로필
    │   │   ├── admin.html              # 관리자 대시보드
    │   │   └── fragments.html          # 공통 컴포넌트 (topbar, sidebar, footer)
    │   ├── static/
    │   │   ├── css/starlog.css         # 전역 스타일시트
    │   │   ├── js/starlog.js           # 사이드바 토글 등 인터랙션
    │   │   └── images/                 # 로고 등 정적 이미지
    │   ├── db/schema.sql               # DB 초기화 스크립트
    │   └── application.properties      # Spring 설정
    └── .env                            # 환경 변수 (gitignore 대상)
```

---

## 별자리 시스템

Starlog의 핵심 동기부여 요소입니다.

1. **별자리 배정**: 가입 시 생년월일을 입력하면 황도 12궁 중 해당 별자리가 배정됩니다. 생년월일이 없으면 누적 별 수를 기준으로 결정됩니다.
2. **별 획득**: 일일 기록을 작성할 때마다 별 1개가 자동으로 지급됩니다 (하루 1회).
3. **별자리 채우기**: 누적 별 수에 따라 배정된 별자리의 좌표가 하나씩 채워집니다.
4. **별자리 완성 → 다음 별자리**: 모든 좌표가 채워지면 완성되고, 다음 기록부터는 다음 별자리가 시작됩니다.
5. **반복**: 황도 12궁이 순서대로 반복되어 계속해서 새로운 별자리를 완성할 수 있습니다.
