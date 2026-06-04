# 3. Design

## Starlog

![Starlog Logo](https://github.com/kayeong97/picture_repo/blob/main/software_design/Starlog_Logo.PNG)
| Item | Content |
| ----------- | ---------------- |
| Student No. | 22321627 |
| Name | 김가영 |
| E-mail | im_770@naver.ocm |

---

## Revision History

| Revision date | Version # | Description                 | Author      |
| ------------- | --------: | --------------------------- | ----------- |
| MM/DD/YYYY    |      0.00 | Type brief description here | Author name |
| 05/22/2026    |      0.01 | first document              | 김가영      |
| 06/04/2026    |      0.02 | Routine frequency 추가, 진행률 계산 로직 반영, 관리자 피드백 조회 반영, 마이페이지 최근 기록 반영 | 김가영 |

---

## Contents

1. [Introduction](#1-introduction)
2. [Class Diagram](#2-class-diagram)
3. [Sequence Diagram](#3-sequence-diagram)
4. [State Machine Diagram](#4-state-machine-diagram)
5. [Implementation Requirements](#5-implementation-requirements)
6. [Glossary](#6-glossary)
7. [References](#7-references)

---

## 1. Introduction

이 문서는 Starlog 시스템의 소프트웨어 설계를 기술한다. Starlog는 사용자가 꿈을 구체적인 목표로 설정하고, 매일의 기록을 통해 목표 달성 과정을 관리할 수 있도록 돕는 Spring Boot 기반 웹 시스템이다.
본 설계는 도메인, 서비스, 리포지토리의 3계층 아키텍처를 기반으로 구성되어 있으며, 각 계층의 책임을 명확히 분리하여 유지보수성과 확장성을 높이는 것을 목표로 한다. 데이터 구조는 JPA 기반의 도메인 모델로 표현되며, 총 7개의 엔티티 클래스와 3개의 열거형을 통해 주요 객체와 상태를 관리한다. 또한 사용자가 일일 기록을 작성할 때마다 별 1개가 자동으로 지급되는 별 보상 시스템을 도입하여 지속적인 기록 작성을 유도한다. 사용자가 획득한 별은 누적 개수에 따라 별자리를 채우는 방식으로 반영되며, 사용자의 생년월일을 기준으로 황도 12궁 중 하나의 별자리가 배정되어 수집 현황을 시각적으로 확인할 수 있다. 더불어 목표와 루틴을 연결하고, 사용자의 일일 체크 여부를 기록함으로써 목표 달성 과정을 추적하며 목표 진행률을 자동으로 계산할 수 있도록 설계하였다.

---

## 2. Class Diagram

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/class_diagram.png)

Starlog의 클래스 구조는 `StarlogUser`를 중심으로 구성된다. 사용자 한 명이 여러 개의 목표(`Goal`)와 일일 기록(`DailyRecord`)을 가질 수 있고, 루틴(`Routine`)은 특정 목표에 연결되어 목표 달성을 위한 반복 실천 항목을 나타낸다. 루틴은 반복 빈도(`frequency`)를 가지며 `DAILY`(매일), `EVERY_OTHER`(격일), `WEEKLY_3`(주 3회), `FOCUS`(집중, 약 30%)를 선택할 수 있다. 일일 기록을 작성할 때 각 루틴의 수행 여부는 `RoutineCheck`에 기록되며, 이 체크 이력이 쌓여 목표의 진행률(`progressPercent`)이 자동으로 계산된다. 진행률 계산 시 각 루틴의 `frequency`에 따라 기대 체크 횟수(`totalExpected`)가 다르게 산정된다. 기록에는 태그(`RecordTag`)를 달 수 있고, 사용자는 시스템에 대한 피드백(`UserFeedback`)을 남길 수도 있다.

서비스 계층은 도메인 계층과 리포지토리 계층 사이에 위치하며, 각 기능별로 역할이 분리되어 있다. 회원 가입·로그인은 `UserService`가 담당하고, 비밀번호 처리는 `PasswordHashService`에 위임한다. 목표와 루틴 관련 비즈니스 로직은 각각 `GoalService`와 `RoutineService`가 맡으며, 일일 기록은 `DailyRecordService`가 처리한다. `ConstellationService`는 사용자의 누적 별 수와 생년월일을 받아 현재 별자리의 진행 현황을 계산해 반환하는 역할을 한다.

열거형으로는 목표 상태를 나타내는 `GoalStatus`, 일일 기록의 기분을 나타내는 `Mood`, 사용자 권한을 나타내는 `UserRole`이 있다.

---

## 3. Sequence Diagram

시퀀스 다이어그램은 분석 단계에서 도출한 유스케이스를 기반으로 작성했다. 사용자와 서비스 계층, 리포지토리, DB 사이에 어떤 순서로 메시지가 오가는지를 보여주며, 특히 여러 서비스가 협력하는 복합적인 흐름에 집중하였다.

### 회원가입

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_01_register.png)

회원가입 요청이 들어오면 시스템은 이메일과 아이디 중복 여부를 순서대로 확인한다. 두 조건 모두 통과하면 비밀번호를 해시로 변환해 저장하는데, 비밀번호 원문이 DB에 남아있으면 안 되기 때문이다.

### 로그인

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_02_login.png)

아이디로 사용자를 조회한 뒤, 입력한 비밀번호와 저장된 해시값이 일치하는지 확인한다. 인증 성공 시 사용자 객체를 반환하고, 실패하면 빈 Optional을 반환해 로그인 화면에 그대로 머무르게 된다.

### 내 정보 조회

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_03_myinfo.png)

별지기 정보 페이지에 접속하면 사용자 기본 정보와 함께 총 기록 수, 현재 별자리 진행 현황, 최근 12개의 기록 목록을 한 번에 불러온다. `ConstellationService`가 별 수와 생년월일을 받아 현재 진행 중인 별자리와 채워진 별의 수를 계산해 반환한다.

### 목표 등록

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_05_goal_create.png)

목표를 저장한 직후 루틴 설정도 함께 이루어진다. 루틴 교체는 기존 루틴을 인덱스 기준으로 업데이트하고, 새 목록보다 기존 루틴이 많으면 초과분만 삭제하며, 새 루틴이 더 많으면 추가 저장하는 incremental update 방식으로 동작한다. 각 루틴에는 반복 빈도(`frequency`)를 함께 저장한다.

### 목표 조회 및 진행률 확인

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_06_goal_view.png)

대시보드에 접속하면 사용자의 목표 목록을 내려받는다. 이와 함께 진행률 재계산이 수행되는데, 각 루틴의 반복 빈도(`frequency`)에 따라 기대 체크 횟수(`totalExpected`)가 다르게 계산된다. `DAILY`는 전체 기간 일수, `EVERY_OTHER`는 격일 횟수, `WEEKLY_3`는 주 3회 환산, `FOCUS`는 30% 환산으로 산정되며, 마감일이 없으면 생성일로부터 90일을 기준으로 삼는다. 실제 완료된 체크 수와의 비율로 진행률을 산출한다.

### 일일 기록 등록 및 별 보상 획득

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_09_daily_record.png)

기록을 저장하면 그 즉시 사용자에게 별 1개가 지급된다. 같은 날 기록이 이미 있으면 저장 자체가 차단되므로 하루 한 번만 보상이 지급된다. 기록 저장 이후에는 활성화된 루틴 각각에 대해 체크 여부를 `RoutineCheck`로 남겨 진행률 계산에 활용될 수 있도록 한다.

### 일일 기록 조회 및 캘린더 조회

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_10_record_view.png)

캘린더 페이지에서는 선택한 월의 전체 기록 목록을 한 번에 불러와 날짜별 기록 여부를 표시한다. 특정 날짜를 선택하면 그날의 기록 상세 내용을 따로 조회한다.

### 나의 밤하늘 조회

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_14_night_sky.png)

사용자의 별 수와 생년월일을 바탕으로 현재 진행 중인 별자리와 채워진 별의 좌표를 계산한다. 생년월일이 없는 경우엔 누적 별 수를 12로 나눈 나머지로 별자리를 결정한다. 반환된 좌표 정보를 화면에서 SVG나 Canvas로 렌더링해 밤하늘을 시각화한다.

### 로그아웃

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_17_logout.png)

서버 세션을 무효화하고 홈 페이지(`/`)로 이동시키는 단순한 흐름이다.

### 관리자 회원 목록 조회

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/seq_18_admin.png)

관리자는 `/admin` 페이지에 접속하면 `UserService.findAll()`을 통해 전체 가입 회원 목록을 조회할 수 있다. 총 회원 수와 총 기록 수를 상단에 표시하며, 회원 테이블에서는 닉네임·아이디·이메일·레벨·별 수집 수·권한을 확인할 수 있다. 검색 필드로 회원을 실시간 필터링할 수 있다. 또한 사용자가 제출한 피드백(`UserFeedback`)을 최신순으로 조회하여 표시한다. ADMIN 권한이 없는 사용자가 접근하면 대시보드로 리다이렉트된다.

---

## 4. State Machine Diagram

상태 머신 다이어그램은 시스템 내 주요 객체가 어떤 상태를 거치는지, 그리고 어떤 조건에서 상태가 바뀌는지를 보여준다. Goal, Routine, 사용자의 별 수집 흐름 이렇게 세 가지 측면으로 나눠 작성했다.

### Goal 상태 머신

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/sm_01_goal.png)

목표는 등록 시점부터 `ACTIVE` 상태가 된다. 사용자가 목표를 달성했다고 판단하면 `COMPLETED`로 전환할 수 있고, 더 이상 관리하지 않을 목표는 `ARCHIVED`로 보관 처리할 수 있다. 달성 후 보관하는 경우도 있으므로 `COMPLETED`에서 `ARCHIVED`로의 전이도 허용된다. 한 번 종료된 목표(`COMPLETED`, `ARCHIVED`)는 다시 `ACTIVE`로 되돌릴 수 없다.

### Routine 상태 머신

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/sm_02_routine.png)

루틴은 기본적으로 활성(`Active`) 상태로 생성된다. 비활성화하면 일일 기록 작성 화면의 체크 목록에 표시되지 않고, 진행률 계산에서도 제외된다. 다시 활성화하는 것도 가능하다. 목표에 연결된 루틴 목록을 새로 저장할 때는 기존 루틴이 전부 삭제되고 새 목록으로 교체된다.
일일 기록을 저장할 때 사용자의 모든 활성 루틴에 대해 체크 레코드가 자동으로 생성된다. 사용자가 체크한 루틴은 `Checked`, 그렇지 않은 루틴은 `Unchecked`로 저장되며 이후 변경되지 않는다. 같은 기록에 대해 동일한 루틴의 체크 레코드가 중복 생성되지 않도록 저장 전에 존재 여부를 확인한다.

### 사용자 레벨별자리 상태 머신

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/design/sm_03_star.png)

가입 직후에는 `NEW EXPLORER` 상태로 시작한다. 첫 일일 기록을 작성하는 순간 별 1개가 지급되면서 별 수집이 시작된다. 기록을 이어갈수록 별이 쌓이고 현재 별자리의 별 좌표가 하나씩 채워진다. 별자리에 배정된 모든 별이 채워지면 별자리 완성 상태가 되며, 그 다음 기록을 작성하면 다음 별자리가 시작된다. 황도 12궁이 순서대로 반복되기 때문에 사용자는 계속 새로운 별자리를 완성해 나갈 수 있다.

---

## 5. Implementation Requirements

### 개발 환경

| 항목       | 내용                           |
| ---------- | ------------------------------ |
| Language   | Java 21                        |
| Framework  | Spring Boot 4.0.6              |
| ORM        | Spring Data JPA / Hibernate    |
| Build Tool | Gradle 8.14.3                  |
| Database   | MySQL 8.x                      |
| Frontend   | Thymeleaf, HTML/CSS/JavaScript |
| IDE        | Visual Studio Code             |

### 런타임 환경

| 항목       | 내용                                                                                          |
| ---------- | --------------------------------------------------------------------------------------------- |
| JVM        | Java 21 (OpenJDK 또는 Eclipse Temurin)                                                        |
| Web Server | Spring Boot 4.x 내장 Tomcat 11.x                                                              |
| OS         | Windows 10 이상 / Ubuntu 20.04 LTS 이상 / macOS 12 이상                                       |
| 최소 RAM   | 512 MB (권장 1 GB 이상)                                                                       |
| 브라우저   | SVG 및 Canvas API를 지원하는 최신 브라우저 (Chrome 110+, Firefox 110+, Safari 16+, Edge 110+) |

### 주요 의존성

| 라이브러리                    | 용도                                                           |
| ----------------------------- | -------------------------------------------------------------- |
| spring-boot-starter-webmvc    | Spring MVC 기반 웹 요청 처리                                   |
| spring-boot-starter-data-jpa  | 도메인 엔티티와 DB 간 ORM 매핑                                 |
| spring-boot-starter-thymeleaf | 서버사이드 HTML 렌더링                                         |
| spring-security-crypto        | 비밀번호 BCrypt 해시 처리 (인증 기능 제외, 암호화 모듈만 사용) |
| lombok                        | 보일러플레이트 코드 감소 (`@Getter`, `@Builder` 등)            |
| spring-boot-devtools          | 개발 중 자동 재시작 및 LiveReload 지원                         |
| mysql-connector-j             | MySQL 데이터베이스 드라이버                                    |

### 아키텍처 제약 사항

- 서비스 계층(Service)은 도메인 계층과 리포지토리 계층 사이의 중재자 역할만 수행하며, 컨트롤러에서 리포지토리를 직접 호출하지 않는다.
- 비밀번호 원문은 DB에 저장하지 않으며, `PasswordHashService`를 통한 BCrypt 해시값만 저장한다.
- 같은 날짜에 대한 `DailyRecord` 중복 저장은 서비스 계층에서 사전에 차단한다.
- `ConstellationService`는 사용자의 누적 별 수와 생년월일만을 입력으로 받아 순수 계산 결과만 반환하며, 영속성 계층에 직접 접근하지 않는다.
- 별자리 시각화는 서버에서 좌표 데이터를 계산하여 클라이언트에 전달하고, 렌더링은 브라우저의 SVG 또는 Canvas API를 사용한다.

## 6. Glossary

Specifically describe all of the terms used in this document.

| Term                 | Description                                                                                                                                                                  |
| -------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Starlog              | 사용자가 꿈을 구체적인 목표로 설정하고, 매일의 기록을 통해 목표 달성 과정을 관리할 수 있도록 돕는 웹 기반 시스템                                                             |
| Goal                 | 사용자가 이루고자 하는 구체적인 목표. 목표명, 내용, 달성 기한 등의 정보를 포함할 수 있음                                                                                     |
| Daily Log            | 사용자가 하루 동안의 실천 내용이나 감정을 기록하는 기능 또는 기록 데이터                                                                                                     |
| Constellation        | 여러 개의 별이 모여 완성되는 시각적 성취 요소. 사용자의 지속적인 기록과 목표 달성 과정을 상징적으로 보여줌                                                                   |
| Notification Service | 사용자가 목표를 잊지 않고 꾸준히 실천할 수 있도록 알림과 리마인더를 제공하는 서비스                                                                                          |
| Database             | 사용자 정보, 목표, 일일 기록, 별 부여 내역, 별자리 진행 상태 등을 저장하는 데이터 저장소                                                                                     |
| 황도 12궁            | 태양이 지나는 황도 위에 위치한 12개의 별자리. 양자리, 황소자리, 쌍둥이자리, 게자리, 사자자리, 처녀자리, 천칭자리, 전갈자리, 사수자리, 염소자리, 물병자리, 물고기자리가 있다. |

---

## 7. References

Describe all of your references such as books, papers, technical reports, and websites.

| Category                  | Reference                                                                                                                                                                                     |
| ------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Goal setting              | Gollwitzer PM, Sheeran P. _Implementation intentions and goal achievement: A meta-analysis of effects and processes._ Adv Exp Soc Psychol. 2006;38:69-119. doi:10.1016/S0065-2601(06)38002-1. |
| Self-determination theory | Ryan RM, Deci EL. _Self-determination theory and the facilitation of intrinsic motivation, social development, and well-being._ Am Psychol. 2000;55(1):68-78. doi:10.1037/0003-066X.55.1.68.  |

---
