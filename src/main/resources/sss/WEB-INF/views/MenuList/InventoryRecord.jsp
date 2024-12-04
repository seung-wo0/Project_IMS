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
	<title>[ <%= Shop_Name %> ] 매장관리 - 입·출고 목록</title>
	<link rel="stylesheet" href="/style/style.css?v">
</head>
<body>
	<div id="wrap" class="InventoryRecordListWrap">
		<div id="headerMenu" class="headerMenu dFlex">
				<h2>[ <%= Shop_Name %> ] 매장관리 - 입·출고 목록</h2>
				
				<button id=InventoryItemAddBtn class="InventoryItemAddBtn">상품 추가</button>
					<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code %>"/>
					<input type="hidden" id="Shop_Name" name="Shop_Name" value="<%= Shop_Name %>"/>
				<span class="backPage">돌아가기..</span>
		</div>
		<!-- div#headerMenu -->
		
		<div id="InventoryRecordList">
			<table id="List">
				<tr class="TableList">
					<th id="item_Name">상품명</th>
					<th id="item_Cnt">입·출고</th>
					<th id="item_RecordTM">시간</th>
				</tr>
				<c:forEach var="Shop_InventoryRecord" items="${ Shop_InventoryRecord }">
				<tr class="TableList">
					<input type="hidden" id="item_Num" name="item_Num" value="${ Shop_InventoryRecord.num }" />
					<td id="item_Name">${ Shop_InventoryRecord.item_Name }</td>
					<td id="item_Cnt">${ Shop_InventoryRecord.item_Cnt }</td>
					<td id="item_RecordTM"><fmt:formatDate value="${ Shop_InventoryRecord.item_RecordTM }" pattern="yyyy.MM.dd hh:mm:ss"/> </td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<!-- div#InventoryRecordList -->	
		
	</div>
	<!-- div#wrap -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/script/script.js"></script>
</body>
</html>    