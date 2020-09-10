<%@page import="dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html><html>
<head>
<meta charset="UTF-8">
<title>deptSelectAll.jsp</title>
<style>
	.pagination li {
		display : inline-block;
		border : 1px solid hotpink;
		}
	.pagination .active {
		border : 1px solid gray;
		background-color : pink;
	}
</style>
</head>
<body>
<%@include file="/common/header.jsp" %>
<form name="searchFrm">		<%-- 검색 폼 생성 --%>
	<input type="hidden" name="p" value="1">
	<input name="department_name" value="${param.department_name}">
	<button>검색</button>
</form>
<table border="1">
<% 
	ArrayList<DeptVO> list = (ArrayList<DeptVO>)request.getAttribute("list");
	for(DeptVO dept : list ) {
%>
	<tr>
		<td><a href="deptSelect?department_id=<%=dept.getDepartment_id()%>"><%=dept.getDepartment_id()%></a></td>
		<td><%=dept.getDepartment_name()%></td>
	</tr>
<% } %>
</table>

<my:paging paging="${paging}" jsfunc="gopage" />
<script>
	function gopage(p) {			// 검색 function
		searchFrm.p.value = p;		// 페이지번호 받아와서 submit에 넘김
		searchFrm.submit();
		
		// location.href="deptSelectAll?p=" + p;	// 이동되는 주소가 달라서 여러사람이 쓰기위해서는 매개값 p로 해줌
	}
</script>
</body>
</html>