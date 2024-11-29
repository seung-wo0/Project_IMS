<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ProcMessage = (String) request.getAttribute("ProcMessage");
// out.print(ProcMessage);
%>
<script>
	var ProcMessage = "<%= ProcMessage %>";
	alert(ProcMessage);
    window.opener.location.reload(); // 부모 창 새로고침
    window.close(); // 자식창 닫기
</script>