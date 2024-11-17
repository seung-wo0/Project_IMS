$(function () {

	$(document).ready(function() { //메인홈페이지 관련
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
		
		$(".Join_Btn").click(function() { //회원가입 전 동의페이지
			window.location.href = "/tos";
		});
		
		$(".Logout_Btn").click(function() { //모든 세션 종료
			window.location.href = "/Logout";
		});
		
		$(".Member_Edit").click(function() { //관리자용 멤버관리
			window.location.href = "/Member_Edit";
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
		
		$("")
		
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
			
			console.log("Svalue = " + SValue);
			console.log("SVname = " + SVname);
			console.log($(".Svalue").text());
			loadMoreContent();
		});
		
	});

	
});

function fnInventoryList(MenuName) {
    var PageName = $(MenuName).attr("id");
    console.log("더보기를 클릭함 : " + PageName);
	var Shop_Code = $("#ShopList :selected").val();
	console.log("선택한 매장 코드 : " + Shop_Code);
//			location.href = "Menu_" + PageName;
		
	$("#Menu_inventoryList").attr("action", "Menu_" + PageName).submit();
}