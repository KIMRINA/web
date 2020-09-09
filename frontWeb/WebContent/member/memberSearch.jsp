<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색</title>
<script>
	function decoTest() {
		console.log("test");
	}
</script>
</head>
<body>   <%-- http://localhost/memberSearch.do --%>
<h3>회원 검색</h3>
<%-- http://localhost/frontWeb/memberList.do | 절대경로로 가기위해 / 앞에 ${pageContext.request.contextPath} 사용 --%>
<a href="${pageContext.request.contextPath}/memberList.do">전체 검색</a>
<form action="${pageContext.request.contextPath}/memberSearch.do">
	<input type="hidden" name="job" value="search">
	<br>id : <input name="id">
	<button>검색</button>
</form>
</body>
</html>