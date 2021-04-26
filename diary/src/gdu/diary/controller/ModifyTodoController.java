package gdu.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Todo;


@WebServlet("/auth/modifyTodo")
public class ModifyTodoController extends HttpServlet {
	private TodoService todoService;
	
	// 수정 form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수집
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		Todo todoOne = new Todo();
		// 서비스 호출
		this.todoService = new TodoService();
		todoOne = this.todoService.todoOneList(todoNo);
		// request저장
		request.setAttribute("todoOne", todoOne);
		// 수정폼으로
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyTodo.jsp").forward(request, response);
	}
	// 수정 action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정보 수집
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		String todoTitle = request.getParameter("todoTitle");
		String todoContent = request.getParameter("todoContent");
		String todoFontColor = request.getParameter("todoFontColor");
		
		// 데이터 저장
		Todo todo = new Todo();
		todo.setTodoNo(todoNo);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setTodoFontColor(todoFontColor);
		
		// 서비스 호출
		this.todoService = new TodoService();
		this.todoService.modifyTodoOne(todo);
		// 일정 상세정보로 이동
		response.sendRedirect(request.getContextPath()+"/auth/todoOne?todoNo=" + todoNo);
	}
}
