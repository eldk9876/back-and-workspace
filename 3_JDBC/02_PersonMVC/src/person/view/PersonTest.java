package person.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import person.controller.PersonController;
import person.model.Person;

public class PersonTest {

	PersonController pc = new PersonController();
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		PersonTest pt = new PersonTest();
		
		// 이 부분은 테스트 용도로만 !
		
		// person 테이블에 데이터 추가
//		pt.addPerson("박세영", 5, "서울");
//		pt.addPerson("배영운", 6, "경기");
		pt.addPerson("이동호", 7, "서울");
	//	pt.updatePerson(new Person(1, "김진주", 8, "제주"));
	//	pt.removePerson(1);
		
		/*
		while(true) {

			System.out.println("메뉴를 선택하세요 : ");
			int selact = Integer.parseInt(sc.nextLine());
			
			switch (selact) {

			case 1:
				addPerson();	
				break;
			case 2:
				updatePerson();
				break;
			case 3:
				removePerson();
				break;
			case 4:
				searchAllPerson();
				break;
			case 5:
				searchPerson();
				break;
				
			default:
			System.out.println("잘못 선택하셨습니다");
			
			
			}
		}
		*/
	
		
	}
	
	// 각 Controller에 메서드들 연결하는 건 각 메서드들에서 구현
	
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) {
		// ~~님, 회원가입 완료!
		int result = pc.addPerson(name, age, addr);
		if(result == 1) {
		System.out.println(name + "님, 회원가입 완료!");
		}
		
	}
			
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(Person person) throws SQLException {
		// ~~님, 정보 수정 완료!
		String name = pc.updatePerson(person);
		if(name!=null)
		System.out.println(name + "님, 정보 수정 완료!");
		
	}
			
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id) throws SQLException {
		// ~~님, 회원 탈퇴!
		String name = pc.removePerson(id);
		if(name!=null) {
			System.out.println(name + "~~님, 회원 탈퇴!");
		}	
	}
			
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
		
	}
			
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson(int id) {
		Person p = new Person();
		System.out.println(p);
		
	}
	

	
}
