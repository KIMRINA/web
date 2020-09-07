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
<c:forEach items="member" var="member">
	id : ${member.id}<br>
	pw : ${member.pw}<br>
	gender : ${member.gender}<br>
	job : ${member.job}<br>
	mailyn : ${member.mailyn}<br>
	reason : ${member.reason}<br>
	hobby : ${member.hobby}<br>
</c:forEach>
</body>
</html>