<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String uid_session = (String)session.getAttribute("uid_session"); //uid 세션 부여
	String nickname_session = (String)session.getAttribute("nickname_session");	//닉네임 세션 부여
	int auth_session = 0;
	
	if(uid_session!=null){
		auth_session = (int)session.getAttribute("auth_session");	
	}
%>   
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>메인 페이지(git수정 테스트중 노트북)</title>
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
		<%if(uid_session == "" || uid_session == null){ %>
		<div id="LoginFormArea">
			<form action="LoginProc">
				<input type="text" placeholder="ID" name="uid" id="uid" required>
				<input type="password" placeholder="PW" name="upw" id="upw" required>
				
				<button class="Login_Btn">로그인</button>
			</form>
		<%} else {%>
				<div id="loginStateMenu" class="dFlex">
					<span class="notosanskr"><%=nickname_session %>님 환영합니다</span>
					<button id="Logout_Btn" class="Logout_Btn">로그아웃</button>
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
		<%} %>
		</div>
<!-- 		div#LoginFormArea -->
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    