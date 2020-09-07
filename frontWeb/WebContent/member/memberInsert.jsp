<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<%-- /frontWeb/memberInsert.do or ../memberInsert.do --%>
<form method="post" name="frm" id="frm" action="${pageContext.request.contextPath}/memberInsert.do" onsubmit="return inputCheck()">

<h3 class="page_title">회원등록</h3>
	<div class="regist">
		<br>
		<label for="id">ID:</label>
		<input type="text" id="id" name="id">
		<br>
	</div>
	<div>
		<label for="pw">PASSWORD:</label>
		<input type="password" id="pw" name="pw" placeholder="비밀번호">
		<br>
	</div>
	<div>
		<label for="gender">성별</label>
		<input type="radio" id="male" name="gender" value="male">남
  		<input type="radio" id="female" name="gender" value="female">여
  		<br>
	</div>
	<div>
		<label for="job">직업</label>
  		<select id="job" name="job">
  		<option value="">선택</option>
    	<option value="web">웹개발</option>
    	<option value="dba">dba</option>
    	<option value="ap">앱개발</option>
  		</select>
  		<br>
  	</div>
  	<div>
  		<label for="reason">가입 동기</label>
  		<textarea id="reason" name="reason" rows="3" cols="30"></textarea><br>
  	</div>
  	<div>	
  		<label for="mailyn">메일수신여부</label>
  		<input type="checkbox" name="mailyn" value="Y"><br>
  	</div>
  	<div>	
  		<label for="hobby">취미</label>
  		<input type="checkbox" name="hobby" value="book">독서
  		<input type="checkbox" name="hobby" value="music">노래
  		<input type="checkbox" name="hobby" value="movie">영화
  	</div>
  	<div>
  		<button type="reset">초기화</button>
		<button>등록</button>
	</div>
</form>
</body>
</html>