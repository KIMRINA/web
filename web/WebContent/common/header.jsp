<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 여기서부터 로그인, 로그아웃 자바코드 --%>
<% String id = (String)session.getAttribute("id"); %>
<ul>
<%	if(id == null) { %>
	<li><a href="/web1/member/login.jsp">로그인</a>
<% } else { %>
	<li><%=id %>님 <a href="/web1/member/logout">로그아웃</a>
	<li><a href="/web1/member/memberUpdate">정보수정</a>
<% } %>
	<li><a href="/web1/dept/DeptInsertFormServ">부서등록폼</a>
	<li><a href="<%=application.getContextPath()%>/dept/deptSelectAll">부서전체조회</a>
	<li><a href="<%=application.getContextPath()%>/member/memberInsert.do">회원가입</a>
	<li><a href="<%=application.getContextPath()%>/member/memberSelectAll.do">회원전체조회</a>
	<li><a href="<%=application.getContextPath()%>/board/boardInsert.do">게시글등록</a>
	<li><a href="<%=application.getContextPath()%>/board/boardSelectAll.do">게시글전체조회</a>
</ul>