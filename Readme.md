# DB 설계도

- <img src="https://github.com/user-attachments/assets/fb1227e0-5f55-46a0-ae08-6b1b0dc6c451" width="800" height="400" title="DB 설계도" />

---

# 2024.11.07

- 페이지 총 관리자 권한 확인 후 로그인시 회원관리 탭 추가
  - <img src="https://github.com/user-attachments/assets/72597918-2c30-436f-ba3a-255a433a0c36" width="100%" title="20241107_1 일반회원 로그인" />
  - <img src="https://github.com/user-attachments/assets/214f0e73-619b-473c-b003-f9bcf5bc92f0" width="100%" title="20241107_2 관리자 로그인" />
- 회원관리페이지에 모든 멤버 리스트 출력 추가
  - <img src="https://github.com/user-attachments/assets/c5053c9e-f816-4c52-ba60-310f360e7a96" width="100%" title="20241107_3 관리자용 멤버 리스트" />
- 회원관리페이지에서 멤버 호버 이벤트 및 클릭시 해당 유저의 권한을 줄 수 있는 팝업페이지 연결
  - <img src="https://github.com/user-attachments/assets/1bb91926-37e1-4c44-a20d-4e9f8f127e1b" width="100%" title="20241107_4 관리자용 멤버 리스트호버" />

---

# 2024.11.11

- 관리자 관리매장 리스트전체목록 확인
  - <img src="https://github.com/user-attachments/assets/5b4fee8f-ff3d-4cdf-bcfa-7fffe79713cc" width="100%" title="20241111_2 관리자용 매장 리스트출력" />
- 관리매장 등록된 회원 리스트 목록 확인
  - <img src="https://github.com/user-attachments/assets/f4085645-3615-4161-ab83-e017ae31b4e0" width="100%" title="20241111_2 멤버용 매장 리스트출력1" />
  - <img src="https://github.com/user-attachments/assets/2e593d72-0138-4c86-8f12-e935838720d7" width="100%" title="20241111_2 멤버용 매장 리스트출력2" />

---

# 2024.11.14

- ajax 를 통하여 비동기식 으로 지정받은 관리매장에 관한 물품(재고)리스트 추가
  - <img src="https://github.com/user-attachments/assets/40457ced-7099-4175-ae78-3114bc16d7e6" width="100%" title="20241114_1 관리자 매장1 재고리스트" />
  - <img src="https://github.com/user-attachments/assets/084ffb68-b975-4de1-aed5-87c057a27b06" width="100%" title="20241114_1 관리자 매장2 재고리스트" />

---

# 2024.11.15

- 관리자 메뉴 회원관리 에서 메인으로 돌아갈수있는 "돌아가기" 버튼 추가
  - <img src="https://github.com/user-attachments/assets/6f31f595-00a7-498f-b932-1d0ebc300958" width="100%" title="20241115_1 관리자 멤버관리 돌아가기" />
- 관리자 메뉴 회원관리 에서 멤버클릭시 관리매장추가리스트 출력 및 멤버의 매장을 추가
  - <img src="https://github.com/user-attachments/assets/1386ea2f-e386-49e7-b294-c886f06d579e" width="100%" title="20241115_2 관리자 멤버관리 멤버매장추가변경" />

---

# 2024.11.17

- 관리매장 선택 후 "재고 목록 리스트" 우측 "..더보기" 선택시 해당매장 전체 재고목록 리스트를 출력해주는 페이지로 이동 후 전체리스트 출력
  - <img src="https://github.com/user-attachments/assets/9128f3e6-8249-4b4e-a296-824fee8f486a" width="100%" title="20241117_1 재고리스트 더보기 클릭시" />
  - <img src="https://github.com/user-attachments/assets/8fef7677-d76a-41b5-b7d6-6c2cb6696bbb" width="100%" title="20241117_1 재고리스트 더보기 클릭시2" />
- 회원가입 페이지 의 약관 체크 및 동의 후 회원가입 페이지 이동 및 가입절차 및 가입등록
  - <img src="https://github.com/user-attachments/assets/136b98a5-143e-48fc-a9d9-c7367ef01cb2" width="100%" title="20241117_2 회원가입 관련" />

---

# 2024.11.20

- 매장별 재고관리 페이지 "재고변경", "재고판매" 버튼 추가
  - <img src="https://github.com/user-attachments/assets/5c89402c-c736-40c6-b81c-f636ad9d26b0" width="100%" title="20241120_1 재고관리페이지 버튼추가" />
- "재고변경"-재고선택시 선택한 상품에 따라 비동기식 으로 재고수량 불러오기
- "재고변경" 수량 정상 입력시 추가,삭제 에 따른 계산 및 데이터 처리 후 alert로 처리결과 보여 준 후 자식창 close 및 부모창 새로고침
  - <img src="https://github.com/user-attachments/assets/5b47f6cf-bfd8-48d2-a906-da57549f38b4" width="100%" title="20241120_2,3 재고관리페이지 버튼추가" />
- "재고판매" 는 현재 미작업

---

# 2024.11.22

- "Controller" 코드 간소화
- "dao", "svc" 파일 작동메서드 명시 및 "dto" 내부 설명 명시
  - <img src="https://github.com/user-attachments/assets/8b2db4c7-2c72-454f-b89b-6cf2a8bbe534" width="100%" title="20241122_2 dao,svc파일 작동메서드명시" />

---

# 2024.11.24

- 재고판매버튼 활성화 및 재고변경과 같은로직으로 처리
  - <img src="https://github.com/user-attachments/assets/633c7c4c-2940-4d1c-975c-94ff7440b0a9" width="100%" title="20241124_1 재고판매버튼시" />
- "ShopSellStatus"(재고판매) 가되면 판매정산 리스트에 추가
- 판매정산 리스트 를 index 메인페이지에 최근 5개항목을 추가
  - <img src="https://github.com/user-attachments/assets/08198907-1094-44b0-9037-b48e724f31b2" width="100%" title="20241124_2,3 index페이지 정산리스트추가" />
- 각 상세페이지 가격표기 "###,### 원" 패턴을 추가
- 판매정산리스트 "더보기" 시 위부터 최근순으로 전체적인 판매리스트를 확인하고 총판매금액을 우측상단에 표기
  - <img src="https://github.com/user-attachments/assets/850b8321-2f07-4236-9835-8e16f1cb722c" width="100%" title="20241124_5 판매정산리스트 더보기 시" />

---

# 2024.11.25

- 메인 페이지 리뉴얼 메인 좌측에 메뉴리스트 나열
  - <img src="https://github.com/user-attachments/assets/c0ce5bd2-c3f5-4b9d-abc8-e1560d703fa5" width="100%" title="20241125_1 메인좌측 네비게이션 추가" />
- 재고관리메뉴 -> 추가/삭제 버튼 제거 리스트중 변경할 상품을 클릭하면 해당상품에관한 수량 추가/삭제/판매 까지 가능하게 변경

---

# 2024.11.26

- 상품관리 페이지 내 상품추가 버튼및 해당하는 작업완료
  - <img src="https://github.com/user-attachments/assets/728a2f47-ac61-4a1d-aa54-33eafa4b97bf" width="100%" title="20241126_1 상품재고변경및판매 변경" />
- 홈페이지의 전체 관리자라면 매장선택 옆 "매장추가" 버튼만 추가 웹페이지에 랜덤6개 코드 부여까지. 매장추가는 이후작업에다시
  - <img src="https://github.com/user-attachments/assets/d008ee7e-4fc1-4cfc-b679-7e268afceb1a" width="100%" title="20241126_2 매장추가관련" />
- 매장추가에 매장명 입력하면 해당하는 Mapper,Dao,svc 등 해당하는 작업 완료

---

## [작업 예정]

- 매장추가에 매장명 입력하면 해당하는 매퍼 및 dao,svc 작업 필요

---

# 사용기술

- HTML5, CSS
- JavaScript, JQuery, ajax
- Spring, MyBatis

---

# 개발환경

- Window OS
- Spring Tool Suite 4
- Tomcat 8.5
- MySql WorkBeanch 8.0
