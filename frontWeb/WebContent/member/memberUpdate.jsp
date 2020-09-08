<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html><html><head>
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
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(function(){
		// 초기화
		$("[name=gender]").val(["${member.gender}"]);
		$("[name=hobby]").val("${member.hobby}".replace("[","").replace("]","").split());	// read, music, movie를 split(구분기호 자르는 함수)를 이용해줌
		$("[name=mailyn]").val(["${member.mailyn}"]);
		$("#frm [name=job]").val("${member.job}");
	});
</script>
</head>
<body>
	<h3 class="page_title">회원수정</h3>

${error}
<form action="${pageContext.request.contextPath}/memberSearch.do">
	<%-- search와 delete의 검색기능을 구분하기위해 파라미터 값을 부여함 --%>
	<input type="hidden" name="job" value="update">   <%-- job 파라미터를 update로 설정 --%>
	id 검색 : <input name="id">
	<button>검색</button>
</form>

<%-- member가 검색된게 null이 아니면 --%>
<c:if test="${not empty member}">
<h3>검색 결과</h3>
<form method="post" name="frm" id="frm" action="${pageContext.request.contextPath}/memberUpdate.do" onsubmit="return inputCheck()">
	<div class="regist">
		<br>
		<label for="id">ID:</label>
		<input type="text" id="id" name="id" value="${member.id}" readonly="readonly">  <%-- readonly는 수정불가 라는 뜻 --%>
		<br>
	</div>
	<div>
		<label for="pw">PASSWORD:</label>
		<input type="password" id="pw" name="pw" placeholder="비밀번호" value="${member.pw}">
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
  		<textarea id="reason" name="reason" rows="3" cols="30">${member.reason}</textarea><br>
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
</c:if>
</body>
</html>