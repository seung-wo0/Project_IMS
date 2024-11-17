<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%
	String Shop_Code = request.getParameter("Shop_Code");
	String Shop_Name = request.getParameter("Shop_Name");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>[ <%= Shop_Name %> ] 매장관리 - 재고관리</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap" class="InventoryListWrap">
		<header id="header" class="InventoryListHeader">
			<h1>[ <%= Shop_Name %> ] 매장관리 - 재고관리</h1>
		</header>
		
		<main id="main" class="InventoryListMain">
			<div id="InventoryList">
				<table id="List">
					<tr class="TableList">
						<th>상품명</th>
						<th>재고</th>
						<th>가격</th>
					</tr>
					<c:forEach var="InvenList" items="${ ShopInventoryList }">
					<tr class="TableList">
						<td>${ InvenList.item_Name }</td>
						<td>${ InvenList.item_Cnt }</td>
						<td>${ InvenList.item_Price }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<!-- div#InventoryList -->				
		</main>
		
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    