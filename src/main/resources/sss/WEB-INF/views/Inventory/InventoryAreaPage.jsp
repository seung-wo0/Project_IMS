<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String Shop_Code = request.getParameter("Shop_Code");
	String Shop_Name = request.getParameter("Shop_Name");

// 	out.print("<br><br> 비동기통신 Shop_Code : " + Shop_Code);
// 	out.print("<br><br> 비동기통신 Shop_Name: " + Shop_Name);
%>
    
<link rel="stylesheet" href="/style/style.css?v">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/script/script.js"></script>

<div id="InventoryArea" class="MainListArea">
	<div id="InventoryTitle" class="MainNavTitle dFlex">
		<span class="ListTitleName">재고 목록 리스트</span>							
		<span id="Inventory" class="ListTitleMenu">..더보기</span>
	</div>
	<!-- div#InventoryTitle -->
			
	<div id="InventoryList">
		<table id="List">
			<tr class="TableList">
				<th>상품명</th>
				<th>재고</th>
				<th>가격</th>
			</tr>
			<c:forEach var="Shop_I_List" items="${ Shop_InventoryList }">
			<tr class="TableList">
				<td>${ Shop_I_List.item_Name }</td>
				<td>${ Shop_I_List.item_Cnt }</td>
				<td>${ Shop_I_List.item_Price }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- div#InventoryList -->
</div>