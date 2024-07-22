package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book2;

public class BookController2 {

	private BookDAO book = new BookDAO();
	private RentDAO rent = new RentDAO();
	
	// 1. 전체 책 조회
	
	public ArrayList<Book2> printBookAll(){
		try {
			return book.printBookAll();
			
		} catch (Exception e) {
			return null;
		}
		
	}

	public boolean registerBook(String bkTitle, String bkAuthor) {
		// 기존 제목,저자 있으면 등록 안되게
		try {
			if(!book.checkBook(bkTitle, bkAuthor)) {
				// 책 등록!
				book.registerBook(bkTitle, bkAuthor);
				return true;
				
			}
		} catch (Exception e) {
			
		}
		
		return false;
	
	}
	
	// 3. 책 삭제
	public boolean sellBook(int no) {
		// 빌려있는 책 삭제 못하게!
		try {
			if(rent.checkRentBook(no)) {
				return false;
			}
			
			// 없는 번호 삭제하려고 하면 실패가 떠야지 정상!
			// --> 기존 책들 중에 해당 no가 없는 경우!
			// --> 기존 책들 중에 해당 no가 있는 경우만 삭제
			for(Book2 b : book.printBookAll()) {
				if(b.getBkNo()==no) {
					book.sellBook(no);
					return true;
				}
			}
			
			
			book.sellBook(no);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
}
