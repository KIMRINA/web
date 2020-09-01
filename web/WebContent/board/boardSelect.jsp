<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardSelect.jsp</title>
</head>
<body>
	<h3 class="page_title">내 정보 조회</h3>
	<div><span class="label">no</span><span>1</span></div>
	<div><span class="label">poster</span><span>김린아</span></div>
	<div><span class="label">subject</span><span>제목뭐라할까</span></div>
	<div><span class="label">contents</span><span>응과제</span></div>
	<div><span class="label">lastpost</span><span>2020/08/26</span></div>
	<div><span class="label">views</span><span>1000</span></div>
	<div><span class="label">filename</span><span>no</span></div>
	<button type="button" id="btnPage">목록으로 </button>

<script>
	btnPage.addEventListener("click",goPage);
	function goPage(){
		// history.back();
		// history.go(-1);  // 이전페이지로 이동
		// location.href="memberAll.jsp";
		location.assign("boardAll.jsp");  // 네가지가 다 같은 방법 = 이전페이지로 이동
	}
</script>
</body>
</html>