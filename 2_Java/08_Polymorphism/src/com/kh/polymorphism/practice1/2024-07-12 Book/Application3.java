package com.kh.polymorphism.practice1;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.polymorphism.practice1.model.Book;
import com.kh.polymorphism.practice1.model.Member;

public class Application3 {
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	Book[] books = {new Book("밥을 지어요", true,0), 
					new Book("오늘은 아무래도 덮밥", false,0),
					new Book("원피스 108", false, 15),
					new Book("귀멸의 칼날 23",false,19)};
	
	public static void main(String[] args) {
	
		Application3 app = new Application3();
		app.menu();
		
		
		
	}
	
	public void menu() {
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		
		try {
		System.out.println("나이 : ");
		int age = Integer.parseInt((sc.nextLine()));
		member.setAge(age);
		}catch(NumberFormatException e){
			System.out.println("잘못눌렀습니다. 다시 눌러 주세요");

			System.out.println("나이 : ");
			int age = Integer.parseInt((sc.nextLine()));
			member.setAge(age);
			
		}
		while(true) {
			
			System.out.println("======= 메 뉴 ======== ");
			System.out.println("1. 마이페이지 ");
			System.out.println("2. 도서 대여하기 ");
			System.out.println("3. 프로그램 종료하기 ");
			try {
			System.out.println("메뉴 번호 : ");
			int number = Integer.parseInt((sc.nextLine()));
			
			if (number == 1) {
				
				System.out.println(member);
				
			}
			else if(number == 3) {
				System.out.println("종료합니다");
				break;
			}
			
			
			else if(number == 2){
				for(int i = 0; i < books.length; i++) {
					System.out.println((i+1) +"번 도서 : " + books[i]);

				}		
					System.out.println("대여할 도서 번호 선택 : ");
					int select = Integer.parseInt(sc.nextLine());
				
				// select(index+1) 번호에 따라서 해당 책이 Member - bookList에 추가
			
				
					if(member.getBookList()[0]!=null && books[0].getTitle() == member.getBookList()[0].getTitle() ) { // 타이틀이 같을때
						System.out.println("이미 대여한 책입니다");
							
					}
					
					
					
					else if(member.getBookList()[0]!=null && member.getBookList()[0]!=null ) {
						System.out.println("더 이상 대여할 수 없습니다 ");
						} 
					
					else if(member.getBookList()[0]!=null && member.getBookList()[1]!=null &&books[1].getTitle() == member.getBookList()[1].getTitle() ) { // 타이틀이 같을때
						System.out.println("이미 대여한 책입니다");
					}
					

					else if(member.getBookList()[0]==null && member.getBookList()[1]==null) {
					member.getBookList()[0] = books[select-1];
					System.out.println("성공적으로 대여되었습니다");
					
					
				}
				
				else if(member.getAge() <= books[select-1].getAccessAge()) { // 나이 이하 금지
					member.getBookList()[0] = books[select-1];
					System.out.println("나이 제한으로 불가능입니다");
			
				}
				else if(member.getBookList()[0] != null && member.getBookList()[1] == null) {
					member.getBookList()[1] = books[select-1];
					System.out.println("성공적으로 대여되었습니다");
				}	
				
				
				
				

				
				
				
				
					
			
				
				
				}
			
			
			
				}
			
				catch(NumberFormatException e) {
					System.out.println("잘못 눌렀습니다 다시 찾아주세요");
				}
				
				

				
				
				
			}
			
		}

	}
	
	
	
	

