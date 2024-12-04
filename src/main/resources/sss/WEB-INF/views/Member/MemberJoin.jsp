<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Inventory Management Service - Member Join Page</title>
	<link rel="stylesheet" href="/style/MemberStyle.css?v">
</head>
<body>
	<div id="wrap" class="MemberJoinWrap">
		<h1>Inventory Management Service<br/>회원가입</h1>
		 
		<form id="joinProcFrm" method="post">
		
			<div id="inputArea">
				<button type="button" id="chkID">아이디 중복체크</button>
				<span id="chkRes">${resTxt}</span> 
				<input type="text" placeholder="아이디" name="JoinUserID" id="JoinUserID" required maxlength="20" value="${nowID}"> 
				<input type="password" placeholder="비밀번호" name="JoinUserPW" id="JoinUserPW" required maxlength="20">
				<input type="password" placeholder="비밀번호 재확인" name="reuPW" id="reuPW" required maxlength="20">
				<input type="text" placeholder="핸드폰번호 하이픈(-) 없이 입력해주세요" name="userPhone" id="userPhone" required maxlength="11" pattern="[0-9]+">
				<input type="text" placeholder="이메일" id="userEmail" name="userEmail" required maxlength="50">
			</div>
			<!-- div#inputArea -->
			
		</form>
		<!-- form#joinProcFrm -->

		<div id="btnArea">
			<button id="Join_Btn">가입하기</button>
		</div>
		<!-- div#btnArea -->
		
	</div>
	<!-- div#wrap.MemberJoinWrap -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/MemberScript.js"></script>
</body>
</html>    