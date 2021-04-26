package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;


@WebServlet("/auth/removeTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수집
		String todoDate = request.getParameter("todoDate");
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		
		// 서비스 호출
		this.todoService = new TodoService();
		this.todoService.removeTodoOne(todoNo);
		System.out.println("todoOne 삭제성공");
		
		// 삭제한 일정 달의 달력으로 돌아가기
		String[] arr = todoDate.split("-");
		response.sendRedirect(request.getContextPath() + "/auth/diary?targetYear="+arr[0]+"&targetMonth="+(Integer.parseInt(arr[1])-1));
	}
}
