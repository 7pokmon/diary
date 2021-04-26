<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>todoOne수정</h1>
	
	<form action="${pageContext.request.contextPath}/auth/modifyTodo" method="post">
		<div>
			<input type="hidden" name="todoNo" value="${todoOne.todoNo}">
		</div>
		<div>
			todoTitle : <input type="text" value="${todoOne.todoTitle}" name="todoTitle">
		</div>
		<div>
			todoContent : <textarea rows="5" cols="80" name ="todoContent"> ${todoOne.todoContent}</textarea>
		</div>
		<div>
			todoFontColor: <input type="color" name="todoFontColor" value="${todoOne.todoFontColor}">
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
</body>
</html>