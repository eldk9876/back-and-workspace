package com.kh.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

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
}
