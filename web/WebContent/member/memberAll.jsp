<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<h3 class="page_title">회원 전체조회</h3>
<ul class="search">
	<li>메일수신여부</li>
	<li>성별</li>
	<li><button type="button">검색</button>
</ul>
<table border=1 id="members">
<thead>
  <tr>
    <th>아디</th>
    <th>패스워드</th>
    <th>직업</th>
    <th>가입동기</th>
    <th>성별</th>
    <th>메일수신여부</th>
    <th>취미</th>
    <th>날짜</th>
  </tr>
</thead>
  <tbody>
  <%
  	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
  	for(MemberVO member : list) {
  %>
  <tr>
    <td><a href="memberSelect.jsp"><%=member.getId() %></a></td>
    <td><%=member.getPw() %></td>
    <td><%=member.getJob() %></td>
    <td><%=member.getReason() %></td>
    <td><%=member.getGender() %></td>
    <td><%=member.getMailyn() %></td>
    <td><%=member.getHobby() %></td>
    <td><%=member.getRegdate() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>