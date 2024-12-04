<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String Shop_Name = request.getParameter("Shop_Name");
	String Shop_Code = request.getParameter("Shop_Code");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title><%= Shop_Name %> - 상품 추가</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="InventoryAddItemWarp" class="InventoryAddItemWarp">
		<form action="" id="InventoryAddItemProcFrm">
			<div id="itemNameFrmArea" class="divAddItemFrmArea dFlex">
				<span>등록 상품명 : </span>
				<input type="text" id="AdditemName" name="AdditemName" value="" placeholder="상품명 입력">
			</div>
			<div id="itemCntFrmArea" class="divAddItemFrmArea dFlex">
				<span>등록상품의 갯수 : </span>
				<input type="number" id="AdditemCnt" name="AdditemCnt" placeholder="상품갯수 입력" >
			</div>
			<div id="itemPriceFrmArea" class="divAddItemFrmArea dFlex">
				<span>상품의 1개당 가격 : </span>
				<input type="number" id="AdditemPrice" name="AdditemPrice" placeholder="1개당 가격입력">
			</div>
<%-- 			<input type="hidden" id="Shop_Name" name="Shop_Name" value="<%= Shop_Name %>"> --%>
			<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code %>">
			
		</form>
		<div id="AddItemProcFrmBtnArea">
			<button id="AddItemBtn" class="AddItemBtn">상품추가</button>
		</div>
	</div>
	<!-- div#wrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    