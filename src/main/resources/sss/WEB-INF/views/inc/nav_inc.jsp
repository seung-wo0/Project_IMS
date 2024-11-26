<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<body>
	<div id="nav">
		<ul>
			<li class="Main_Home" >홈으로</li>
			<li id="Inventory" onclick="fnInventoryList(this);">- 상품관리</li>
			<li id="SellStatus" onclick="fnInventoryList(this);">- 판매정산</li>
			<li id="3">- 3 번메뉴</li>
			<li id="4">- 4 번메뉴</li>
			<li id="5">- 5 번메뉴</li>
			<% if (userAuth_session == 2) { %>
			<hr/>
			
			<p class="span">관리자용 메뉴</p>
			<li id="Member_Edit" class="Member_Edit">- 회원관리</li>
			<% } %>
		</ul>
	</div>
</body>
