package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;
import gdu.diary.vo.Member;

// 2. Dao -> Service
public class MemberDao {
	private DBUtil dbUtil;

	// 비밀번호 변경
	public void updateMemberPw(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(MemberQuery.UPDATE_MEMBER_PW);
			stmt.setString(1, member.getMemberPw());
			stmt.setInt(2, member.getMemberNo());
			System.out.println(stmt + "비밀번호변경");
			stmt.executeUpdate();

		} finally {
			this.dbUtil.close(null, stmt, null);
		}
	}

	// 회원가입 아이디 유효성검사 - 아이디가 있으면 checkMemberId를 리턴한다.
	public String checkMemberId(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String checkMemberId = null;

		try {
			stmt = conn.prepareStatement(MemberQuery.CHECK_MEMEBER_ID);
			stmt.setString(1, member.getMemberId());
			System.out.println(stmt + "유효성검사");
			rs = stmt.executeQuery();
			if (rs.next()) {
				checkMemberId = rs.getString("memberId");
			}

		} finally {
			this.dbUtil.close(null, stmt, rs);
		}
		return checkMemberId;
	}

	// 회원가입
	public void insertMember(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(MemberQuery.INSERT_MEMBER);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			System.out.println(stmt + "회원가입");
			stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}

	}

	// 계정삭제(트랜잭션)
	public int deleteMemberByKey(Connection conn, Member member) throws SQLException {
		this.dbUtil = new DBUtil();
		int rowCnt = 0;
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(MemberQuery.DELETE_MEMBER_BY_KEY);
			stmt.setInt(1, member.getMemberNo());
			stmt.setString(2, member.getMemberPw());
			System.out.println(stmt + "Memberstmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			this.dbUtil.close(null, stmt, null);
		}
		return rowCnt;
	}

	// 로그인
	public Member selectMemberByKey(Connection conn, Member member) throws SQLException {
		// 초기화
		this.dbUtil = new DBUtil();
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(MemberQuery.SELECT_MEMBER_BY_KEY); // 쿼리호출
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();

			if (rs.next()) {
				returnMember = new Member();
				returnMember.setMemberNo(rs.getInt("memberNo"));
				returnMember.setMemberId(rs.getString("memberId"));
			}

		} finally {
			this.dbUtil.close(null, stmt, rs);
		}

		return returnMember;
	}
}
