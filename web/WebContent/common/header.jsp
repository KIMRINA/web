<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%-- 여기서부터 로그인, 로그아웃 자바코드 --%>
<ul>
<c:if test="${sessionScope.id == null}">
	<li><a href="/web1/member/login.jsp">로그인</a>
</c:if>
<c:if test="${not empty sessionScope.id}">  <%-- ${sessionScope.id != null}와 같다 --%>
	<li>${sessionScope.id}님 <a href="/web1/member/logout">로그아웃</a>
	<li><a href="/web1/member/memberUpdate">정보수정</a>
</c:if>
	<li><a href="/web1/dept/deptInsert">부서등록폼</a>
	<li><a href="<%=application.getContextPath()%>/dept/deptSelectAll">부서전체조회</a>
	<li><a href="<%=application.getContextPath()%>/member/memberInsert.do">회원가입</a>
	<li><a href="<%=application.getContextPath()%>/member/memberSelectAll.do">회원전체조회</a>
	<li><a href="<%=application.getContextPath()%>/board/boardInsert.do">게시글등록</a>
	<li><a href="<%=application.getContextPath()%>/board/boardSelectAll.do">게시글전체조회</a>
	<li><a href="<%=application.getContextPath()%>/dept/empInsert">사원등록</a>
	<li><a href="<%=application.getContextPath()%>/dept/empSelectAll">사원전체조회</a>
</ul>