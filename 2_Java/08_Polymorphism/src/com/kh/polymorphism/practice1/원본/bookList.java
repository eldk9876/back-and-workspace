package com.kh.polymorphism.practice1.model;


public class bookList extends Object {
	Mypage mymy = new Mypage();
	StoreMenu stst = new StoreMenu();
	
	private bookList[] book = new bookList[2];
	public int count = 0;
	
	
	
	public bookList(Object bookList) {
		
	}

	public void bookMenu1(bookList b) {
		book[count++] = new bookList(b.getBookList());
	}
	
		public int checkBook(String bookList) {
			for(int i = 0; i < book.length; i++) {
				if(book[i]!=null && book[i].getBookList().equals(bookList)) {
					// 기존 배열에 책이 있는 경우!
					return i;
				}
			}
			// 책이 없는 경우
			return -1;
		}

		private Object getBookList() {
			// TODO Auto-generated method stub
			return null;
		}
	
	
	
	
	
	
	
	
	
	
/*	// 도서추가
		public void bookStoreMenu(bookList b) {
			book[count++] = new bookList(m.getName(), m.getAge(),b.couPon(),b.getbookList());
	
			public int checkId(String id) {
				for(int i = 0; i < book.length; i++) {
					if(book[i]!=null && book[i].getbookList().equals(id)) {
						// 기존 멤버 배열에 아이디가 있는 경우!
						return i;
					}
				}
				// 아이디가 없는 경우
				return -1;
			}
			
			*/
	
}
