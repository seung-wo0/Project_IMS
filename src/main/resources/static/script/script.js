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
		
		$(".Join_Btn").click(function() {
			window.location.href = "Join";
		});
		
		$(".Logout_Btn").click(function() { 
			window.location.href = "/Logout";
		});
		
		$(".Member_Edit").click(function() { 
			window.location.href = "/Member_Edit";
		});

		
		$(".MyPage_Btn").click(function() {
			console.log("마이페이지 클릭");
			window.location.href = "/MyPage";
		});
		
	});
	
	$(document).ready(function() { // 회원가입 관련
		
		$("#Join_uid_check").click(function() { //회원가입>ID중복체크
			var Join_uid = $("#Join_uid").val().trim();
			console.log("Join_uid : " + Join_uid);
			if (Join_uid == "") {
				alert("아이디를 입력후 중복체크 해주세요.");
			} else {
				location.href = "/chkID?Join_uid="+Join_uid;
			}
		});
			
		$("#Join_Btn").click(function() { //회원가입>가입신청
			var message = $("#JoinID_Chk").text();
			var Join_uid = $("#Join_uid").trim;
			var Join_upw1 = $("#Join_upw1").val();
			var Join_upw2 = $("#Join_upw2").val();
			var Join_Phone_2 = $("#Join_Phone_2").val().trim();
			var Join_Phone_3 = $("#Join_Phone_1").val().trim();
			var Join_Email1 = $("#Join_Email_1").val().trim();
			var Join_Email2 = $("#Join_Email_2").val().trim();
			console.log("Join_Phone_2.length : " + Join_Phone_2.length);
			console.log("Join_Email1 : " + Join_Email1);
			console.log("Join_Email2 : " + Join_Email2);
			if (message == "사용 가능한 아이디 입니다.") {
				
				if (Join_upw1 != Join_upw2) { // 패스워드 일치여부 확인
					alert("패스워드 불일치");
				} else if (Join_Phone_2.length != 4 && Join_Phone_3.length != 4) { // 핸드폰번호 를 적지않았을경우
					alert("휴대폰 번호를 적어주세요");
				} else if(Join_Email1 == "" || Join_Email2 == "") {//이메일부분이 공란이라면 아래 동작
					alert("이메일을 입력해주세요");
				} else if(Join_uid != "") { // 아이디입력을 체크 공백이 아니라면 아래 동작
					$("#Join_Btn").prop("type","submit");
				}
				
			} else if (message == "") {
				alert("아이디 중복체크를 해주세요.");
			} else {
				alert("아이디가 중복되었습니다. 변경후 다시시도 해주세요.");
			}

		});
		
	});
	
	$(document).ready(function() { //메인 페이지 클릭이벤트
		$(".ListTitleMenu").click(function() {
			var PageName = $(this).attr("id");
			console.log("더보기를 클릭함 : " + PageName);
			location.href = "Menu_" + PageName;
		});
		
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