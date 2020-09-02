<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>내장객체</h3>
<%= session.getCreationTime() %> <%--세션 생성 시간 --%>
<%= application.getMajorVersion() %>
<% out.print("test"); %>
</body>
</html>