package gdu.diary.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;


@WebServlet("/auth/todoOne")
public class TodoOneController extends HttpServlet {
	private TodoService todoService;
	// 일정 상세보기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수집
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		// 서비스 호출
		this.todoService = new TodoService();
		Todo todoOne = new Todo();
		todoOne = this.todoService.todoOneList(todoNo);
		
		// request데이터 넣기
		request.setAttribute("todoOne", todoOne);
		// view
		request.getRequestDispatcher("/WEB-INF/view/auth/todoOne.jsp").forward(request, response);
	}
}
