<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateOutput.jsp</title>
</head>
<body>
<h3> 정보 수정 결과 </h3>
ID : <span>${memberInfo.id}</span><br>
PW : <span>${memberInfo.password}</span><br>
JOB : <span>${memberInfo.job}</span><br>
REASON : <span>${memberInfo.reason}</span><br>
GENDER : <span>${memberInfo.gender}</span><br>
MAILSEND : <span>${memberInfo.mailsend}</span><br>
HOBBY : <span>${memberInfo.hobby}</span><br>
REGDATE : <span>${memberInfo.regdate}</span><br>
</body>
</html>