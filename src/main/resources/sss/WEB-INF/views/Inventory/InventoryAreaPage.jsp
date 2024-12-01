<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%
	String Shop_Code = request.getParameter("Shop_Code");
	String Shop_Name = request.getParameter("Shop_Name");

// 	out.print("<br><br> 비동기통신 Shop_Code : " + Shop_Code);
// 	out.print("<br><br> 비동기통신 Shop_Name: " + Shop_Name);
%>

<jsp:useBean id="nowDate" class="java.util.Date" />
<c:set var="todayitemSellCnt" value="0"/>
<c:set var="todayitemSellPrice" value="0"/>
<c:forEach var="Shop_AllStatusList" items="${ Shop_AllStatusList }">
	<fmt:formatDate var="item_SellTM" value="${ Shop_AllStatusList.item_SellTM }" pattern="yyyyMMdd"/>
	<c:if test="${todayDate eq item_SellTM}">
		<c:set var="todayitemSellCnt" value="${todayitemSellCnt + Shop_AllStatusList.item_SellCnt }"/>
		<c:set var="todayitemSellPrice" value="${todayitemSellPrice + Shop_AllStatusList.item_SellPrice }"/>
	</c:if>
</c:forEach>
<div id="headerShopTitle" class="headerShopTitle">
	<h1>[ <%=Shop_Name %> ] 매장 현황</h1>
</div>
<div id="inventoryTodayArea" class="dFlex">
	
	<div id="inventoryAddArea" class="TodayAreas">
		<div id="InventoryAddTitle" class="TodayTitlediv">	
			<span class="TodayAreaTitle">금일 입고</span>
		</div>
		<div id="InventoryAddInfo" class="TodayInfodiv">
			<span class="TodayAreaInfo">0,000 개</span>
		</div>
	</div>
	
	<div id="itemSellArea" class="TodayAreas">
		<div id="itemSellTitle" class="TodayTitlediv">	
			<span class="TodayAreaTitle">금일 판매</span>
		</div>
		<div id="itemSellInfo" class="TodayInfodiv">
			<span class="TodayAreaInfo">
				<fmt:formatNumber value="${ todayitemSellCnt }" pattern="###,###,###"/> 개
			</span>
		</div>
	</div>
	
	<div id="SellPriceArea" class="TodayAreas">
		<div id="SellPriceTitle" class="TodayTitlediv">	
			<span class="TodayAreaTitle">금일 수익</span>
		</div>
		<div id="SellPriceInfo" class="TodayInfodiv">
			<span class="TodayAreaInfo">
				<fmt:formatNumber value="${ todayitemSellPrice }" pattern="###,###,###"/> 원
			</span>
		</div>
	</div>
	
</div>

<div id="content" class="dFlex">
<div id="InventoryArea" class="MainListArea">
	<div id="InventoryTitle" class="MainNavTitle dFlex">
		<span class="ListTitleName">재고 목록</span>			
		<form id="Menu_inventoryList" method="post">
			<input type="hidden" id="Shop_Name" name="Shop_Name" value="<%= Shop_Name  %>"></input>
			<input type="hidden" id="Shop_Code" name="Shop_Code" value="<%= Shop_Code  %>"></input>
		</form>				
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
				<td><fmt:formatNumber value="${ Shop_I_List.item_Price }" pattern="###,### 원" /></td>
<%-- 				<td>${ Shop_I_List.item_Price }</td> --%>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- div#InventoryList -->
</div>
<!-- div#InventoryArea -->

<div id="SellStatusArea" class="MainListArea">
		
	<div id="SellStatusTitle" class="MainNavTitle dFlex">
		<span class="ListTitleName">판매 정산</span>                                         
	</div>
	<!-- div#SellStatusTitle -->
	
	<div id="SellStatusList">
		<table id="List">
			<tr class="TableList">
				<th>상품명</th>
				<th>판매갯수</th>
<!-- 				<th>개별가격</th> -->
				<th>수익금</th>
			</tr>
			<c:forEach var="Shop_S_List" items="${ Shop_SellStatusList }">
			<tr class="TableList">
				<td>${ Shop_S_List.item_Name }</td>
				<td>${ Shop_S_List.item_SellCnt }</td>
<%-- 				<td>${ Shop_S_List.item_Price }</td> --%>
				<td><fmt:formatNumber value="${ Shop_S_List.item_SellPrice }" pattern="###,### 원"></fmt:formatNumber></td>
<%-- 				<td>${ Shop_S_List.item_SellPrice }</td> --%>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- div#SellStatusList -->
	
</div>
<!-- div#SellStatusArea -->
</div>