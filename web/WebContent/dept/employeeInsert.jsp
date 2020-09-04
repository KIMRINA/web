<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
	label { display: inline-block; width : 100px}
</style>
</head>
<body>
<%@include file="/common/header.jsp" %>
   <h1>사원등록</h1>
   <form action="empInsert" method="POST">  
    <div><label>employeeId</label> <input name="employeeId"></div>
    <div><label>firstName</label> <input name="firstName"></div>
    <div><label>lastName</label> <input name="lastName"></div>
    <div><label>email</label> <input name="email"></div>
    <div><label>hireDate</label> <input name="hireDate"></div>
    	
    <div><label>department_id</label> 
    	<c:forEach items="${deptId}" var="deptId">
    	<input type="radio"value="${deptId.department_id}" name="deptId">${deptId.department_name}
		</c:forEach></div>
    <div><label>jobId</label> <select name="jobId">
    	<option value="">선택
		<c:forEach items="${jobId}" var="jobId">
		<option value="${jobId.job_id}">${jobId.job_id}</option>
		</c:forEach>
    	  </select></div>
    <div><label>manager_id</label> <select name="managerId">
    	<option value="">선택
		<c:forEach items="${empId}" var="empId">
		<option value="${empId.employee_id}">${empId.first_name} ${empId.last_name}</option>
		</c:forEach>
    	       </select></div>
    <button>등록</button>
    </form>
</body>
</html>