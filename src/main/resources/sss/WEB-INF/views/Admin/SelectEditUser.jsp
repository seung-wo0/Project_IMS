<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<span>
			${SelectUserID} 
		</span>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    