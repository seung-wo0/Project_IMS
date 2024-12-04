<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% 
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
	<title>관리자용 - 전체멤버 권한수정</title>
	<link rel="stylesheet" href="/style/Admin_style.css?v">
	<% if(userAuth_session < 2) { %>
	<script>
		alert ("관리자만 접근 할 수 있는 페이지 입니다.");
		window.location.href = "/";
	</script>
	<% } %>
</head>
<body>
	<div id="wrap" class="MemberlistWrap">
		<header id="header" class="MemberEdit listHeader dFlex">		
			<h1>멤버 관리</h1>
			<span class="backPage">돌아가기..</span>
		</header>
		 
		<main id="main" class="listArea">
			<div id="MemberListArea dFlex">
				<div id="MemberListHeader" class="listCol dFlex">
					<span>아이디</span>
					<span>이메일</span>
					<span>연락처</span>
					<span>가입시간</span>
					<span>관리중인 매장</span>
				</div>
				<!-- div#MemberListHeader.dFlex -->
				
				<c:forEach var="memberList" items="${memberList}" varStatus="status">
				<div id="MemberList${memberList.num}" class="listCol listRow dFlex">
					<span>${memberList.userID}</span>
					<span>${memberList.userEmail}</span>
					<span>
						<c:out value="${fn:substring(memberList.userPhone, 0, 3)}"/>-<c:out value="${fn:substring(memberList.userPhone, 3, 7)}"/>-<c:out value="${fn:substring(memberList.userPhone, 7, 11)}"/>
					</span>
					<%-- <span>${memberList.userPhone}</span> --%>
					<span><fmt:formatDate value="${memberList.joinTM}" pattern="yyyy년MM월dd일 HH:mm:ss" /></span>
					<c:choose> 
						<c:when test="${memberList.shop_Code eq 0}">
					<span>X</span>
						</c:when>
						<c:otherwise>
					<span>${memberList.shop_Code}</span>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- div#MemberList.${memberListNum}.listRow.dFlex -->
				</c:forEach>
			</div>
			<!-- div#MemberListArea -->
		</main>
		<!-- main#main.MemberEdit -->
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/admin_script.js"></script>
</body>
</html>    