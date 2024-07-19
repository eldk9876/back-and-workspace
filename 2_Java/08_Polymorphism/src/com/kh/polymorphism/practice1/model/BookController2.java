package com.kh.polymorphism.practice1.model;

import java.util.ArrayList;

public class BookController2 extends Object {

	private Member2 member2 = new Member2();
	
	int count = 0;

	
	// 내 정보 추가
	public void addMember(String name, int age) {
		member2.setName(name);
		member2.setAge(age);
	}
	
	// 마이페이지
	public Member2 myPage() {
		return member2;
	}
	
	// 책 대여
	public String rentBook(Book book) {
		ArrayList<Book> bookList = member2.getBookList();
		// 이미 대여한 책은 대여 불가능하게 만들어야 하는 경우
		for(Book value : bookList) {
			if(value != null && value.equals(book)) {
				return "이미 대여한 책입니다.";
			}
	
		if(bookList.size() < 2) {
			if(member2.getAge() < book.getAccessAge()) {
					return "나이 제한으로 대여가 불가능합니다.";
				}
			
			// select(index+1) 번호에 따라서 해당 책이 Member - bookList에 추가
			bookList.add(book);
			// 쿠폰은 가지고 있는 경우
			if(book.isCoupon()) {
				member2.setCoupon(member2.getCoupon() + 1);
				
			}
			
			return "성공적으로 대여되었습니다";
			
			}
		return "더 이상 대여할 수 없습니다.";
		
	}
		return null;
		}
	
	
}