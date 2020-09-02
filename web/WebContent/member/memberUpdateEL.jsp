<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateEL.jsp</title>
<script>
function inputCheck() {
	//id, pw 필수 입력 체크
	if(frm.id.value == "") {
		window.alert("id 입력");
		frm.id.focus();
		return false;
	}
	if(frm.pw.value == "") {
		alert("pw 입력");
		frm.pw.focus();
		return false;
	}
	
	//job(select 태그) 선택되었는지 확인
	if(frm.job.value == "") {
	// 위와 같음 if(frm.job.selectedIndex > 0) {
		alert("job 선택");
		frm.job.focus();
		return false;
	}
	
	// radio, checkbox
	var gender =
		document.querySelectorAll("[name='gender']:checked").length;
	if(gender == 0) {
		alert("성별 선택");
		return false;
	}
	
	// 회원가입 폼 제출
	// frm.submit();
	return true;
	
}

</script>
</head>
<body>
<%@include file="/common/header.jsp" %>

<form method="post" name="frm" id="frm" action="memberUpdate" onsubmit="return inputCheck()">

<h3 class="page_title">정보수정</h3>
	<div class="regist">
		<br>
		<label for="id">ID:</label>
		<input type="text" id="id" name="id" value="${login.id}" readonly="readonly">
		<br>
	</div>
	<div>
		<label for="pw">PASSWORD:</label>
		<input type="password" id="pw" name="pw" value="${login.pw}">
		<br>
	</div>
	<div>
		<label for="gender">성별</label>
		<input type="radio" id="male" name="gender" value="male"
			<c:if test="${login.gender='male'}">checked="checked"</c:if>
		>남
  		<input type="radio" id="female" name="gender" value="female"
  			<c:if test="${login.gender='female'}">checked="checked"</c:if>
  		>여
  		<br>
	</div>
	<div>
		<label for="job">직업</label>
  		<select id="job" name="job">
  		<option value="">선택</option>
    	<option value="web"
    		<c:if test="${login.job='web'}">selected="selected"</c:if>
    	>웹개발</option>
    	<option value="dba"
    		<c:if test="${login.job='dba'}">selected="selected"</c:if>
    	>dba</option>
    	<option value="ap"
    		<c:if test="${login.job='ap'}">selected="selected"</c:if>
    	>앱개발</option>
  		</select>
  		<br>
  	</div>
  	<div>
  		<label for="reason">가입 동기</label>
  		<textarea id="reason" name="reason" rows="3" cols="30">${sessionScope.login.reason}</textarea><br>
  	</div>
  	<div>	
  		<label for="mailyn">메일수신여부</label>
  		<input type="checkbox" name="mailyn" value="Y"><br>
  	</div>
  	<div>	
  		<label for="hobby">취미</label>
  		<input type="checkbox" name="hobby" value="book"
  			<c:if test="${login.hobby='book'}">checked="checked"</c:if>
  		>독서
  		<input type="checkbox" name="hobby" value="music"
  			<c:if test="${login.hobby='music'}">checked="checked"</c:if>
  		>노래
  		<input type="checkbox" name="hobby" value="movie"
  			<c:if test="${login.hobby='movie'}">checked="checked"</c:if>
  		>영화
  	</div>
  	<div>
  		<button type="reset">초기화</button>
		<button>수정</button>
	</div>
</form>
</body>
</html>