<%@page import="board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardAll.jsp</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<h3 class="page_title">회원 전체조회</h3>
<ul class="search">
	<li>제목</li>
	<li>이름</li>
	<li><button type="button">검색</button>
</ul>
<table border=1 id="members">
<thead>
  <tr>
    <th>no</th>
    <th>poster</th>
    <th>subject</th>
    <th>contents</th>
    <th>lastpost</th>
    <th>views</th>
    <th>filename</th>
    <th>이미지</th>
  </tr>
</thead>
  <tbody>
  <c:forEach items="${list}" var="board">
  <tr>
  	<td>${board.no}</td>
  	<td>${board.poster}</td>
  	<td><a href="#">${board.subject}</a></td>
  	<td>${board.contents}</td>
  	<td>${board.lastpost}</td>
  	<td>${board.views}</td>
  	<td><a href="download.do?filename=${board.filename}">${board.filename}</td>
  	<td>
    	<c:if test="${not empty board.filename}">
    		<img src="../images/${board.filename}" style="width:50px">
    	</c:if>
    </td>
  </c:forEach>
<%--     <%
  	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
  	for(BoardVO board : list) {
  	%>
  <tr>
    <td><a href="boardSelect.jsp"><%=board.getPoster()%></a></td>
    <td><%=board.getSubject()%></td>
    <td><%=board.getContents()%></td>
    <td><%=board.getNo()%></td>
    <td><%=board.getLastpost()%></td>
    <td><%=board.getViews()%></td>
    <td><%=board.getFilename()%></td>
    <td>
    	<c:if test="${not empty board.filename}">
    		<img src="../images/${board.filename}" style="width:50px">
    	</c:if>
    </td>
  </tr>
  <% } %> --%>
  </tbody>
</table>
</body>
</html>