<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function inputCheck() {
	
	if(frm.poster.value == "") {
		alert("작성자 입력");
		frm.poster.focus();
		return false;
	}
	
	if(frm.subject.value == "") {
		window.alert("제목 입력");
		frm.subject.focus();
		return false;
	}
	
	if(frm.contents.value == "") {
		window.alert("내용 입력");
		frm.contents.focus();
		return false;
	}
	
	// 회원가입 폼 제출
	// frm.submit();
	return true;
	
}

</script>
<body>
<form method="post" name="frm" id="frm" action="boardInsert.do" onsubmit="return inputCheck()">
<h3 class="page_title">게시글 등록</h3>
	<div class="regist">
		<label for="poster">작성자</label>
		<input type="text" id="poster" name="poster">
		<br>
	</div>
	<div>
		<label for=subject>제목</label>
		<input type="text" id="subject" name="subject">
  		<br>
	</div>
	<div>
		<label for="contents">내용</label>
  		<textarea id="contents" name="contents" rows="3" cols="30">내용</textarea>
  		<br>
  	</div>
  	<div>
  		<label for="filename">첨부 파일 추가</label>
  		<input type="file" name="filename" size=30><br>
	</div>
  	<div>
  		<button type="reset">초기화</button>
		<button>등록</button>
	</div>
</form>
</body>
</html>