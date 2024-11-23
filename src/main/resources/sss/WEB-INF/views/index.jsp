<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String userID_session = (String)session.getAttribute("userID_session"); //uid 세션 부여
	String userPW_session = (String)session.getAttribute("userPW_session");	//닉네임 세션 부여

    Object userAuth_session_obj = session.getAttribute("userAuth_session");
    Object shop_Code_session_obj = session.getAttribute("Shop_Code_session");
	Object Shop_Name_Session_obj = session.getAttribute("Shop_Name_Session");

// 	out.print("userAuth_session : " + userAuth_session_str + "<br/>");
// 	out.print("Shop_Code_session : " + Shop_Code_session_str);
	
	int userAuth_session = 0;
	int Shop_Code_session = 0;
	String AuthName = "";
	Object Shop_Name_Session = "";
	
	if(userID_session == "" || userID_session != null) {
		
		if (userAuth_session_obj != null && !userAuth_session_obj.toString().isEmpty()) {
		    try {
		    	userAuth_session = Integer.valueOf(userAuth_session_obj.toString());
		    } catch (NumberFormatException e) {
		        Shop_Code_session = 0; 
		    }
		}
		
    	if (shop_Code_session_obj != null && !shop_Code_session_obj.toString().isEmpty()) {
		    try {
		    	Shop_Code_session = Integer.valueOf(shop_Code_session_obj.toString());
		    } catch (NumberFormatException e) {
		    	shop_Code_session_obj = 0; 
		    }
		}
// 		if (userAuth_session_obj!= null || userAuth_session_obj != "") userAuth_session = Integer.valueOf(userAuth_session_obj.toString());
// 		if (shop_Code_session_obj != null || shop_Code_session_obj != "") Shop_Code_session = Integer.valueOf(shop_Code_session_obj.toString());

		if (userAuth_session == 1) AuthName = "부 관리자";
		if (userAuth_session == 2) AuthName = "총 관리자";
		if (userAuth_session == 0) AuthName = userID_session;
		
		if (Shop_Code_session > 0) {
			Shop_Name_Session = Shop_Name_Session_obj;
		}
	} else {
		userAuth_session = 0;
		Shop_Code_session = 0;
		AuthName = "";
		Shop_Name_Session = "";
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
			<!-- form#LoginProc -->
			
		<% } else { %>
				<div id="loginStateMenu" class="dFlex">
					<% if (userAuth_session > 0) { %>
					<span class="notosanskr"><b><%=AuthName %></b> 님 환영합니다</span>
					<% } else { %>
					<span class="notosanskr"><b><%=userID_session %></b> 님 환영합니다</span>
					<% } %>
					<button id="Logout_Btn" class="Logout_Btn">로그아웃</button>
					<% if (userAuth_session == 2) { %>
					<button id="Member_Edit" class="Member_Edit">회원관리</button>
					<% } %>
					
					<div id="ShopListArea">
					<% if (userAuth_session != 0 && userAuth_session > 0) { %>
						<select id="ShopList">
							<option value="">관리자용 관리매장 선택</option>
							<c:forEach var="shopList" items="${shopList}" varStatus="status">
							<option value="${shopList.shop_Code}">${shopList.shop_Name}</option>
							</c:forEach>
						</select>
					<% } else { %>
						<% if (Shop_Code_session != 0 || Shop_Code_session > 0) { %>
						<select id="ShopList">
							<option value="">관리매장 선택</option>
							<option value="<%= Shop_Code_session %>"><%= Shop_Name_Session %></option>
						</select>
						<% } else { %>
						<select id="ShopList">
							<option value="">관리매장 없음</option>
						</select>
						<% } %>
					<% } %>	
					</div>
					<!-- div#ShopListArea -->
				</div>
				<!-- div#loginStateMenu -->
		<% } %>
				
				<br>
				
				<main id="main" class="MainWrap dFlex">
				<%if (userID_session == "" || userID_session != null) { %>
					<span>관리 매장을 선택 해 주세요</span>
				<% } %>
<!-- 					<div id="SelectValueArea" class="selectMenu"> -->
<!-- 						<span>선택한 메뉴 : </span> -->
<!-- 						<span id="SValue" class="SValue"></span> -->
<!-- 					</div> -->
					
<%-- 					<%@ include file="Inventory/InventoryAreaPage.jsp" %> --%>
					
					
				</main>
		</div>
<!-- 		div#LoginFormArea -->
		
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    