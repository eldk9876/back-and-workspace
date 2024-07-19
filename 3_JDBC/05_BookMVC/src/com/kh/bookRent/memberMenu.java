package com.kh.bookRent;

import java.sql.Connection;
import java.sql.DriverManager;

import config.BookServerInfo;

public class memberMenu {
	
	
	
	
	{

	try {
		Class.forName(BookServerInfo.DRIVER_NAME);
		
		Connection conn = DriverManager.getConnection(BookServerInfo.URL, BookServerInfo.USER, BookServerInfo.PASSWORD);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	
	
	
	
	
	
}
