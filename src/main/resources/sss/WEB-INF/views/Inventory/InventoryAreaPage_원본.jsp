<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
	String Shop_Name = request.getParameter("Shop_Name");
	String Shop_Code = request.getParameter("Shop_Code");
	String item_Name = request.getParameter("item_Name");
	String item_Cnt = request.getParameter("item_Cnt");
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
		<!-- div#InventoryArea -->
		
		<div id="SellStatusArea" class="MainListArea">
		
			<div id="SellStatusTitle" class="MainNavTitle dFlex">
				<span class="ListTitleName">판매 정산 리스트</span>                                         
				<span id="SellStatus" class="ListTitleMenu">..더보기</span>
			</div>
			<!-- div#SellStatusTitle -->
			
			<div id="SellStatusList">
				<table id="List">
					<tr class="TableList">
						<th>상품명</th>
						<th>판매갯수</th>
						<th>판매가격</th>
						<th>수익금</th>
					</tr>
					<tr class="TableList">
						<td>아몬드</td>
						<td>3</td>
						<td>1000</td>
						<td>3000</td>
					</tr>
				</table>
			</div>
			<!-- div#SellStatusList -->
			
		</div>
		<!-- div#SellStatusArea -->
		
		<div id="3번째Area" class="MainListArea">
		
			<div id="3번째Title" class="MainNavTitle dFlex">
				<span class="ListTitleName">3번 리스트</span>                                         
				<span id="3번째Title" class="ListTitleMenu">..더보기</span>
			</div>
			<!-- div#3번째Title -->
			
			<div id="3번째List">
				<table id="List">
					<tr class="TableList">
						<th>미정</th>
						<th>미정</th>
						<th>미정</th>
					</tr>
					<tr class="TableList">
						<td>미정</td>
						<td>0</td>
						<td>0</td>
					</tr>
				</table>
			</div>
			<!-- div#3번째List -->
			
		</div>
		<!-- div#3번째Area -->
		
		<div id="4번째Area" class="MainListArea">
		
			<div id="4번째Title" class="MainNavTitle dFlex">
				<span class="ListTitleName">4번 리스트</span>                                         
				<span id="4번째" class="ListTitleMenu">..더보기</span>
			</div>
			<!-- div#4번째Title -->
			
			<div id="4번째List">
				<table id="List">
					<tr class="TableList">
						<th>미정</th>
						<th>미정</th>
						<th>미정</th>
					</tr>
					<tr class="TableList">
						<td>미정</td>
						<td>0</td>
						<td>0</td>
					</tr>
				</table>
			</div>
			<!-- div#4번째List -->
			
		</div>
		<!-- div#4번째Area -->
