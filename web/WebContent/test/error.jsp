<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
<h1>404 not Found</h1>
에러내용 : <%=exception.getMessage() %> <br>
에러타입 : <%=exception.getClass().getName()%>
</body>
</html>