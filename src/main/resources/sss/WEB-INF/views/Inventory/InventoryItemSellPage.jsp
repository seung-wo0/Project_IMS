<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
	String Shop_Name = request.getParameter("Shop_Name");
	String Shop_Code = request.getParameter("Shop_Code");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title><%= Shop_Name %> - 상품 판매</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="InventoryItemSellWarp" class="InventoryItemSellWarp">
		<main id="main" class="InventoryItemSellMain">
			<form id="inven_itemSellFrm">
			<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code %>" readonly>
			<select name="ShopInvenList" id="ShopInvenList">
					<option value="">판매할 상품을 선택하세요.</option>
					<c:forEach var="InvenList" items="${Inven_List}">
						<option value="${ InvenList.item_Name}">${ InvenList.item_Name }</option>
					</c:forEach>
			</select>
			<br/>
			<input type="text" id="NowCnt" class="NowCnt" name="NowCnt" value="" placeholder="기존 수량 정보 칸" readonly>
			<br/>
			<input type="number" id="Inven_UpdateCnt" name="Inven_UpdateCnt" class="Inven_UpdateCnt" placeholder="판매할 수량 입력칸">
			<br/>
			<span> ex) 기존수량(55) - 팬매입력수량(5) = 변경되는수량(50)</span>
			</form>
			<button type="button" id="Inven_Items_SellBtn" class="Inven_sellBtn Inven_ItemSellBtn">판매</button>
		</main>
	</div>
	<!-- div#wrap -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    