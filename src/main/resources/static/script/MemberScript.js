$(function () {

	/////////////////////////
	//////// tos.jsp ////////
	/////////////////////////
	$("#tosAllChk").click(function(){
		let chkState = $("#tosAllChk").prop("checked");
		
		$(".chkAgree").prop("checked",chkState)
	})

	$(".chkAgree").click(function(){
		let cnt=0;
		
		$(".chkAgree").each(function (i){
			let chk = $(".chkAgree").eq(i).prop("checked");
			
			if(chk){
				cnt++;
			}
		})
		
		if(cnt==3){
			$("#tosAllChk").prop("checked",true);
		} else{
			$("#tosAllChk").prop("checked",false);
		}
	})
	
	$("#tosAgreeBtn").click(function(){
		let chk1 = $("#chk1").prop("checked");
		let chk2 = $("#chk2").prop("checked");
		
		if(chk1 && chk2){
		 location.href="/join"
			
		}else{
			alert("필수항목을 체크해주세요");
			return false;
		}
	})
	
	////////////////////
	// MemberJoin.jsp //
	////////////////////
	$("#Join_Btn").click(function(){
		let JoinUserPW = $("#JoinUserPW").val().trim();
		let reuPW = $("#reuPW").val().trim();
		let userPhone = $("#userPhone").val();
		let checkNum = /^[0-9]+$/; //핸드폰번호 유효성검사
		if (JoinUserPW != reuPW){
			alert("비밀번호가 다릅니다.")
			$("#reuPW").focus();
			return false;
		} else if (! checkNum.test(userPhone) || userPhone.length < 11) {
			alert("숫자만 입력이 가능하며, 올바른 핸드폰번호를 입력해 주세요\r\n하이픈(-) 은 제외 해주세요")
			$("#userPhone").focus();
			return false;
		} else {
			$("#joinProcFrm").attr("action","JoinProc");
			$("#joinProcFrm").submit();
		}
	})
	
	$("#chkID").click(function(){
		let JoinUserID = $("#JoinUserID").val().trim();
		
		if (JoinUserID=="" || JoinUserID== null){
			alert("아이디를 입력하세요");
			$("#JoinUserID").focus();
		} else {
			location.href = "/chkID?JoinUserID="+JoinUserID;
		}
	})
		
});