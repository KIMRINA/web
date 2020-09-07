<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDeleteOutput.jsp</title>
</head>
<body>
<c:forEach items="member" var="mem">
	id : ${mem.id}<br>
	pw : ${mem.pw}<br>
	gender : ${mem.gender}<br>
	job : ${mem.job}<br>
	mailyn : ${mem.mailyn}<br>
	reason : ${mem.reason}<br>
	hobby : ${mem.hobby}<br>
</c:forEach>
</body>
</html>