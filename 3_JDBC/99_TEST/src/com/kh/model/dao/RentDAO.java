package com.kh.model.dao;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Book2;
import com.kh.model.vo.Rent;

import config.BookServerInfo2;

public class RentDAO {

	

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


	// 대여한 책이 있는지 조회
	public boolean checkRentBook(int no) throws Exception {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("checkRentBook"));
		ps.setInt(1, no);
		
		ResultSet rs = ps.executeQuery();
		boolean check = rs.next();
		
		close(rs, ps, conn);
		return check;
		
		
		
	}
	
	
	// 1. 책 대여
		public void rentBook(int memberNo, int bookNo) throws Exception {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("rentBook"));
			ps.setInt(1, memberNo);
			ps.setInt(2, bookNo);
			ps.executeUpdate();
			
			close(ps,conn);
			
			
			
		}
		// 2. 내가 대여한 책 조회
		public ArrayList<Rent> printRentBook(int memberNo) throws Exception {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(p.getProperty("printRentBook"));
			ps.setInt(1, memberNo);
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Rent> list = new ArrayList<>();
			while(rs.next()) {
				Rent rent = new Rent();
				rent.setRentNo(rs.getInt("rent_no"));
				rent.setRentDate(rs.getDate("rent_date"));
				Book2 book = new Book2();
				book.setBkTitle(rs.getString("bk_title"));
				book.setBkAuthor(rs.getString("bk_author"));
				rent.setBook(book);
				
				list.add(rent);
			}
			return list;

		}
			public int deleteRent (int no) throws Exception {
				Connection conn = connect();
				PreparedStatement ps = conn.prepareStatement(p.getProperty("deleteRent"));
				ps.setInt(1, no);
				
				int result = ps.executeUpdate();
				close(ps,conn);
				return result;
				
			}
			









	
}

	
