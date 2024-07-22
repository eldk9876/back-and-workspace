package com.kh;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.bookCustomer.MenuController;
import com.kh.bookRent.Member;
import com.kh.model.BookModel;

// 스키마 : sample
// 테이블 : member, book, publisher.rent

public class Application {

	private Scanner sc = new Scanner(System.in);
	// 로그인 했을 시 사용자 정보를 담는 객체! 
	private Member member = new Member();
	private MenuController mc = MenuController.getInstance();

	public static void main(String[] args) {

		Application app = new Application();
		app.mainMenu();
		
		

	}

	public void mainMenu() {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll() {
		// 반복문을 이용해서 책 리스트 출력
		try {
			ArrayList<BookModel> list = mc.printBookAll();
			for(BookModel b : list) {
				System.out.println(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	// 2. 책 등록
	public void registerBook()  {
		// 책 제목, 책 저자를 사용자한테 입력 받아
		try {
		System.out.print("책 제목 : ");
		String bkTitle = sc.nextLine();
		
		System.out.print("책 저자 : ");
		String bkAuthor = sc.nextLine();
		// 기존 제목,저자 있으면 등록 안되게!
		
		
		if(mc.registerBook(new BookModel())) {
			System.out.println("성공적으로 책을 등록하였습니다!");
			} else {
				System.out.println("등록된 책입니다 다시입력해주세요!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
	}

	// 3. 책 삭제
	public void sellBook() {
		// printBookAll로 전체 책 조회를 한 후
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		System.out.println("삭제할 책 번호를 입력해 주세요");
		int bkNo = Integer.parseInt(sc.nextLine());

	//	if(mc.sellBook(new BookModel(bkNo))) {
			
		}
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
	//}

	// 4. 회원가입
	public void registerMember() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		try {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();

		
			if(mc.registerMember(new Member(id,password,name))) {
				System.out.println("성공적으로 회원가입을 완료하였습니다!");
				} else {
					System.out.println("회원가입에 실패했습니다. 다시 시도해주세요!");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
	}

	// 5. 로그인
	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력 받아 
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
		try {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		String name;

			name = mc.login(id, password);

		if(name != null) {
			System.out.println(name + "님, 환영합니다");
			memberMenu();
		}else {
			System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해 주세요!");
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() {
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		
		//if() {
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
			
	//	}else {

		// 대여에 성공하면 "대여에 실패했습니다." 출력
	//	}
		
	
	}
	
	

	// 2. 내가 대여한 책 조회
	public void printRentBook() {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한(+14) 조회
	}

	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
	}

	// 4. 회원탈퇴
	public void deleteMember() {
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}

}
