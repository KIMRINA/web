<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearch.jsp</title>
</head>
<body>   <%-- http://localhost/memberSearch.do --%>
<h3>회원 검색</h3>
<form action="${pageContext.request.contextPath}/memberSearch.do">
	<input type="hidden" name="job" value="search">
	id : <input name="id">
	<button>검색</button>
</form>
</body>
</html>