package com.kh.polymorphism.practice1;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.polymorphism.practice1.model.Book2;
import com.kh.polymorphism.practice1.model.BookController2;

public class Application5 {
	Scanner sc = new Scanner(System.in);
	BookController2 bc = new BookController2();

	
	Book2[] books2 = {new Book2("밥을 지어요", true,0), 
					new Book2("오늘은 아무래도 덮밥", false,0),
					new Book2("원피스 108", false, 15),
					new Book2("귀멸의 칼날 23",false,19)};
	
	boolean close = true;
	
	public static void main(String[] args) {
	
		Application3 app = new Application3();
		app.menu();
		
		
		
	}
	
	public void menu() {
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		
		try {
		System.out.println("나이 : ");
		int age = Integer.parseInt((sc.nextLine()));
		
		bc.addMember(name,age);
		
		}catch(NumberFormatException e){
			System.out.println("잘못눌렀습니다. 다시 눌러 주세요");
			
			System.out.println("나이 : ");
			int age = Integer.parseInt((sc.nextLine()));

			bc.addMember(name,age);
		}
		while(true) {
			
			System.out.println("======= 메 뉴 ======== ");
			System.out.println("1. 마이페이지 ");
			System.out.println("2. 도서 대여하기 ");
			System.out.println("3. 프로그램 종료하기 ");
			try {
			System.out.println("메뉴 번호 : ");
			switch(Integer.parseInt((sc.nextLine()))){
				
			case 1:
				System.out.println(bc.myPage());
				break;
			case 2:
				for(int i = 0; i < books2.length; i++) {
					System.out.println((i+1) +"번 도서 : " + books2[i]);

				}		
					System.out.println("대여할 도서 번호 선택 : ");
					int select = Integer.parseInt(sc.nextLine());
					bc.rentBook(books2[select-1]);
					break;
			case 3:
				close = false;
				
			}
			
				}
			
				catch(NumberFormatException e) {
					System.out.println("잘못 눌렀습니다 다시 찾아주세요");
				}
				
			}
			
		}

	}
	
	
	
	

