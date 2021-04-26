<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>diary</title>
</head>
<body>
	<div>${diaryMap.todoList}</div>
	
	
	
	<!-- 전체 셀 -->
	<c:set var="totalCell" value="${diaryMap.startBlank + diaryMap.endDay + diaryMap.endBlank}"></c:set>
	<div>totalCell : ${totalCell}</div>
	<!-- 달력넘기기 -->
	<h1>
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">이전달</a>
		${diaryMap.targetYear}년 ${diaryMap.targetMonth+1}월
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">다음달</a>
	</h1>
	<!-- 달력출력 -->
	<table border="1" width="90%">
		<tr>
			<c:forEach var="i" begin="1" end="${totalCell}" step="1">
				<!-- 날짜값만 출력하게 변경 (음수면 빈칸,마지막날넘어가면 빈칸)-->
				<c:set var="num" value="${i-diaryMap.startBlank}"></c:set>
				<td>
					<!-- 날짜출력 / 다이어리 입력 링크 -->
					<c:if test="${num > 0 && num <= diaryMap.endDay}">
						<a href="${pageContext.request.contextPath}/auth/addTodo?year=${diaryMap.targetYear}&month=${diaryMap.targetMonth+1}&day=${num}">
							${num}</a>
							<c:forEach var="todo" items="${diaryMap.todoList}">	
								<c:if test="${todo.todoDate == num}">
									<div style="background-color: ${todo.todoFontColor}">
                                    	<a href="${pageContext.request.contextPath}/auth/todoOne">${todo.todoTitle}</a>
                                    </div>
								</c:if>
							</c:forEach>
					</c:if>
					<!-- 빈칸출력 -->
					<c:if test="${num <= 0 || num > diaryMap.endDay}">
						&nbsp;
					</c:if>
				</td>
				<c:if test="${i%7==0}">
					</tr><tr>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>