$(function () {
	
	//메인홈페이지 관련
	$(document).ready(function() { 
		$("#main_home").click(function() {
			window.location.href = "/";
		});
		
		$(".Login_Btn").click(function() {
			var LoginUID = $("#LoginID").val().trim();
			var LoginUPW = $("#LoginPW").val().trim();
			console.log(LoginUID);
			console.log(LoginUPW);
			if(LoginUID == "" || LoginUID == null) {
				alert("아이디를 입력해주세요")
			} else if(LoginUPW == "" || LoginUPW == null) {
				alert("패스워드를 입력해주세요")
			} else {
				window.location.href = "LoginProc";
			}
		});
		
		//회원가입 전 동의페이지
		$(".Join_Btn").click(function() { 
			window.location.href = "/tos";
		});
		
		//모든 세션 종료
		$(".Logout_Btn").click(function() { 
			window.location.href = "/Logout";
		});
		
		//관리자용 멤버관리
		$(".Member_Edit").click(function() { 
			window.location.href = "/Member_Edit";
		});
		
		//이전으로돌아가기
		$(".backPage").click(function() { 
			history.back();
		});
		
	});
	
	//인벤토리 - 재고관리 관련
	$(document).ready(function(){ 
		$(".InventoryChangeBtn").click(function() { //원본
			var Shop_Code = $("#Shop_Code").val();
			var Shop_Name = $("#Shop_Name").val();
			console.log("인벤토리 추가삭제클릭여부  : " + Shop_Code);
			var InventoryChangeBtn = "InventoryUpdateCntView?Shop_Code=" + Shop_Code + "&Shop_Name="+Shop_Name;
		
		    // 화면 크기
		    var screenWidth = window.innerWidth;
		    var screenHeight = window.innerHeight;
		
		    // 팝업 창의 위치 (화면의 중앙으로 계산)
		    var left = (screenWidth / 2) - (600 / 2);
		    var top = (screenHeight / 2) - (400 / 2);
			
			OpenWin_variety(InventoryChangeBtn, Shop_Name + '재고 추가/삭제', 600, 400, top, left);
		});
		

		$("#ShopInvenList").change(function() {
			var SValue = $("#ShopInvenList :selected").val();//셀렉트 옵션 값
//			var SVname = $("#ShopInvenList :selected").text();//셀렉트 값 이름
			var SVCode = $("#Shop_Code").val(); //매장코드
			let loading = false;
			console.log("SValue : " + SValue);
			if (SValue != "") {
//				$(".NowCnt").value(SValue + ", " + SVname);
				function loadMoreContent() {
	            	if (!loading) {
		                loading = true;
		                $.ajax({
		                    type: "get",
		                    url: "/InventoryItemCnt",
		                    data: {
								"Shop_Code" : SVCode,
		                        "item_Name" : SValue,
		                	},
		                    dataType: "json",
		                    async: true,
		                    success: function (data) {
		                        $("#NowCnt").val(data.item_Cnt);
//		                        console.log("재고 비동기 통신 성공");
		                        loading = false;
		                    },
		                    error: function () {
//		                        console.log("비동기 통신 실패");
		                        loading = false;
		                    }
		                });
	            	}
	        	}
    
			} else {
				$(".NowCnt").text("관리 매장을 선택 하세요.");
			}
			
//			console.log("Svalue = " + SValue);
//			console.log("SVname = " + SVname);
//			console.log($(".Svalue").text());
			loadMoreContent();
		});
		
		//인벤토리 재고변경 클릭 이벤트
		$(".Inven_UpdateBtn").click(function(){ 
			
			var Inven_UpdateCnt = $("#Inven_UpdateCnt").val();
			var WhatBtn = $(this).attr("id");
			if (Inven_UpdateCnt == "" || Inven_UpdateCnt == null || Inven_UpdateCnt == "0") {
				$("#Inven_UpdateCnt").focus();
				alert("추가 및 삭제 할 수량을 입력 해 주세요");
			} else {
//				console.log( WhatBtn +" 버튼누름 : " + Inven_UpdateCnt);
				$("#inven_updateFrm").attr("method","post");
				$("#inven_updateFrm").attr("action","invenUpdateProc?ClickBtn="+WhatBtn);
				$("#inven_updateFrm").submit();
			}
			
		});
	
		//인벤토리 재고판매 클릭 이벤트
		$(".InventoryItemSellBtn").click(function(){
			var Shop_Code = $("#Shop_Code").val();
			var Shop_Name = $("#Shop_Name").val();
			console.log("인벤토리 추가삭제클릭여부  : " + Shop_Code);
			var InventoryItemSellBtn = "InventoryItemSell?Shop_Code=" + Shop_Code + "&Shop_Name="+Shop_Name;
		
		    // 화면 크기
		    var screenWidth = window.innerWidth;
		    var screenHeight = window.innerHeight;
		
		    // 팝업 창의 위치 (화면의 중앙으로 계산)
		    var left = (screenWidth / 2) - (600 / 2);
		    var top = (screenHeight / 2) - (400 / 2);
			
			OpenWin_variety(InventoryItemSellBtn, Shop_Name + '재고 판매', 600, 400, top, left);
		});
		
		//인벤토리 재고판매 클릭 이벤트
		$(".Inven_ItemSellBtn").click(function(){ 
			
			var Inven_UpdateCnt = $("#Inven_UpdateCnt").val();
			var WhatBtn = $(this).attr("id");
			if (Inven_UpdateCnt == "" || Inven_UpdateCnt == null || Inven_UpdateCnt == "0") {
				$("#Inven_SellCnt").focus();
				alert("추가 및 삭제 할 수량을 입력 해 주세요");
			} else {
//				console.log( WhatBtn +" 버튼누름 : " + Inven_UpdateCnt);
				$("#inven_itemSellFrm").attr("method","post");
				$("#inven_itemSellFrm").attr("action","invenUpdateProc?ClickBtn="+WhatBtn);
				$("#inven_itemSellFrm").submit();
			}
			
		});
		
	});
	
	$(document).ready(function() { //메인 페이지 클릭이벤트
//		$(".ListTitleMenu").click(function() {
//			var PageName = $(this).attr("id");
//			console.log("더보기를 클릭함 : " + PageName);
//			var Shop_Code = $("#ShopList :selected").val();
//			console.log("선택한 매장 코드 : " + Shop_Code);
////			location.href = "Menu_" + PageName;
//		});
		
		
		$("#ShopList").change(function() {
			var SValue = $("#ShopList :selected").val();//셀렉트 옵션 값
			var SVname = $("#ShopList :selected").text();//셀렉트 값 이름
			let loading = false;
			
			if (SValue != "") {
				$(".MainWrap").text(SValue + ", " + SVname);
				function loadMoreContent() {
	            	if (!loading) {
		                loading = true;
		                $.ajax({
		                    type: "get",
		                    url: "/test",
		                    data: {
								"Shop_Code" : SValue,
		                        "Shop_Name": SVname,
		                	},
		                    dataType: "html",
		                    async: true,
		                    success: function (data) {
		                        $("#main").html(data);
		                        console.log("비동기 통신 성공");
		                        loading = false;
		                    },
		                    error: function () {
		                        console.log("비동기 통신 실패");
		                        loading = false;
		                    }
		                });
	            	}
	        	}
    
			} else {
				$(".MainWrap").text("관리 매장을 선택 하세요.");
			}
			
//			console.log("Svalue = " + SValue);
//			console.log("SVname = " + SVname);
//			console.log($(".Svalue").text());
			loadMoreContent();
		});
		
	});

});

//jsp 파일내 ".ListTitleMenu" 의 onclick 이벤트
function fnInventoryList(MenuName) {
    var PageName = $(MenuName).attr("id");
    console.log("더보기를 클릭함 : " + PageName);
	var Shop_Code = $("#ShopList :selected").val();
	console.log("선택한 매장 코드 : " + Shop_Code);
//	location.href = "Menu_" + PageName;
		
	$("#Menu_inventoryList").attr("action", "Menu_" + PageName).submit();
}

//재고관리 자식창 페이지 
function OpenWin_variety(url, windowName, width, height, top, left) {
    var newWindow = window.open(url, windowName, 
        "width=" + width + 
        ", height=" + height + 
        ", top=" + top + 
        ", left=" + left + 
        ", resizable=yes, scrollbars=yes"
    );
    if (newWindow.focus) {
        newWindow.focus();
    }
}