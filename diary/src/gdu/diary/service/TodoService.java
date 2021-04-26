package gdu.diary.service;

import java.sql.*;
import java.util.List;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

//3. Service -> Controller
public class TodoService {
	private DBUtil dbUtil;
	private TodoDao todoDao;
	
	// 일정 수정
	public int modifyTodoOne(Todo todo) {
		// 초기화
		int rowCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			this.todoDao.updateTodo(conn, todo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
	
	// 일정 삭제
	public int removeTodoOne(int todoNo) {
		// 초기화
		int rowCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			this.todoDao.deleteTodoOne(conn, todoNo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
	
	// 일정 상세보기
	public Todo todoOneList(int todoNo) {
		// 초기화
		Todo todo = null;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			todo = this.todoDao.selectTodoOne(conn, todoNo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return todo;
	}
	
	// 일정 추가
	public int addTodo(Todo todo) {
		// 초기화
		int rowCnt = 0;
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;
		
		try {
			conn = this.dbUtil.getConnection();
			this.todoDao.insertTodo(conn, todo);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
}
