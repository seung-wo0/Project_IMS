<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	String Shop_Code = request.getParameter("Shop_Code");
	String Shop_Name = request.getParameter("Shop_Name");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>[ <%= Shop_Name %> ] 매장관리 - 상품관리</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
	<div id="wrap" class="InventoryListWrap">
		<header id="header" class="InventoryListHeader">
			<!-- Header include 부분 시작-->
			<%@ include file="../inc/Header_inc.jsp" %>
			<!-- Header include 부분 끝-->
		</header>
		<!-- header#header -->

		<main id="main" class="InventoryListMain">
			
			<div id="headerMenu" class="headerMenu dFlex">
				<h2>[ <%= Shop_Name %> ] 매장관리 - 상품관리</h2>
				
				<button id=InventoryItemAddBtn class="InventoryItemAddBtn">상품 추가</button>
					<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code %>"/>
					<input type="hidden" id="Shop_Name" name="Shop_Name" value="<%= Shop_Name %>"/>

				
				<span class="backPage">돌아가기..</span>
			</div>
			<!-- div#headerMenu -->
			
			<div id="InventoryList">
				<table id="List">
					<tr class="TableList">
						<th id="item_Name">상품명</th>
						<th id="item_Cnt">재고</th>
						<th id="item_Price">가격</th>
					</tr>
					<c:forEach var="InvenList" items="${ ShopInventoryList }">
					<tr class="TableList ItemUpdate">
						<input type="hidden" id="item_Num" name="item_Num" value="${ InvenList.num }" />
						<td id="item_Name">${ InvenList.item_Name }</td>
						<td id="item_Cnt">${ InvenList.item_Cnt }</td>
						<td id="item_Price"><fmt:formatNumber value="${ InvenList.item_Price }" pattern="###,### 원" /></td>
						<input type="hidden" id="item_Price" name="item_Price" value="${ InvenList.item_Price }" />
						
<%-- 						<td> ${ InvenList.item_Price }</td> --%>
					</tr>
					</c:forEach>
				</table>
			</div>
			<!-- div#InventoryList -->			
				
		</main>
		<!-- main#main.InventoryListMain -->

	</div>
	<!-- div#wrap -->
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/script/script.js"></script>
</html>    