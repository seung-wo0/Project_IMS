<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%
	String Shop_Code = request.getParameter("Shop_Code");
	String Shop_Name = request.getParameter("Shop_Name");
%>
<c:set var="item_AllSellPrice" value="${ 0 }"/>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>[ <%= Shop_Name %> ] 매장관리 - 판매정산</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>

	<div id="wrap" class="SellStatusListWrap">
		<header id="header" class="SellStatusListHeader">
			<!-- Header include 부분 시작-->
			<%@ include file="../inc/Header_inc.jsp" %>
			<!-- Header include 부분 끝-->
		
		</header>
	
		<main id="main" class="SellStatusListMain">
			<div id="headerMenu" class="headerMenu dFlex">
				<h2>[ <%= Shop_Name %> ] 매장관리 - 판매정산</h2>
<!-- 				<button id=InventoryChangeBtn class="InventoryChangeBtn">재고변경</button> -->
				<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code %>"/>
				<input type="hidden" id="Shop_Name" name="Shop_Name" value="<%= Shop_Name %>"/>
<!-- 				<button id="InventoryItemSellBtn" class="InventoryItemSellBtn">재고판매</button> -->
				
				<b><span id="item_AllSellPrice"> 총 판매금액 : ${ item_AllSellPrice } </span>	</b>
				<span class="backPage">돌아가기..</span>
			</div>
		
			<div id="SellStatusList">
				<table id="List">
					<tr class="TableList">
						<th id="item_Name">상품명</th>
						<th id="item_Cnt">판매갯수</th>
						<th id="item_Price">판매가격</th>
						<th id="item_Price2">수익금</th>
						<th id="item_SellTM">판매시간</th>
					</tr>
						
					<c:forEach var="Shop_S_List" items="${ Shop_SellStatusList }">
					<tr class="TableList">
						<td id="item_Name">${ Shop_S_List.item_Name }</td>
						<td id="item_Cnt">${ Shop_S_List.item_SellCnt }</td>
						<td id="item_Price"><fmt:formatNumber value="${ Shop_S_List.item_Price }" pattern="###,### 원"/></td>
						<td id="item_Price2"><fmt:formatNumber value="${ Shop_S_List.item_SellPrice }" pattern="###,### 원"/></td>
						<td id="item_SellTM"><fmt:formatDate value="${ Shop_S_List.item_SellTM }" pattern="yyyy.MM.dd hh:mm:ss"/></td>
<%-- 						<td>${ Shop_S_List.item_SellPrice }</td> --%>
						<c:set var="item_AllSellPrice" value="${ item_AllSellPrice + Shop_S_List.item_SellPrice }"/>
					</tr>
					</c:forEach>
					<c:set var="item_AllSellPrice">
						<fmt:formatNumber value="${ item_AllSellPrice }" pattern="###,### 원"/>
					</c:set>
<%-- 					<fmt:formatNumber value="${ item_AllSellPrice }" pattern="###,### 원" /> --%>
						<script>
							const AllPrice = "${ item_AllSellPrice }";
							document.getElementById("item_AllSellPrice").textContent = "[ 총 수익금 : " + AllPrice + " ]";	
// 						$("#item_AllSellPrice").text(${item_AllSellPrice});
						</script>
				</table>
			</div>
			<!-- div#SellStatusList -->				
		</main>
	</div>
	<!-- div#wrap -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/script/script.js"></script>
</html>    