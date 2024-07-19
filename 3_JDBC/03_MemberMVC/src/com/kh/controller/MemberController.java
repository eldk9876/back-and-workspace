package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.config.MemberServerInfo;
import com.kh.model.Member;


public class MemberController {
		
	Properties p = new Properties();
	
	public MemberController() {
		
		try {
			Class.forName(MemberServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(MemberServerInfo.URL,MemberServerInfo.USER,MemberServerInfo.PASSWORD);

	}
	
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
}
	public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	public boolean idCheck(String id) throws SQLException { // 아이디 중복여부
		Connection conn = getConnect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("idCheck"));
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) checkId = rs.getString("id");
		closeAll(rs, ps, conn);
		
		
		if(checkId != null) return true; // 중복 되는게 없으면 생성
		return false;
	
	}
	
	public boolean signUp(Member m) throws Exception {

		// 회원가입 기능 구현! 
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가! 
		if(!idCheck(m.getId())) {
		Connection conn = getConnect();
		
		String query = "INSERT INTO member(id, passward, name) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, m.getId());
		ps.setString(2, m.getPassword());
		ps.setString(3, m.getName());

		ps.executeUpdate();
		closeAll(ps,conn);
		
		return true;
	}
		return false;
	}
		
	
	public Member login(String id, String password) throws SQLException {

		// 로그인 기능 구현! 
				// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
		
		Connection conn = getConnect();
		String query = "SELECT * FROM member Where id = ?,password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		Member name = null;
		
		if(rs.next()) {
		
			name = new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"));
			
			
		}
		
		closeAll(rs, ps, conn);
		
		return name;
		
		
		
		
	}
	
	public String changePassword(Member member) throws Exception {
		
		// 비밀번호 바꾸기 기능 구현!
				// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경
		
		Connection conn = getConnect();
		String query = "UPDATE member SET passward = ? WHERE id = ?  ";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, member.getPassword());
		ps.setString(2, member.getId());
		
		String name = null;
		if(ps.executeUpdate()==1) {
		return member.getPassword();
		
		
		
		}
		closeAll(ps, conn);
		return name;
	}
	
	public String changeName(Member member) throws Exception {

		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 
		
		Connection conn = getConnect();
		String query = "UPDATE member SET name = ? WHERE id = ?  ";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, member.getName());
		ps.setString(2, member.getId());
		
		String name = null;
		if(ps.executeUpdate()==1) {
		return member.getName();
		
		
		
		}
		closeAll(ps, conn);
		return name;
		
		
	
}
	






}









