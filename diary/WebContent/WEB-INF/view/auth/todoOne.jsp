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
			<td>${todoOne.todoTitle}</td>
		</tr>
		<tr>
			<td>todoContent : </td>
			<td>${todoOne.todoContent}</td>
		</tr>
		<tr>
			<td>todoAddDate : </td>
			<td>${todoOne.todoAddDate.substring(0,10)}</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${todoOne.todoNo}">수정</a>
	<a href="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${todoOne.todoNo}&todoDate=${todoOne.todoDate}">삭제</a>
</body>
</html>