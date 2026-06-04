# 2. Analysis

## Starlog

![Starlog Logo](https://github.com/kayeong97/picture_repo/blob/main/software_design/Starlog_Logo.PNG)
| Item | Content |
| ----------- | ---------------- |
| Student No. | 22321627 |
| Name | 김가영 |
| E-mail | im_770@naver.ocm |

## Revision History

| Revision date | Version # | Description                 | Author      |
| ------------- | --------: | --------------------------- | ----------- |
| MM/DD/YYYY    |      0.00 | Type brief description here | Author name |
| 05/01/2026    |      0.01 | first document              | 김가영      |
| 04/06/2026    |      0.02 | 코드 수정에 따른 문서 수정  | 김가영      |

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
    <td colspan="2"><b>Use Case #1: 회원가입</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 Starlog 서비스를 이용하기 위해 회원 정보를 입력하고 계정을 생성한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 가입되어 있지 않으며 Starlog 사이트에 접속하여야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 회원가입 화면에서 회원가입 버튼을 누를 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>입력한 회원 정보가 시스템에 저장되고, 사용자의 계정이 생성되며, 대시보드 화면으로 이동한다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>회원 정보가 저장되지 않으며, 사용자는 회원가입을 완료하지 못한다.</td>
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
    <td>사용자가 회원가입 화면에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 이메일, 아이디, 닉네임, 비밀번호, 생년월일 회원가입 입력 폼을 제공한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>사용자는 회원가입에 필요한 정보를 입력한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 회원가입 버튼을 클릭하여 서버에 회원가입 요청을 보낸다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>시스템은 입력 정보를 확인한 후 회원 정보를 저장하고 회원가입을 완료한 후 대시보드 화면으로 이동한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 사용자가 정보를 덜 입력하여 회원가입에 실패한다.<br>
        3a1. alert 알림창에 "모든 항목을 입력해주세요"라는 메시지를 보여준다.<br>
        3a2. 확인 버튼을 누르면 다시 회원가입 페이지로 돌아와 정보를 덜 입력한 입력폼의 테두리를 빨간색으로 제공한다. (Use case #1)</td>
  </tr>
  <tr>
    <td>5</td>
    <td>5a. 이미 가입된 이메일이 존재하여 회원가입에 실패한다.<br>
        5a1. 시스템은 "이미 가입된 이메일입니다."라는 에러 메시지를 회원가입 페이지에 표시한다.<br>
        5a2. 사용자는 다른 이메일로 수정하여 다시 시도한다. (Use case #1)<br><br>
        5b. 이미 사용 중인 아이디가 존재하여 회원가입에 실패한다.<br>
        5b1. 시스템은 "이미 사용 중인 아이디입니다."라는 에러 메시지를 회원가입 페이지에 표시한다.<br>
        5b2. 사용자는 다른 아이디로 수정하여 다시 시도한다. (Use case #1)</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>신규 사용자 당 한 번</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 회원가입을 요청할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #2: 로그인</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 Starlog 서비스를 사용하기 위해 가입된 계정 정보를 입력하여 서비스에 접속한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 가입된 계정을 가지고 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 로그인 화면에서 로그인 버튼을 누를 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 Starlog 서비스에 로그인되며, 목표 대시보드 화면으로 이동한다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>사용자는 로그인하지 못하며, 로그인 화면에 머무른다.</td>
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
    <td>사용자가 로그인 화면에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 아이디와 비밀번호 입력 폼을 제공한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>사용자는 가입된 아이디와 비밀번호를 입력한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 로그인 버튼을 클릭한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>시스템은 입력된 계정 정보를 확인한 후 로그인을 처리하고 목표 대시보드 화면으로 이동시킨다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 사용자가 정보를 덜 입력하여 로그인에 실패한다.<br>
        3a1. alert 알림창에 "모든 항목을 입력해주세요"라는 메시지를 보여준다.<br>
        3a2. 확인 버튼을 누르면 다시 로그인 페이지로 돌아와 정보를 덜 입력한 입력폼의 테두리를 빨간색으로 제공한다. (Use case #2)</td>
  </tr>
  <tr>
    <td>5</td>
    <td>5a. 존재하지 않는 계정 정보이거나 아이디/비밀번호가 일치하지 않아 로그인에 실패한다.<br>
        5a1. 시스템은 "아이디 또는 비밀번호를 확인해주세요."라는 에러 메시지를 로그인 페이지에 표시한다.<br>
        5a2. 사용자는 다시 로그인 페이지에서 정보를 수정하여 입력한다. (Use case #2)</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 Starlog 서비스를 이용할 때마다 평균 하루 2번</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 로그인을 요청할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #3: 내 정보 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 서비스에 저장된 자신의 정보를 조회한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인이 되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 프로필 페이지에 들어왔을 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 자신의 정보를 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>회원 정보가 조회되지 않으며, 시스템은 화면에 오류 메시지를 출력한다.</td>
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
    <td>사용자가 로그인 후 프로필 페이지(/profile)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 현재 로그인된 사용자 정보를 요청한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 데이터베이스에서 사용자의 회원정보를 조회한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 조회된 회원 정보를 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>사용자는 프로필 페이지에서 수집한 별 개수, 닉네임, 아이디, 이메일, 생년월일, 총 기록 수, 최근 기록 목록을 조회한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>5</td>
    <td>5a. 사용자의 기록이 없는 경우 최근 기록 영역이 비어있다.<br>
        5a1. 시스템은 최근 기록 영역에 빈 상태를 표시한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 서버 또는 데이터베이스 오류가 발생한 경우 회원 정보 조회에 실패한다.<br>
        3a1. 시스템은 화면에 오류 메시지를 출력한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 자신의 정보나 활동 현황을 확인하고 싶을 때</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 정보를 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #4: 목표 등록</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 새로운 목표를 입력하여 Starlog에 등록한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인 되어있으며 목표 관리 페이지(/goals)에 진입한 상태이다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>꿈 발사하기 버튼을 누르는 경우</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자가 입력한 목표 정보가 데이터베이스에 저장되고, 목표 관리 페이지에 반영된다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>목표가 저장되지 않으며 사용자에게 오류 메시지를 출력한다.</td>
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
    <td>사용자가 로그인 후 목표 관리 페이지(/goals)에 진입한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>사용자가 목표 추가하기 버튼을 누른다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 목표 등록 화면을 표시한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 목표명, 카테고리, 목표 달성일, 상세 설명, 루틴 항목 등을 입력한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>사용자는 꿈 발사하기 버튼을 클릭한다.</td>
  </tr>
  <tr>
    <td>6</td>
    <td>시스템은 입력된 목표 정보의 형식을 확인한다.</td>
  </tr>
  <tr>
    <td>7</td>
    <td>시스템은 목표 정보를 데이터베이스에 저장한다.</td>
  </tr>
  <tr>
    <td>8</td>
    <td>시스템은 등록된 목표를 목표 관리 페이지에 반영하고 해당 페이지로 이동한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>5</td>
    <td>5a. 사용자가 다른 페이지로 이동하거나 취소를 누를 경우 입력한 목표는 저장되지 않는다.<br>
        5a1. 사용자에게 모달창으로 "입력된 목표 정보를 저장하지 않으시겠습니까?"라는 메시지를 표시한다.<br>
        5a2. 사용자가 확인 버튼을 누르면 목표 관리 페이지로 돌아간다. (Use case #5)</td>
  </tr>
  <tr>
    <td>6</td>
    <td>6a. 사용자가 입력한 목표 정보의 형식이 올바르지 않아 목표 입력에 실패한다.<br>
        6a1. 시스템은 에러 메시지를 목표 관리 페이지에 출력한다.<br>
        6a2. 사용자가 확인 버튼을 누르면 시스템은 다시 입력 화면을 표시한다. (Use case #4)</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초 이내 저장</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 새로운 목표를 설정하고 싶을 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 목표를 등록할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #5: 목표 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 자신이 등록한 목표 목록과 각 목표의 진행률, 달성 상태 등을 조회한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.05.03</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 하며 등록된 목표가 존재하여야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 목표 관리 페이지(/goals) 또는 대시보드(/dashboard)에 접속한다.</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 등록된 목표 정보와 진행 현황을 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>목표 정보가 조회되지 않으며, 시스템은 오류 메시지를 표시한다.</td>
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
    <td>사용자가 목표 관리 페이지(/goals) 또는 대시보드(/dashboard)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 현재 로그인된 사용자의 정보를 확인하고 데이터베이스에서 사용자가 등록한 목표 정보를 조회한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 각 목표의 제목, 카테고리, 달성일, 진행률 등을 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 등록된 목표 목록과 목표별 진행 현황을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>2</td>
    <td>2a. 등록된 목표 정보가 없을 경우 목표 조회가 어렵다.<br>
        2a1. 시스템은 화면에 등록된 목표가 없다는 문구를 표시하고 목표 등록 버튼을 표시한다. (Use case #4)</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 진행률이 0인 경우 진행률을 0으로 표시한다.<br>
        3a1. 진행바를 비워두고 0%로 표시한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 로그인을 한 직후나 목표 현황을 확인할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 목표 정보를 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #6: 목표 수정</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 기존에 등록한 목표의 정보를 수정한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 하며, 목표가 1개 이상 등록되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자 목표 관리 페이지에서 수정할 목표를 선택하고 목표 수정을 시도할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>수정된 목표 정보가 데이터베이스에 저장되고, 변경된 내용이 목표 관리 페이지에 반영된다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>목표 정보가 수정되지 않으며, 기존 목표 정보가 유지된다.</td>
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
    <td>사용자가 로그인 후 목표 관리 페이지(/goals)에 접속하여 수정할 목표를 선택한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 선택한 목표를 수정할 수 있는 폼을 표시한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>사용자는 목표 제목, 카테고리, 목표 달성일, 설명, 루틴 항목 등을 수정한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 수정 완료 버튼을 클릭한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>시스템은 수정된 목표 정보를 데이터베이스에 저장한다.</td>
  </tr>
  <tr>
    <td>6</td>
    <td>시스템은 변경된 정보를 목표 관리 페이지에 반영하고 해당 페이지로 이동한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 사용자가 다른 페이지로 이동하거나 취소를 누를 경우 입력한 목표는 수정되지 않는다.<br>
        3a1. 사용자에게 모달창으로 "입력된 목표 정보를 수정하지 않으시겠습니까?"라는 메시지를 표시한다.<br>
        3a2. 사용자가 확인 버튼을 누르면 목표 관리 페이지로 돌아간다. (Use case #5)</td>
  </tr>
  <tr>
    <td>4</td>
    <td>4a. 사용자가 입력한 목표 정보의 형식이 올바르지 않아 목표 입력에 실패한다.<br>
        4a1. 시스템은 에러 메시지를 목표 관리 페이지에 출력한다.<br>
        4a2. 사용자가 확인 버튼을 누르면 시스템은 다시 입력 화면을 표시한다. (Use case #6)</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 기존 목표의 내용을 변경하고 싶을 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 목표 정보를 수정할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #7: 일일 기록 등록</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 하루 동안 실천한 내용과 감정을 기록한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 데일리 로그 페이지(/record)에서 기록 완료 버튼을 누를 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자가 입력한 일일 기록이 데이터베이스에 저장되고 별 보상 획득으로 연결된다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>일일 기록이 저장되지 않으며, 별 보상도 지급되지 않는다.</td>
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
    <td>사용자가 로그인 후 데일리 로그 페이지(/record)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 오늘의 기록 입력 화면과 루틴 체크 영역을 표시한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>사용자는 오늘의 이야기, 감정(Mood), 수행한 루틴 항목을 입력한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 기록 완료 버튼을 클릭한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>시스템은 입력된 일일 기록 정보를 확인한다.</td>
  </tr>
  <tr>
    <td>6</td>
    <td>시스템은 일일 기록을 데이터베이스에 저장하고 사용자의 별 개수를 1 증가시킨다. (Use case #9)</td>
  </tr>
  <tr>
    <td>7</td>
    <td>시스템은 대시보드 화면으로 이동하며 별 보상 획득 메시지를 표시한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 사용자가 필수 기록 내용을 입력하지 않은 경우 기록 등록에 실패한다.<br>
        3a1. alert 알림창으로 "오늘의 기록을 입력해주세요."라는 메시지를 출력한다.<br>
        3a2. 사용자가 확인 버튼을 누르면 다시 데일리 로그 입력 화면으로 돌아간다. (Use case #7)</td>
  </tr>
  <tr>
    <td>5</td>
    <td>5a. 이미 해당 날짜의 기록이 존재하는 경우 기록 등록에 실패한다.<br>
        5a1. 시스템은 "오늘 기록은 이미 저장되었습니다."라는 에러 메시지를 데일리 로그 페이지에 표시한다.<br>
        5a2. 사용자는 다시 데일리 로그 페이지에 머무른다. (Use case #7)</td>
  </tr>
  <tr>
    <td>6</td>
    <td>6a. 서버 또는 데이터베이스 오류가 발생한 경우 기록 저장에 실패한다.<br>
        6a1. 시스템은 기록 저장 실패 메시지를 표시한다.<br>
        6a2. 사용자가 확인 버튼을 누르면 입력 화면으로 돌아간다. (Use case #7)</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 하루의 실천 내용을 기록할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 일일 기록을 등록할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #8: 일일 기록 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 자신이 작성한 일일 기록을 캘린더에서 날짜를 선택하여 조회한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 하며, 조회할 일일 기록이 존재하여야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 캘린더(/map)에서 기록이 존재하는 날짜를 선택할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 작성한 일일 기록의 내용, 감정, 루틴 수행 여부를 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>일일 기록이 조회되지 않으며, 시스템은 오류 메시지를 출력한다.</td>
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
    <td>사용자가 로그인 후 캘린더 페이지(/map)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>사용자는 조회할 날짜를 캘린더에서 선택한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 해당 날짜의 일일 기록(날짜, 감정, 기록 내용)을 팝업으로 표시한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자는 자신이 작성한 일일 기록을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 선택한 날짜에 작성된 기록이 없는 경우 기록 조회가 어렵다.<br>
        3a1. 시스템은 해당 날짜에 기록이 없음을 표시한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3b. 서버 또는 데이터베이스 오류가 발생한 경우 기록 조회에 실패한다.<br>
        3b1. 시스템은 일일 기록 조회 실패 메시지를 출력한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 이전 기록을 확인하고 싶을 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 일일 기록을 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #9: 별 보상 획득</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 일일 기록을 완료하면 시스템이 자동으로 별 보상을 지급한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 하며, 일일 기록 등록을 완료하여야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 일일 기록을 저장하는 경우</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자의 별 개수(starCount)가 1 증가하고, 연속 기록 일수(currentStreak)도 1 증가한다. 대시보드에서 별 보상 획득 메시지가 표시된다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>별 보상이 지급되지 않으며, 사용자의 별 개수와 별자리 진행률이 변경되지 않는다.</td>
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
    <td>사용자가 데일리 로그 페이지(/record)에서 일일 기록을 작성한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>사용자는 기록 완료 버튼을 클릭한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 일일 기록이 정상적으로 저장되었는지 확인한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 사용자의 starCount를 1 증가시키고 currentStreak를 1 증가시킨다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>시스템은 대시보드로 이동 후 별 보상 획득 메시지를 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>6</td>
    <td>사용자는 대시보드에서 자신이 획득한 별 보상을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 일일 기록이 저장되지 않은 경우 별 보상 지급에 실패한다.<br>
        3a1. 시스템은 기록 저장 실패 메시지를 출력한다.<br>
        3a2. 사용자가 확인 버튼을 누르면 데일리 로그 입력 화면으로 돌아간다. (Use case #7)</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 일일 기록을 완료할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 별 보상을 획득할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #10: 나의 별자리 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 자신의 생년월일 기반 별자리와 수집한 별의 진행률을 대시보드에서 확인한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 대시보드(/dashboard) 또는 목표 관리, 캘린더, 프로필 페이지에 접속할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 자신의 별자리 이름과 별 수집 진행률(현재 채워진 별 수 / 전체 별 수)을 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>별자리 정보가 조회되지 않으며, 시스템은 오류 메시지를 표시한다.</td>
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
    <td>사용자가 로그인 후 대시보드(/dashboard)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 현재 로그인된 사용자의 생년월일과 starCount를 조회한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 생년월일을 기반으로 사용자의 별자리(황도 12궁)를 결정하고 별 수집 진행률을 계산한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 별자리 이름, 별 포인트 배치, 채워진 별 수, 진행률(%)을 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>사용자는 자신의 별자리와 별 수집 현황을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 사용자가 획득한 별이 없는 경우 진행률이 0%로 표시된다.<br>
        3a1. 시스템은 별자리 포인트를 비어있는 상태로 표시한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3b. 생년월일이 없는 경우 별 개수를 기반으로 별자리를 순환하여 결정한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 대시보드 또는 각 페이지에 접속할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 별자리 정보를 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #11: 캘린더 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 날짜별 일일 기록 작성 여부를 캘린더에서 조회한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 캘린더 페이지(/map)에 접속할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 날짜별 기록 여부와 해당 월의 총 기록 수를 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>캘린더 정보가 조회되지 않으며, 시스템은 오류 메시지를 표시한다.</td>
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
    <td>사용자가 로그인 후 캘린더 페이지(/map)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 현재 로그인된 사용자의 정보를 확인한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 데이터베이스에서 해당 월의 일일 기록 정보를 조회한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 날짜별 기록 여부와 해당 월의 총 기록 수를 캘린더에 표시한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>사용자는 캘린더에서 날짜별 기록 현황을 확인하고 이전/다음 달로 이동할 수 있다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 조회할 기록이 없는 경우 캘린더 조회 결과가 비어있다.<br>
        3a1. 시스템은 기본 캘린더 화면을 표시하고 기록이 없음을 안내한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3b. 서버 또는 데이터베이스 오류가 발생한 경우 캘린더 조회에 실패한다.<br>
        3b1. 시스템은 캘린더 조회 실패 메시지를 출력한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 기록 현황을 날짜별로 확인하고 싶을 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 캘린더 정보를 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #12: 진행률 확인</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 목표별 진행률과 전체 목표 달성 현황을 확인한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.05.03</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 하며, 등록된 목표가 존재하여야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 대시보드(/dashboard) 또는 목표 관리 페이지(/goals)에 접속할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자는 목표별 진행률과 전체 성취도를 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>진행률 정보가 조회되지 않으며, 시스템은 오류 메시지를 표시한다.</td>
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
    <td>사용자가 로그인 후 대시보드(/dashboard) 또는 목표 관리 페이지(/goals)에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>시스템은 현재 로그인된 사용자의 모든 목표 정보를 조회한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 각 목표의 루틴 체크 이력과 목표 기간을 기준으로 진행률을 재계산한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 목표별 진행률(%)을 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>사용자는 자신의 목표 진행률과 달성 현황을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>2</td>
    <td>2a. 등록된 목표가 없는 경우 진행률 확인이 어렵다.<br>
        2a1. 시스템은 등록된 목표가 없다는 문구를 표시한다.<br>
        2a2. 시스템은 목표 등록 버튼을 표시한다. (Use case #4)</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 목표에 연결된 루틴 체크 기록이 없는 경우 진행률을 0%로 계산한다.<br>
        3a1. 시스템은 해당 목표의 진행바를 비워두고 0%로 표시한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 대시보드 또는 목표 관리 페이지에 접속할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 자신의 진행률을 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #13: 로그아웃</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>사용자가 현재 로그인된 Starlog 계정에서 접속을 종료한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>User Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>User</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>사용자는 Starlog에 로그인되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>사용자가 로그아웃 버튼을 누를 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>사용자의 로그인 세션이 해제되고 랜딩(홈) 화면으로 이동한다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>로그아웃이 처리되지 않으며, 사용자의 로그인 상태가 유지된다.</td>
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
    <td>사용자가 로그인 후 프로필 페이지(/profile) 또는 상단 네비게이션에 접속한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>사용자는 로그아웃 버튼을 클릭한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 로그아웃 확인 모달창을 표시한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>사용자가 확인 버튼을 누르면 시스템은 사용자의 로그인 세션을 종료한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>시스템은 사용자를 랜딩(홈) 화면(/)으로 이동시킨다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 사용자가 취소 버튼을 누른 경우 로그아웃이 취소된다.<br>
        3a1. 시스템은 로그아웃을 중단하고 기존 화면을 그대로 표시한다. (Use case #3)</td>
  </tr>
  <tr>
    <td>4</td>
    <td>4a. 서버 오류로 로그아웃 처리에 실패한다.<br>
        4a1. 시스템은 로그아웃 실패 메시지를 출력한다.<br>
        4a2. 사용자가 확인 버튼을 누르면 기존 화면으로 돌아간다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>사용자가 서비스 이용을 종료하고 싶을 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 사용자가 동시에 로그아웃을 요청할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #14: 회원 목록 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>관리자가 Starlog에 가입된 회원 목록을 조회한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>Admin Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.05.03</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>Admin</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>관리자는 Starlog 관리자 계정으로 로그인되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>관리자가 관리자 대시보드(/admin)에 접속할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>관리자는 가입된 회원 목록과 기본 정보를 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>회원 목록이 조회되지 않으며, 시스템은 오류 메시지를 표시한다.</td>
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
    <td>관리자가 관리자 계정으로 로그인한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>관리자가 관리자 대시보드(/admin)에 접속한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 데이터베이스에서 회원 목록 정보를 조회한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 전체 회원 수, 전체 기록 수, 회원 목록을 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>관리자는 Starlog에 가입된 회원 목록을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>1</td>
    <td>1a. 관리자 권한이 없는 사용자가 관리자 대시보드에 접근하는 경우 접근에 실패한다.<br>
        1a1. 시스템은 사용자를 일반 대시보드 화면으로 이동시킨다. (Use case #12)</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 서버 또는 데이터베이스 오류가 발생한 경우 회원 목록 조회에 실패한다.<br>
        3a1. 시스템은 회원 목록 조회 실패 메시지를 출력한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>관리자가 서비스 회원 현황을 확인할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 관리자가 동시에 회원 목록을 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

<table>
  <tr>
    <td colspan="2"><b>Use Case #15: 피드백 조회</b></td>
  </tr>
  <tr>
    <td colspan="2"><b>GENERAL CHARACTERISTICS</b></td>
  </tr>
  <tr>
    <td>Summary</td>
    <td>관리자가 사용자가 남긴 피드백(UserFeedback)을 조회한다.</td>
  </tr>
  <tr>
    <td>Scope</td>
    <td>Starlog</td>
  </tr>
  <tr>
    <td>Level</td>
    <td>Admin Level</td>
  </tr>
  <tr>
    <td>Author</td>
    <td>김가영</td>
  </tr>
  <tr>
    <td>Last Update</td>
    <td>2026.06.05</td>
  </tr>
  <tr>
    <td>Status</td>
    <td>Implemented</td>
  </tr>
  <tr>
    <td>Primary Actor</td>
    <td>Admin</td>
  </tr>
  <tr>
    <td>Preconditions</td>
    <td>관리자는 Starlog 관리자 계정으로 로그인되어 있어야 한다.</td>
  </tr>
  <tr>
    <td>Trigger</td>
    <td>관리자가 관리자 대시보드(/admin)에 접속할 때</td>
  </tr>
  <tr>
    <td>Success Post Condition</td>
    <td>관리자는 사용자 피드백 목록과 내용을 확인할 수 있다.</td>
  </tr>
  <tr>
    <td>Failed Post Condition</td>
    <td>피드백이 조회되지 않으며, 시스템은 오류 메시지를 표시한다.</td>
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
    <td>관리자가 관리자 계정으로 로그인한다.</td>
  </tr>
  <tr>
    <td>2</td>
    <td>관리자가 관리자 대시보드(/admin)에 접속한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>시스템은 데이터베이스에서 사용자 피드백 목록을 작성 시각 내림차순으로 조회한다.</td>
  </tr>
  <tr>
    <td>4</td>
    <td>시스템은 피드백 작성자명, 카테고리, 내용, 작성 시각을 화면에 표시한다.</td>
  </tr>
  <tr>
    <td>5</td>
    <td>관리자는 사용자 피드백 목록을 확인한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>EXTENSION SCENARIOS</b></td>
  </tr>
  <tr>
    <td><b>Step</b></td>
    <td><b>Branching Action</b></td>
  </tr>
  <tr>
    <td>3</td>
    <td>3a. 등록된 피드백이 없는 경우 피드백 조회 결과가 비어있다.<br>
        3a1. 시스템은 피드백 목록 영역에 빈 상태를 표시한다.</td>
  </tr>
  <tr>
    <td>3</td>
    <td>3b. 서버 또는 데이터베이스 오류가 발생한 경우 피드백 조회에 실패한다.<br>
        3b1. 시스템은 피드백 조회 실패 메시지를 출력한다.</td>
  </tr>
  <tr>
    <td colspan="2"><b>RELATED INFORMATION</b></td>
  </tr>
  <tr>
    <td>Performance</td>
    <td>&lt;= 3초</td>
  </tr>
  <tr>
    <td>Frequency</td>
    <td>관리자가 사용자 피드백을 확인할 때마다</td>
  </tr>
  <tr>
    <td>Concurrency</td>
    <td>여러 관리자가 동시에 피드백을 조회할 수 있다.</td>
  </tr>
  <tr>
    <td>Due Date</td>
    <td>N/A</td>
  </tr>
</table>

## 3. Domain Analysis

- Find all of classes in your project.
- Describe the meaning of each class.
- 12pt, 160%.

| 이름         | 설명                                                                                                                                                                                                                        |
| ------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| StarlogUser  | 사용자 클래스. Starlog 서비스를 이용하는 회원 정보를 가진다. 이메일, 닉네임, 아이디(username), 비밀번호 해시, 생년월일, 누적 별 개수(`starCount`), 연속 기록 일수(`currentStreak`), 레벨명, 권한(`UserRole`) 등을 포함한다. |
| Goal         | 목표 클래스. 사용자가 달성하고자 하는 목표 정보를 가진다. 목표 제목, 카테고리, 달성 기한, 상세 설명, 상태(`GoalStatus`), 진행률(`progressPercent`) 등을 포함하며, 하나의 사용자는 여러 개의 목표를 가질 수 있다.            |
| DailyRecord  | 일일 기록 클래스. 사용자가 하루 동안 실천한 내용을 기록한다. 기록 날짜, 기록 내용, 기분(`Mood`), 지급된 별 개수(`starAmount`)를 가진다. 날짜당 한 개만 등록 가능하다.                                                       |
| Routine      | 루틴 클래스. 특정 목표에 연결된 반복 실천 항목을 나타낸다. 루틴 제목, 반복 빈도(`frequency`), 활성화 여부(`active`), 표시 순서 등을 포함하며, 하나의 목표는 여러 루틴을 가질 수 있다.                                       |
| RoutineCheck | 루틴 체크 클래스. 일일 기록 작성 시 각 루틴의 수행 여부를 기록한다. 특정 루틴과 일일 기록에 연결되며, 체크 여부(`checked`)를 저장한다. 이 체크 이력이 목표 진행률 계산에 사용된다.                                          |
| RecordTag    | 기록 태그 클래스. 일일 기록에 붙이는 태그 정보를 가진다. 태그 이름과 연결된 기록 정보를 포함하며, 하나의 기록은 여러 태그를 가질 수 있다.                                                                                   |
| UserFeedback | 사용자 피드백 클래스. 사용자가 시스템에 남기는 피드백 정보를 가진다. 작성자명, 피드백 내용, 카테고리, 작성 시각 등을 포함하며, 관리자 페이지(/admin)에서 조회할 수 있다.                                                    |

---

## 4. User Interface Prototype

Develop user interfaces of your system.

- It will be easy if you just think that you make a preliminary user manual of your system based on your user interface.
- 12pt, 160%.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/1.랜딩페이지.png)

### 랜딩 페이지

랜딩 페이지는 사용자가 Starlog 서비스를 처음 접하는 화면이다. Starlog의 핵심 컨셉인 "꿈을 별자리로 만드는 여정"라는 문구를 추가하여 사용자가 서비스의 목적을 직관적으로 이해할 수 있도록 구성하였다. 예시 목표 카드와 진행률을 보여주어 사용자가 목표를 기록하고 성정 과정을 확인하는 서비스임을 시각적으로 전달한다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/2.회원가입.png)

### 회원가입 페이지

회원가입 페이지는 사용자가 Starlog 서비스를 이용하기 위해 계정을 생성하는 화면이다. 사용자는 이메일, 아이디, 닉네임, 비밀번호, 생년월일을 입력하여 회원가입을 진행 할 수 있다.

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

캘린더 페이지는 사용자의 기록 현황을 날짜별로 확인할 수 있는 화면이다. 사용자는 월별 캘린더를 통해 어느 날 기록을 작성했는지 확인할 수 있다. 각 날짜에는 기록 여부가 표시되며, 기록이 있는 날짜를 클릭하면 해당 일의 기록 내용과 감정을 팝업으로 확인할 수 있다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/8.마이페이지.png)

### 마이페이지

마이페이지는 사용자의 개인 정보와 활동 현황을 확인하는 화면이다. 사용자는 자신의 닉네임, 아이디, 이메일, 생년월일 등을 확인할 수 있으며, 지금까지 수집한 별의 개수와 총 기록 수를 볼 수 있다. 하단에는 최근 기록 목록이 표시된다.

![Starlog](https://github.com/kayeong97/picture_repo/blob/main/software_design/analysis/9.관리자대시보드.png)

### 관리자 대시보드 페이지

관리자 대시보드 페이지는 관리자가 서비스 운영 상태를 확인하고 사용자 정보를 관리하는 화면이다. 사용자 피드백, 전체 회원 수, 전체 기록 수가 표시되어 서비스 이용 현황을 확인할 수 있다. 또한 사용자 관리 목록을 통해 가입 회원 정보를 확인할 수 있다.

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
