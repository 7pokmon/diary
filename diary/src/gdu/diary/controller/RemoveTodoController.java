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
		// memberNo 세션에서 가져오기
		HttpSession session = request.getSession();
		int memberNo = ((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		this.todoService = new TodoService();
		// 서비스 호출
		this.todoService.removeTodoOne(memberNo);
		System.out.println("todoOne 삭제성공");
		// 삭제후 diary이동
		response.sendRedirect(request.getContextPath()+"/auth/diary");
	}
}
