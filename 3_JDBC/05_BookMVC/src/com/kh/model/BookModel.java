package com.kh.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class BookModel {

	
	// 도서 용
	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private String rentDate;
	
	
	

	
}
