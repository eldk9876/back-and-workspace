package com.kh.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;


import com.kh.model.vo.Book2;
import com.kh.model.vo.Publisher;

import config.BookServerInfo2;

/*
 * DAO(Data Access Object)
 * - DB에 접근하는 역할을 하는 객체(CRUD)
 * */

public class BookDAO {

	public BookDAO() {
		
	}
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
	
	
	
	
	
	// 1. 전체 책 조회
	public ArrayList<Book2> printBookAll() throws Exception{
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("bookCheck"));
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Book2> list = new ArrayList<>();
		
		while(rs.next()) {
			Book2 book = new Book2();
			book.setBkNo(rs.getInt("bk_no"));
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
						
			Publisher publisher = new Publisher();		
			publisher.setPubName(rs.getString("pub_name"));		
			book.setPublisher(publisher);
						
			list.add(book);
		}
		
		close(rs, ps, conn);
		return list;
	}
	
	// 책 확인 여부(title, author)
	public boolean checkBook(String title, String author) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("checkBook"));
		
		ps.setString(1, title);
		ps.setString(2, author);
		ResultSet rs = ps.executeQuery();
		
		boolean check = rs.next();
		close(rs, ps, conn);
		return check;
		
		
	}
	
	// 2. 책 등록
	public void registerBook(String title, String author) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("registerBook"));
		
		ps.setString(1, title);
		ps.setString(2, author);
		ps.executeQuery();
		close(ps, conn);
		
		
		
	}
	
	// 3. 책 삭제
	public void sellBook(int no) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("sellbook"));
		ps.setInt(1, no);
		
		ps.executeUpdate();
		close(ps, conn);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
