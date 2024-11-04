<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String userID_session = (String)session.getAttribute("userID_session"); //uid 세션 부여
	String userPW_session = (String)session.getAttribute("userPW_session");	//닉네임 세션 부여
	
	int userAuth_session = 0;
	String AuthName = "";
	
	if(userID_session != null){
		userAuth_session = (int)session.getAttribute("userAuth_session");	
		
		
		if (userAuth_session == 1) AuthName = "부 관리자";
		if (userAuth_session == 2) AuthName = "총 관리자";
	}
%>   
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>메인 페이지</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap">
		<h1>I.M.S</h1>
		<h1>Inventory</h1>
		<h1>Management</h1>
		<h1>System Service</h1>
		<br>
		<br>
		<br>
		<%if (userID_session == "" || userID_session == null) { %>
		<div id="LoginFormArea">
			<form action="LoginProc">
				<input type="text" placeholder="ID" name="LoginID" id="LoginID" required>
				<input type="password" placeholder="PW" name="LoginPW" id="LoginPW" required>
				
				<button class="Login_Btn">로그인</button>
				<button class="Join_Btn">회원가입</button>
			</form>
		<% } else { %>
				<div id="loginStateMenu" class="dFlex">
					<% if (userAuth_session > 0) { %>
					<span class="notosanskr"><b><%=AuthName %></b> 님 환영합니다</span>
					<% } else { %>
					<span class="notosanskr"><b><%=userID_session %></b> 님 환영합니다</span>
					<% } %>
					<button id="Logout_Btn" class="Logout_Btn">로그아웃</button>
					
					<div id="ShopListArea">
					<% if (userAuth_session > 0) { %>
						<select id="ShopList">
							<option value="">관리자용 관리매장 선택</option>
							<option value="관리자용 1번">관리자용 1번</option>
							<option value="관리자용 2번">관리자용 2번</option>
						</select>
					<% } else { %>
						<select id="ShopList">
							<option value="">관리매장 선택</option>
							<option value="1번">1번</option>
							<option value="2번">2번</option>
						</select>
					<% }  %>
					</div>
				</div>
				<br>
				
				<main id="main" class="MainWrap dFlex">
				
					<div id="InventoryArea" class="MainListArea">
						<div id="InventoryTitle" class="MainNavTitle dFlex">
							<span class="ListTitleName">재고 목록 리스트</span>							
							<span id="Inventory" class="ListTitleMenu">..더보기</span>
						</div>
						<!-- div#InventoryTitle -->
						
						<div id="InventoryList">
							<table id="List">
								<tr class="TableList">
									<th>상품명</th>
									<th>재고</th>
									<th>가격</th>
								</tr>
								<tr class="TableList">
									<td>아몬드</td>
									<td>3</td>
									<td>1000</td>
								</tr>
							</table>
						</div>
						<!-- div#InventoryList -->
						
					</div>
					<!-- div#InventoryArea -->
					
					<div id="SellStatusArea" class="MainListArea">
					
						<div id="SellStatusTitle" class="MainNavTitle dFlex">
							<span class="ListTitleName">판매 정산 리스트</span>                                         
							<span id="SellStatus" class="ListTitleMenu">..더보기</span>
						</div>
						<!-- div#SellStatusTitle -->
						
						<div id="SellStatusList">
							<table id="List">
								<tr class="TableList">
									<th>상품명</th>
									<th>판매갯수</th>
									<th>판매가격</th>
									<th>수익금</th>
								</tr>
								<tr class="TableList">
									<td>아몬드</td>
									<td>3</td>
									<td>1000</td>
									<td>3000</td>
								</tr>
							</table>
						</div>
						<!-- div#SellStatusList -->
						
					</div>
					<!-- div#SellStatusArea -->
					
					<div id="3번째Area" class="MainListArea">
					
						<div id="3번째Title" class="MainNavTitle dFlex">
							<span class="ListTitleName">3번 리스트</span>                                         
							<span id="3번째Title" class="ListTitleMenu">..더보기</span>
						</div>
						<!-- div#3번째Title -->
						
						<div id="3번째List">
							<table id="List">
								<tr class="TableList">
									<th>미정</th>
									<th>미정</th>
									<th>미정</th>
								</tr>
								<tr class="TableList">
									<td>미정</td>
									<td>0</td>
									<td>0</td>
								</tr>
							</table>
						</div>
						<!-- div#3번째List -->
						
					</div>
					<!-- div#3번째Area -->
					
					
					<div id="4번째Area" class="MainListArea">
					
						<div id="4번째Title" class="MainNavTitle dFlex">
							<span class="ListTitleName">4번 리스트</span>                                         
							<span id="4번째" class="ListTitleMenu">..더보기</span>
						</div>
						<!-- div#4번째Title -->
						
						<div id="4번째List">
							<table id="List">
								<tr class="TableList">
									<th>미정</th>
									<th>미정</th>
									<th>미정</th>
								</tr>
								<tr class="TableList">
									<td>미정</td>
									<td>0</td>
									<td>0</td>
								</tr>
							</table>
						</div>
						<!-- div#4번째List -->
						
					</div>
					<!-- div#4번째Area -->
					
					
				</main>
		<% } %>
		</div>
<!-- 		div#LoginFormArea -->
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    