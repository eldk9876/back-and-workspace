package com.kh.bookCustomer;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.bookRent.Member;
import com.kh.model.BookModel;

import config.BookServerInfo;


public class MenuController extends Object {
	
	Properties p = new Properties();

	{

		try {
			p.load(new FileInputStream("src/config/mysql.properties"));

			Class.forName(BookServerInfo.DRIVER_NAME);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static MenuController instance;
	
	public static MenuController getInstance() {
		if(instance == null)instance = new MenuController();
		return instance;
		
	}
	
	public Connection connect() throws Exception {
		return DriverManager.getConnection(BookServerInfo.URL, BookServerInfo.USER, BookServerInfo.PASSWORD);
		
	}
	
	public void close(PreparedStatement ps,Connection conn ) throws Exception {
		ps.close();
		conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		rs.close();
		close(ps,conn);
	}
	
	public boolean bookCheck(String bktitle, String bkauthor) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("bookCheck"));
		ps.setString(1, bktitle);
		ps.setString(2, bkauthor);
		
		ResultSet rs = ps.executeQuery();

		if(rs.next()) return true;
		return false;
	
	}
	
	// 아이디 중복 체크용
	public boolean idCheck(String id) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("idCheck"));
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		String checkId = null;
		if(rs.next()) checkId = rs.getString("id");
		close(rs, ps, conn);
		
		
		if(checkId != null) return true;
		return false;
	}
	
	
//  book 삭제 등 선택용 메서드
		public BookModel SearchBook(int bkNo) throws Exception {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("SearchBook"));
			
			ps.setInt(1, bkNo);
			
			ResultSet rs = ps.executeQuery();
			
			BookModel bookmodel = null;
			
			if(rs.next()) {
				bookmodel = new BookModel(rs.getInt("bkNo"),rs.getString("bkTitle"),rs.getString("bk_author"),rs.getString("rent_date"));
			}
			close(rs, ps, conn);
			
			return bookmodel;

		}
	
	
	
	
	
	
	
	
	// 1. 전체 책 조회
		public ArrayList<BookModel> printBookAll() throws Exception {
		
			
				Connection	conn = connect();
				PreparedStatement ps = conn.prepareStatement(p.getProperty("printBookAll"));
				
				
				ResultSet rs = ps.executeQuery();
				ArrayList<BookModel>list = new ArrayList<>();
				
				while(rs.next()) {
					BookModel bookmodel = new BookModel();
					bookmodel.setBkNo(rs.getInt("bk_no"));
					bookmodel.setBkTitle(rs.getString("bk_title"));
					bookmodel.setBkAuthor(rs.getString("bk_author"));
					list.add(bookmodel);

					
				}
				close(rs, ps,conn);
				return list;
	
			
			// 반복문을 이용해서 책 리스트 출력
		}

		// 2. 책 등록
		public boolean registerBook(BookModel b) throws Exception {
		
				// 책 제목, 책 저자를 사용자한테 입력 받아
				// 기존 제목,저자 있으면 등록 안되게!
				// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
				// 실패하면 "책을 등록하는데 실패했습니다." 출력
				if(!bookCheck(b.getBkTitle(), b.getBkAuthor())) {
					Connection conn = connect();
					PreparedStatement ps = conn.prepareStatement(p.getProperty("registerBook"));
					ps.setString(1, b.getBkTitle());
					ps.setString(2, b.getBkAuthor());
					
					ps.executeUpdate();
					close(ps,conn);
					return true;
				}
				return false;
			 }

		// 3. 책 삭제
		public int sellBook(int bkNo) throws Exception {
			// printBookAll로 전체 책 조회를 한 후
			printBookAll();
			Connection conn = connect();
			
			BookModel bookmodel = SearchBook(bkNo);
			
			
			PreparedStatement ps = conn.prepareStatement(p.getProperty("sellBook"));
			
			ps.setInt(1, bkNo);
			ps.executeUpdate();
			
			
			close(ps,conn);
			return bkNo;
		
			
			// 삭제할 책 번호 선택을 사용자한테 입력 받아
			
			// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
			// 실패하면 "책을 삭제하는데 실패했습니다." 출력
		}
		
		
		
		

		// 4. 회원가입
		public boolean registerMember(Member m) throws Exception {
			// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
			// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
			// 실패하면 "회원가입에 실패했습니다." 출력
			if(!idCheck(m.getId())) {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("registerMember"));
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			
			ps.executeUpdate();
			close(ps,conn);
			return true;
		}
		return false;
			

		}

		// 5. 로그인
		public  String login(String id, String password) throws Exception {
			// 아이디, 비밀번호를 사용자한테 입력 받아 
			// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
			// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("login"));
			ps.setString(1, id);
			ps.setString(2, password);
			

			ResultSet rs = ps.executeQuery();
			String name = null;
			
			if(rs.next()) {
				name = rs.getString("name");
				close(rs, ps, conn);
			}
			return name;
		}
			
			
			
		
		
		//************************************************************************************
		
		// 1. 책 대여
		public void rentBook(BookModel b) throws Exception {
			
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("rentBook"));
			
			// printBookAll 메서드 호출하여 전체 책 조회 출력 후
			printBookAll();
			ps.setInt(1, b.getBkNo());
			// 대여할 책 번호 선택을 사용자한테 입력 받아
			// 이미 대여된 책은 대여 불가
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		}

		// 2. 내가 대여한 책 조회
		public void printRentBook() {
			// 내가 대여한 책들을 반복문을 이용하여 조회
			// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한(+14일) 조회
		}

		// 3. 대여 취소
		public void deleteRent() {
			// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
			// 취소할 대여 번호 선택을 사용자한테 입력 받아
			// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
			// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		}

		// 4. 회원탈퇴
		public void deleteMember() {
			// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
			// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
		}
	
	
	
	
	
	
	
	
}
