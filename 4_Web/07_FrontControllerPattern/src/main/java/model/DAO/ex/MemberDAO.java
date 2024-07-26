package model.DAO.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.vo.ex.MemberEx;



public class MemberDAO {
		public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		public static final String URL = "jdbc:mysql://localhost:3306/member";
		public static final String USER = "root";
		public static final String PASSWORD = "qwer1234";
	
		Properties p = new Properties();
		public void driver() {
			
			//1. 드라이빙 
			try {
				Class.forName(DRIVER_NAME);
				
			} catch (ClassNotFoundException e) {
							e.printStackTrace();
			}}
			
			
			//2. 서버 
			public Connection Connect() throws SQLException {
				return DriverManager.getConnection(URL, USER, PASSWORD);
			}
			
			// 자원 반납
			public void close(PreparedStatement ps, Connection conn) throws SQLException {
				ps.close();
				conn.close();
			}
			
			public void close(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException {
				rs.close();
				close(ps,conn);
			}
			
			//  DAO 개발할 때 중요한 건 
			// 메게변수(파라미터) 뭘 가지고 와야 되는지,리턴타입 결과 출력이 어떤게 필요한지
	
			// 회원가입
			public void register(String id,String pwd,String name ) throws SQLException {
				driver();
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				String query = "INSERT INTO member VALUES(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, id);
				ps.setString(2, pwd);
				ps.setString(3, name);
				
				ps.executeUpdate();
				
				close(ps,conn);
				
			}
			
			// 로그인
			public MemberEx login(String id, String password) throws SQLException {
				driver();
		
				
				Connection conn = Connect();
				String query = "SELECT * FROM member WHERE id = ? AND password =?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, id);
				ps.setString(2, password);
				

				ResultSet rs = ps.executeQuery();
				MemberEx member = null;
				
				if(rs.next()) {
					member = new MemberEx(id, password,rs.getString("name"));
					
				}
				close(rs, ps, conn);
				return member;
			}
			
			
			// 회원 검색
			public MemberEx search (String id) throws SQLException {
				driver();
				Connection conn = Connect();
				String query = "SELECT * FROM member WHERE id = ? ";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, id);
				
				ResultSet rs = ps.executeQuery();
				MemberEx member = null;
				
				if(rs.next()) {
					member = new MemberEx(id, rs.getString("password"),rs.getString("name"));
					
				}
			
				close(rs,ps,conn);
				return member;
			
			}
				// 전체 회원 보기 
			
				public List<MemberEx> all() throws SQLException {
				driver();
				Connection conn = Connect();
				String query = "SELECT * FROM member ";
				PreparedStatement ps = conn.prepareStatement(query);
					
				ResultSet rs = ps.executeQuery();
					
				List<MemberEx> memberlist = new ArrayList<>();
					 
				while(rs.next()) {
				memberlist.add(new MemberEx(rs.getString("id"),
											rs.getString("password"),
											rs.getString("name")));
						
					}
					close(rs,ps,conn);
					return memberlist;
					
					
				}


			
				
				

		



			}
