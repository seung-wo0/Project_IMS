<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    alert("${SuccessMsg}"); // 서버에서 전달한 alert 메시지 표시
    window.opener.location.reload(); // 부모 창 새로고침
    window.close(); // 자식창 닫기
    
</script>
