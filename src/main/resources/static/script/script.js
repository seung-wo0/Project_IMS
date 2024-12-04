$(function () {
	
	//메인홈페이지 관련
	$(document).ready(function() { 
		$(".Main_Home").click(function() {
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
			window.location.href = "/";
		});
		
	});
	
	//메뉴관련
	$(document).ready(function() { 
		$("div#nav>ul>li").hover(
			function() {
		        $(this).css({
		            "font-weight": "bold",
		            "cursor": "pointer",
		            "color": "red",
		        });
		    },
		    function() {
		         $(this).css({
		            "font-weight": "normal",
		            "cursor": "default",
		            "color": "",
		        });
		    }
		)
	});
	
	//인벤토리 - 상품관리 관련
	$(document).ready(function(){ 
		
		$("tr.ItemUpdate").click(function(){
			var item_Name = $(this).children("td#item_Name").text();
			var item_Cnt = $(this).children("td#item_Cnt").text();
			var item_Price = $(this).children("input#item_Price").val();
			var item_Num = $(this).children("input#item_Num").val();
			var Shop_Code = $("#Shop_Code").val();
			var Shop_Name = $("#Shop_Name").val();
			var InventoryChangeBtn = "InventoryUpdateCntView?item_Num=" + item_Num
									+ "&Shop_Code=" + Shop_Code 
									+ "&item_Name=" + item_Name
									+ "&item_Cnt=" + item_Cnt
  									+ "&item_Price=" + item_Price
									+ "&Shop_Name=" + Shop_Name;
			
			var screenWidth = window.innerWidth;
		    var screenHeight = window.innerHeight;
		    
		    var left = (screenWidth / 2) - (600 / 2);
		    var top = (screenHeight / 2) - (400 / 2);
			
			OpenWin_variety(InventoryChangeBtn, Shop_Name + '상품 추가/삭제/판매', 600, 400, top, left);
//			console.log("상품명 : " + item_Name);
//			console.log("재고 : " + item_Cnt);
//			console.log("가격 : " + item_Price);
		});
		
		$("tr.ItemUpdate").hover(
		    function() {
		        $(this).children($("td")).css({
		            "font-weight": "bold",
		            "cursor": "pointer",
		            "color": "red"
		        });
		    },
		    function() {
		         $(this).children($("td")).css({
		            "font-weight": "normal",
		            "cursor": "default",
		            "color": ""
		        });
		    }
		);

		
		//인벤토리 재고변경 클릭 이벤트 (InventoryUpdateCnt.jsp)
		$(".Inven_UpdateBtn").click(function(){ 
			var Inven_UpdateCnt = $("#Inven_UpdateCnt").val();
			var WhatBtn = $(this).attr("id");
			console.log("WhatBtn : "+ WhatBtn);
			if (Inven_UpdateCnt == "" || Inven_UpdateCnt == null) {
				$("#Inven_UpdateCnt").focus();
				alert("추가 및 삭제 할 수량을 입력 해 주세요");
			} else {
//				console.log( WhatBtn +" 버튼누름 : " + Inven_UpdateCnt);
				$("#inven_updateFrm").attr("method","post");
				$("#inven_updateFrm").attr("action","invenUpdateProc?ClickBtn="+WhatBtn);
				$("#inven_updateFrm").submit();
			}
			
		});
		
		//상품관리 상품추가 버튼시 이벤트 (Inventroy.jsp)
		$(".InventoryItemAddBtn").click(function(){
			var Shop_Code = $("#Shop_Code").val();
			var Shop_Name = $("#Shop_Name").val();
			
			var url = "/InventoryAddItem?Shop_Code=" + Shop_Code + "&Shop_Name=" + Shop_Name;
			var windowName = Shop_Name + " - 상품추가";
			var screenWidth = window.innerWidth;
		    var screenHeight = window.innerHeight;
		    var left = (screenWidth / 2) - (600 / 2);
		    var top = (screenHeight / 2) - (400 / 2);
			
			var newWindow = window.open(url, windowName, 
      		  				"width=" + 600 + 
       		 				", height=" + 400 + 
       						", top=" + top + 
        					", left=" + left + 
        					", resizable=yes, scrollbars=yes");
        					
			if (newWindow.focus) newWindow.focus();

		});
		
		$(".AddItemBtn").click(function(){
			var additem_Name = $("#AdditemName").val();
			var additem_Cnt = $("#AdditemCnt").val();
			var additem_Price = $("#AdditemPrice").val();
			
			if (additem_Name == null || additem_Name == "") {
				alert("상품명을 적어주세요.");
				$("#AdditemName").focus();
			} else if (additem_Cnt == null || additem_Cnt == "") {
				alert("상품의 재고를 적어주세요");
				$("#AdditemCnt").focus();
			} else if (additem_Price == null || additem_Price == "") {
				alert("상품의 가격을 적어주세요.");
				$("#AdditemPrice").focus();
			} else {
				console.log("모두 정상 재고를추가함");
				console.log("additem_Name : " + additem_Name);
				console.log("additem_Cnt : " + additem_Cnt);
				console.log("additem_Price : " + additem_Price);
				
				$("#InventoryAddItemProcFrm").attr("method","post");
				$("#InventoryAddItemProcFrm").attr("action","InventoryAddItemUpdate");
				$("#InventoryAddItemProcFrm").submit();
				
			}
				
		
		});
		
	});
	
	$(document).ready(function() { //메인 페이지 클릭이벤트
		$(".AddShopBtn").click(function() {
			var url = "/addShop";
			var windowName = "관리자용 - 매장추가";
			var screenWidth = window.innerWidth;
		    var screenHeight = window.innerHeight;
		    var left = (screenWidth / 2) - (600 / 2);
		    var top = (screenHeight / 2) - (400 / 2);
			
			var newWindow = window.open(url, windowName, 
      		  				"width=" + 600 + 
       		 				", height=" + 400 + 
       						", top=" + top + 
        					", left=" + left + 
        					", resizable=yes, scrollbars=yes");
        					
			if (newWindow.focus) newWindow.focus();

		});
		
		$(".AddShopProcBtn").click(function(){
			var AddShopName = $("#AddShopName").val();
			if (AddShopName == "" | AddShopName == null) {
				alert("매장명 입력하세요");
				$("#AddShopName").focus();
			} else {
				$("#AddShopProcFrm").attr("method","post");
				$("#AddShopProcFrm").attr("action","addShopProc");
				$("#AddShopProcFrm").submit();
			}

		});
		
		$("#ShopList").change(function() {
			var SValue = $("#ShopList :selected").val();//셀렉트 옵션 값
			var SVname = $("#ShopList :selected").text();//셀렉트 값 이름
			let loading = false;
			
			if (SValue != "") {
				$("#MainWrap").text(SValue + ", " + SVname);
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
		                        $("#mainCenter").html(data);
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
				$("#mainCenter").text("관리 매장을 선택 하세요.");
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
    var PageName = $(MenuName).attr("id").trim();
    console.log("더보기를 클릭함 : " + PageName);
	var Shop_Code = $("#ShopList :selected").val();
	console.log("선택한 매장 코드 : " + Shop_Code);
//	location.href = "Menu_" + PageName;
	if (Shop_Code == "" || Shop_Code == null || Shop_Code == 0) {		
		alert("관리 매장을 선택하세요");
	} else {
		$("#Menu_inventoryList").attr("action", "Menu_" + PageName).submit();
	}
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