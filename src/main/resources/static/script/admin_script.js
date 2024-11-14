$(function () {

	$(document).ready(function() { //관리 페이지 관련
		$("#main_home").click(function() {
			window.location.href = "/";
		});
	});	
	
	$(document).ready(function() { //리스트 호버이벤트
		$(".listRow").hover(function() {
			$(this).css({
				"background-color" : "#f0f0f0",
				"cursor" : "pointer"
			}) }, function() {
			$(this).css({
				"background-color" : "",
				"cursor" : ""
			})
		});
		$(".listCol").click(function() {
			//var divID = $(this).attr("id");
			//console.log("클릭 : " + divID);
			var SelectUserID = $(this).find("span:first").text();
			console.log("SelectUserID : " + SelectUserID);
			var SelectUserURL = "EditUserPage?SelectUserID=" + SelectUserID;
		
		    // 화면 크기
		    var screenWidth = window.innerWidth;
		    var screenHeight = window.innerHeight;
		
		    // 팝업 창의 위치 (화면의 중앙으로 계산)
		    var left = (screenWidth / 2) - (600 / 2);
		    var top = (screenHeight / 2) - (400 / 2);
			
			OpenWin_variety(SelectUserURL, SelectUserID+' 권한 수정', 600, 400, top, left);
			//window.location.href="EditUserPage?SelectUserID="+SelectUserID;
		});
		
		
	});
	
});

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