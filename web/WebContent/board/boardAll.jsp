<%@page import="board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  </tr>
</thead>
  <tbody>
    <%
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
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>