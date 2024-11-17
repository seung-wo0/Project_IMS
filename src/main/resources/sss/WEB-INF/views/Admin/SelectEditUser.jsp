<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<% 
	String SelectUserID = request.getParameter("SelectUserID");
	String userID_session = (String)session.getAttribute("userID_session");
	int userAuth_session = 0;
	
	if(userID_session != null){
		userAuth_session = (int)session.getAttribute("userAuth_session");
	}
	

%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>${SelectUserID} 님 권한수정</title>
	<link rel="stylesheet" href="/style/Admin_style.css?v">
</head>
<body>
<% if(userAuth_session < 2) { %>
	<script>
		alert ("관리자만 접근 할 수 있는 페이지 입니다.");
		window.location.href = "/";
	</script>
<% } %>
	<div id="wrap" class="SelectEditUser">
		<p> ${SelectUserID} 님 관리매장 추가</p>
		<div id="ShopListArea">
			<% if (userAuth_session != 0 && userAuth_session > 0) { %>
			<form id="selectEditUserForm">
				<select id="ShopList" class="selectShop" name="selectShop">
					<option value="">${SelectUserID} 님이 관리할 매장 선택</option>
					<c:forEach var="shopList" items="${shopList}" varStatus="status">
						<option value="${shopList.shop_Code}">${shopList.shop_Name}</option>
					</c:forEach>
				</select>
				<input id="SelectUserID" class="SelectUserID" name="SelectUserID" type="hidden" disabled="disabled" value="${ SelectUserID }">
				<button id="selectEditUser" class="selectEditUser" type="button">수정</button>
			</form>
			<!-- form#selectEditUserForm -->
			<% } %>
		</div>
		<!-- div#ShopListArea -->
	</div>
	<!-- div#wrap.SelectEditUser -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/admin_script.js"></script>
</body>
</html>    