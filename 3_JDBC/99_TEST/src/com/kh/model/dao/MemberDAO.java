package com.kh.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.model.vo.Member2;

import config.BookServerInfo2;

public class MemberDAO {
	
	Properties p = new Properties();

	{

		try {
			p.load(new FileInputStream("src/config/mysql2.properties"));

			Class.forName(BookServerInfo2.DRIVER_NAME);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static BookDAO instance;
	
	public static BookDAO getInstance() {
		if(instance == null)instance = new BookDAO();
		return instance;
		
	}
	
	public Connection connect() throws Exception {
		return DriverManager.getConnection(BookServerInfo2.URL, BookServerInfo2.USER, BookServerInfo2.PASSWORD);
		
	}
	
	public void close(PreparedStatement ps,Connection conn ) throws Exception {
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		rs.close();
		close(ps,conn);
	}
	
	
	//4. 회원가입
	public void registerMember(String id,String password,String name) throws Exception {
		
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("registerMember"));
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeQuery();
		close(ps,conn);
		
	}
	
	public Member2 login(String id,String password) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		Member2 member = null;
		member = new Member2();
		if(rs.next()) {
			
			member.setMemberId(id);
			member.setMemberPwd(password);
			member.setMemberName(rs.getString("member_name"));
			member.setMemberNo(rs.getInt("member_no")); // 대여에 사용 가능성
			member.setStatus(rs.getString("status").charAt(0));// 탈퇴에 사용 가능성
			

		}
		
		close(rs,ps,conn);
		
		return member;
	}
	
	// 5. 회원 탈퇴
			public int deleteMember(int memberNo) throws Exception {
				Connection conn = connect();
				PreparedStatement ps = conn.prepareStatement(p.getProperty("deleteMember"));
				
				ps.setInt(1, memberNo);
				int result = ps.executeUpdate();
				close(ps,conn);
				
				
				return result;
				
				
			}
	
	
	
}
