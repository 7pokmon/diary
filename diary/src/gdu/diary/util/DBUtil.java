package gdu.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/diary", "root", "java1004");
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// 1) fianlly 절을 구현하여 conn.close()를 하면 안되는 이유?
		// conn return해야하기떄문
		
		return conn;
	}
	// 2) 1)의 이유로 메서드 호출쪽에서 자원을 해제(close)해야하는데 편하게 해제가능하도록 메서드 제공
	public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		// 생성된 역순으로 해제
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		if(stmt != null) {
			try {
				stmt.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
