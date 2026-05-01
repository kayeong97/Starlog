# 2. Analysis

## Starlog

![Starlog Logo](https://github.com/kayeong97/picture_repo/blob/main/software_design/Starlog_Logo.PNG)
| Item | Content |
| ----------- | ---------------- |
| Student No. | 22321627 |
| Name | 김가영 |
| E-mail | im_770@naver.ocm |

> > > > > > > 887e9a338135ee10fa534eabfee7a6a6bbb0bd45

## Revision History

| Revision date | Version # | Description                 | Author      |
| ------------- | --------: | --------------------------- | ----------- |
| MM/DD/YYYY    |      0.00 | Type brief description here | Author name |
| 05/01/2026    |      0.01 | first document              | 김가영      |

## Contents

1. [Introduction](#introduction)
2. [Use Case Analysis](#2-use-case-analysis)
3. [Domain Analysis](#3-domain-analysis)
4. [User Interface Prototype](#4-user-interface-prototype)
5. [Glossary](#5-glossary)
6. [References](#6-references)

## Introduction

Summarize the contents of this document.

- Describe the prominent features of your project, such as usefulness, significance, expandability, etc.
- 12pt, 160%.

### 1) Summary

Starlog는 막연한 꿈을 구체적인 목표로 바꾸고, 매일의 기록을 통해 그 목표를 꾸준히 이어갈 수 있도록 돕는 웹사이트이다. 사용자는 자신의 꿈을 명확한 목표로 설정하고, 하루하루의 실천을 기록하며 목표를 지속적으로 상기할 수 있다. Starlog는 단순한 할 일 관리가 아니라, 매일의 노력을 별로 보상하고 이를 별자리와 자신만의 하늘로 시각화함으로써 성취감과 동기부여를 제공한다. 이를 통해 사용자는 작은 실천이 쌓여 큰 목표를 이룰 수 있음을 경험하게 된다.

### 2) Describe the features of project

Starlog는 구체적인 목표를 세우고 실천 내용을 기록하여 그에 따른 별 보상을 줌으로써 자신의 목표와 실천 과정을 정리할 수 있다.

## 2. Use Case Analysis

- Build a use case diagram.
- Make detailed description for each use case.  
  Use case description.
- 12pt, 160%.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/usecase_diagram.png)

<table>
  <tr>
    <td colspan="2"><b>Use Case #1:</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td></td>
  </tr>
  <tr>
    <td>Scope</td>
    <td></td>
  </tr>
  <tr>
    <td>Level</td>
    <td></td>
  </tr>
  <tr>
    <td>Author</td>
    <td></td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td></td>
  </tr>
  <tr>
    <td>Status</td>
    <td></td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td></td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td></td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td></td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td></td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td></td>
  </tr>
  <tr>
    <td colspan="2"><b>MAIN SUCCESS SENARIO</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Action</b></td>
  </tr>
  <tr>
    <td>1</td>
    <td></td>
  </tr>
  <tr>
    <td>2</td>
    <td></td>
  </tr>
  <tr>
    <td>3</td>
    <td></td>
  </tr>
  <tr>
    <td>4</td>
    <td></td>
  </tr>
  <tr>
    <td>5</td>
    <td></td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td></td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td></td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td></td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td></td>
  </tr>
</table>

## 3. Domain Analysis

- Find all of classes in your project.
- Describe the meaning of each class.
- 12pt, 160%.

| 이름          | 설명                                                                                                                                                               |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| User          | 사용자 클래스. Starlog 서비스를 이용하는 회원 정보를 가진다. 이메일, 비밀번호, 아이디 등의 정보를 포함한다.                                                        |
| Goal          | 목표 클래스. 사용자가 달성하고자 하는 목표 정보를 가진다. 목표 제목, 목표 내용, 목표 기간, 목표 상태 등을 포함하며, 하나의 사용자는 여러 개의 목표를 가질 수 있다. |
| DailyLog      | 일일 기록 클래스. 사용자가 목표 달성을 위해 하루 동안 실천한 내용을 기록한다. 기록 내용, 작성 날짜, 와뇰 여부 등을 가지며 특정 목표와 연결된다.                    |
| Star          | 별 클래스. 사용자가 일일 기록을 완료하였을 때 지급되는 보상 정보를 가진다. 지급 날짜, 지급 대상 기록 등의 정보를 포함한다.                                         |
| Constellation | 별자리 클래스. 별자리의 정보를 가진다. 별자리 이름, 필요한 별 개수, 현재 별 개수, 완성 여부 등을 포함한다.                                                         |
| Schedule      | 일정 클래스. 사용자의 일정 정보를 가진다. 일정 제목, 일정 내용, 일정 날짜 등의 정보를 포함한다. 목표와 관련되지 않은 개인 일정도 포함한다.                         |
| Profile       | 프로필 클래서. 사용자의 개인 화면에서 보여지는 정보를 가진다. 닉네임, 목표 진행 상태, 획득한 별, 별자리 진행 상태 등 사용자의 활동 요약 정보를 제공한다.           |
| Notice        | 공지사항 클래스이다. 공지 제목, 공지 내용, 작성일, 수정일 등의 정보를 가지며 사용자는 등록된 공지사항을 확인할 수 있다.                                            |
| Inquiry       | 문의사항 클래스이다. 문의 제목, 문의 내용, 작성일, 처리 상태, 답변 내용 등의 정보를 가진다.                                                                        |
| Reply         | 문의사항에 대한 답변 클래스이다. 답변 내용, 작성일, 수정일 등의 정보를 가지며, 특정 문의사항과 연결된다.                                                           |

---

## 4. User Interface Prototype

Develop user interfaces of your system.

- It will be easy if you just think that you make a preliminary user manual of your system based on your user interface.
- 12pt, 160%.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/1.랜딩페이지.png)

### 랜딩 페이지

랜딩 페이지는 사용자가 Starlog 서비스를 처음 접하는 화면이다. Starlog의 핵심 컨셉인 “꿈을 별자리로 만드는 여정”라는 문구를 추가하여 사용자가 서비스의 목적을 직관적으로 이해할 수 있도록 구성하였다. 예시 목표 카드와 진행률을 보여주어 사용자가 목표를 기록하고 성정 과정을 확인하는 서비스임을 시각적으로 전달한다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/2.회원가입.png)

### 회원가입 페이지

회원가입 페이지는 사용자가 Starlog 서비스를 이용하기 위해 계정을 생성하는 화면이다. 사용자는 이메일, 닉네임, 아이디, 비밀번호를 입력하여 회원가입을 진행 할 수 있다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/3.로그인.png)

### 로그인 페이지

로그인 페이지는 기존 사용자가 Starlog에 접속하기 위해 아이디와 비밀번호를 입력하는 화면이다. 사용자는 로그인 정보를 입력한 후 로그인 버튼을 눌러 회원 확인 후 대시보드로 이동할 수 있다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/4.목표대시보드.png)

### 목표 대시보드 페이지

목표 대시보드 페이지는 로그인 후 사용자가 자신의 목표 진행 상황을 한눈에 확인하는 메인 화면이다. 중앙에 오늘의 성좌 완성도를 시각적으로 표시하여 사용자가 하루의 성취도를 직관적으로 확인할 수 있다. 하단에는 사용자가 설정한 목표 카드들이 배치되어 각 목표의 진행률, 완료 여부, 남은 기간 등을 확인할 수 있으며, 기록 추가 버튼을 통해 오늘의 기록 작성 화면으로 이동할 수 있다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/5.데일리로그.png)

### 데일리 로그 페이지

데일리 로그 페이지는 사용자가 하루 동안의 실천 내용과 감정을 기록하는 화면이다. 사용자는 오늘의 이야기를 텍스트로 작성하고, 기분을 선택하여 하루의 상태를 함께 남길 수 있다. 또한 데일리 루틴 체크 영역을 통해 오늘 수행한 작은 습관이나 목표 실천 항목을 체크할 수 있다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/6.목표설정.png)

### 목표 설정 페이지

목표 설정 페이지는 사용자가 새로운 목표를 등록하는 화면이다. 사용자는 목표 이름, 카테고리, 목표 달성일, 상세 기록을 이볅하여 자신만의 목표를 구체적으로 설정할 수 있다. 오른쪽에는 목표 설정을 돕는 안내 문구와 동기 부여 메시지를 배치하여 사용자가 막연한 꿈을 작은 실천 계획으로 나눌 수 있도록 유도한다. 등록 버튼을 누르면 DB에 저장이 되고, 이후 대시보드와 캘린더에서 진행 상황을 확인할 수 있다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/7.캘랜더.png)

### 캘린더 페이지

캘린더 페이지는 사용자의 기록과 목표 진행 상황을 날짜별로 확인할 수 있는 화면이다. 사용자는 월별 캘린더를 통해 어느 날 기록을 작성했는지, 별을 얼마나 획득했는지 확인할 수 있다. 각 날짜에는 별 아이콘과 일정 표시가 나타나며, 사용자의 실천 기록과 주요 목표 일정을 함께 보여준다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/8.마이페이지.png)

### 마이페이지

마이페이지는 사용자의 개인 정보와 활동 현황을 확인하는 화면이다. 사용자는 자신의 프로필 이미지, 닉네임, 레벨, 관심 태그 등을 확인할 수 있으며, 지금까지 수집한 별의 개수와 완성된 별자리 수를 볼 수 있다. 하단에는 계정 및 보안, 고객 지원, 로그아웃 등의 설정 메뉴를 배치하여 개인 환경을 관리할 수 있도록 구성하였다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/9.관리자대시보드.png)

### 관리자 대시보드 페이지

관리자 대시보드 페이지는 관리자가 서비스 운영 상태를 확인하고 사용자 정보를 관리하는 화면이다. 사용자 피드백, 누적 사용자 증가 수치, 전체 활성 사용자 수가 표시되어 서비스 이용 현황을 확인할 수 있다. 또한 사용자 관리 목록을 통해 가입일, 상태 등을 확인할 수 있다.

## 5. Glossary

- Specifically describe all of the terms used in this document.
- 12pt, 160%.

| Term                 | Description                                                                                                      |
| -------------------- | ---------------------------------------------------------------------------------------------------------------- |
| Starlog              | 사용자가 꿈을 구체적인 목표로 설정하고, 매일의 기록을 통해 목표 달성 과정을 관리할 수 있도록 돕는 웹 기반 시스템 |
| Goal                 | 사용자가 이루고자 하는 구체적인 목표. 목표명, 내용, 달성 기한 등의 정보를 포함할 수 있음                         |
| Daily Log            | 사용자가 하루 동안의 실천 내용이나 감정을 기록하는 기능 또는 기록 데이터                                         |
| Constellation        | 여러 개의 별이 모여 완성되는 시각적 성취 요소. 사용자의 지속적인 기록과 목표 달성 과정을 상징적으로 보여줌       |
| Notification Service | 사용자가 목표를 잊지 않고 꾸준히 실천할 수 있도록 알림과 리마인더를 제공하는 서비스                              |
| Database             | 사용자 정보, 목표, 일일 기록, 별 부여 내역, 별자리 진행 상태 등을 저장하는 데이터 저장소                         |

---

## 6. References

- Describe all of your references, such as books, papers, technical reports, etc.
- 12pt, 160%.

| Category                  | Reference                                                                                                                                                                                     |
| ------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Goal setting              | Gollwitzer PM, Sheeran P. _Implementation intentions and goal achievement: A meta-analysis of effects and processes._ Adv Exp Soc Psychol. 2006;38:69-119. doi:10.1016/S0065-2601(06)38002-1. |
| Self-determination theory | Ryan RM, Deci EL. _Self-determination theory and the facilitation of intrinsic motivation, social development, and well-being._ Am Psychol. 2000;55(1):68-78. doi:10.1037/0003-066X.55.1.68.  |

---
