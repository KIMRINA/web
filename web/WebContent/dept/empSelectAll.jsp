<%@page import="dept.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empSelectAll.jsp</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<table border=1 id="emps">
<thead>
  <tr>
    <th>employeeId</th>
    <th>firstName</th>
    <th>lastName</th>
    <th>email</th>
    <th>hireDate</th>
    <th>department_id</th>
    <th>jobId</th>
    <th>manager_id</th>
  </tr>
</thead>
  <tbody>
  <c:forEach items="${list}" var="employees">

  <tr>
    <td><a href="memberSelect.jsp">${employees.getEmployee_id()}</a></td>
    <td>${employees.getFirst_name()}</td>
    <td>${employees.getLast_name()}</td>
    <td>${employees.getEmail()}</td>
    <td>${employees.getHire_date()}</td>
    <td>${employees.getDepartment_id()}</td>
    <td>${employees.getJob_id()}</td>
    <td>${employees.getManager_id()}</td>
  </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>