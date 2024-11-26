<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String userID_session = (String)session.getAttribute("userID_session");
	int userAuth_session = 0;
	
	if(userID_session != null){
		userAuth_session = (int)session.getAttribute("userAuth_session");
	}
// 	out.print("userID_session : " + userID_session);
// // 	out.print("<br> userAuth_session : " + userAuth_session);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>관리자용</title>
	<link rel="stylesheet" href="/style/Admin_style.css?v">
	<% if(userAuth_session < 2) { %>
	<script>
		alert ("관리자만 접근 할 수 있는 페이지 입니다.");
		window.location.href = "/";
	</script>
	<% } %>
</head>
<body>
	<div id="wrap" class="addShopWrap">
		<form action="" id="AddShopProcFrm">
			<div id="ShopCodeFrmArea" class="divAddShopFrmArea dFlex">
				<span>매장코드 : </span>
				<input type="text" id="AddShopCode" name="AddShopCode" value="${ RandomShopCode }" readonly>
			</div>
			<div id="ShopNameFrmArea" class="divAddShopFrmArea dFlex">
				<span>추가할 매장명 : </span>
				<input type="text" id="AddShopName" name="AddShopName" value="" placeholder="상품명 입력">
			</div>
			
		</form>
		<div id="AddShopProcFrmBtnArea">
			<button id="AddShopProcBtn" class="AddShopProcBtn">매장추가</button>
		</div>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    