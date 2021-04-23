package gdu.diary.dao;

import java.sql.*;
import gdu.diary.util.DBUtil;

// 2. Dao -> Service
public class TodoDao {
	private DBUtil dbUtil;
	
	// 계정삭제(트랜잭션)
	public int deleteTodoByMember(Connection conn, int memberNo) throws SQLException {
		this.dbUtil = new DBUtil();
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			System.out.println(stmt+"Todostmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
		System.out.println(rowCnt+"rowCnt");
		return rowCnt;
	}
}
