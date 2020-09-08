<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete.jsp</title>
<script>
	if('${error}' !='') {
		alert('ID를 입력하세요');
	}
</script>
</head>
<body>
<h3>회원 삭제</h3>
${error}
<form action="${pageContext.request.contextPath}/memberSearch.do">
	<%-- search와 delete의 검색기능을 구분하기위해 파라미터 값을 부여함 --%>
	<input type="hidden" name="job" value="delete">   <%-- hidden은 화면에 보이지는 않지만 값이 넘어가짐 --%>
	id 검색 : <input name="id">
	<button>검색</button>
</form>
<%-- id를 먼저 검색해서 검색 결과를  출력하고 리스트에 있는 아이디를 삭제시키는것 --%>

<%-- 검색 결과 출력 --%>
<c:if test="${not empty member}">
<h3>검색 결과</h3>
	${member.job}<br>
	${member.gender}<br>
	${member.id}<br>
	<form action="${pageContext.request.contextPath}/memberDelete.do">
		<input name="id" value="${member.id}" type="hidden">
		<button>삭제</button>
	</form>
</c:if>
</body>
</html>