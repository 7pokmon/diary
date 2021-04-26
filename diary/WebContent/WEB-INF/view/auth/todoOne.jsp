<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoOne</title>
</head>
<body>
	<h1>todoOne</h1>
	<table>
		<tr>
			<td>todoTitle : </td>
			<td>${todo.todoTitle}</td>
		</tr>
		<tr>
			<td>todoContent : </td>
			<td>${todo.todoContent}</td>
		</tr>
		<tr>
			<td>todoAddDate : </td>
			<td>${todo.todoAddDate.substring(0,10)}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/auth/removeTodo">삭제</a>
</body>
</html>