package com.kh.model.vo;

import java.awt.print.Book;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class Rent {
	
	public int rentNo;
	public int rentMemNo;
	//public int rentBookno;
	public Book2 book;
	public Date rentDate;

}
