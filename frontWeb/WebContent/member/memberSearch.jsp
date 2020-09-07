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
<form action="${pageContext.request.contextPath}/memberSearch.do">
	id : <input name="id">
	<button>검색</button>
</form>
</body>
</html>