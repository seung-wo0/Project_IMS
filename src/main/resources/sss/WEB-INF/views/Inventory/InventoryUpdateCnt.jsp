<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String Shop_Name = request.getParameter("Shop_Name");
	String Shop_Code = request.getParameter("Shop_Code");
	String item_Name = request.getParameter("item_Name");
	String item_Cnt = request.getParameter("item_Cnt");
	String item_Num = request.getParameter("item_Num");
	String item_Price = request.getParameter("item_Price");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title><%= Shop_Name %> - 상품 변경/판매</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="InventoryUpdateCntWarp" class="InventoryUpdateCntWarp">
		<main id="main" class="InventoryUpdateCntMain">
			<form id="inven_updateFrm">
			<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code %>" readonly>
			상품명 : <input type="text" id="item_Name" name="item_Name" value="<%= item_Name %>" readonly>
			<input type="hidden" id="item_Num" name="item_Num" value="<%= item_Num %>" readonly>
			
			<br/>
			현재 재고 : <input type="text" id="NowCnt" class="NowCnt" name="NowCnt" value="<%= item_Cnt %>" placeholder="기존 수량 정보 칸" readonly>
			<br/>
			변경 재고 : <input type="number" id="Inven_UpdateCnt" name="Inven_UpdateCnt" class="Inven_UpdateCnt" placeholder="추가제거될 수량 입력칸">
			<br/>
			가격 : <input type="text" id="item_Price" name="item_Price" class="item_Price" name="item_Price" value="<%= item_Price %>" placeholder="가격설정">
			<br/>

			<span> ex) 기존수량(55) + 입력수량(5) = 변경되는수량(60)</span>
			</form>
			<button type="button" id="Inven_ChangeAddBtn" class="Inven_addBtn Inven_UpdateBtn">입고</button>
			<button type="button" id="Inven_ChangeOutBtn" class="Inven_outBtn Inven_UpdateBtn">출고</button>
			<button type="button" id="Inven_Items_SellBtn" class="Inven_sellBtn Inven_UpdateBtn">판매</button>
			<button type="button" id="Inven_Items_DelBtn" class="Inven_itemDelBtn Inven_UpdateBtn">삭제</button>
		</main>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    