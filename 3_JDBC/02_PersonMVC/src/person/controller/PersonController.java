package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import person.model.Person;

public class PersonController {
	Scanner sc = new Scanner(System.in);

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/sample";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	
	
	
		// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경가능
		// 메서드 추가 가능! <-- 추천
	
		/*
		 * 1. 드라이버 로딩
		 * 
		 * 2. DB 연결
		 * 
		 * 3. PreparedStatement - 쿼리
		 * 
		 * 4. 쿼리 실행
		 * 
		 * */
		//1. 드라이버 로딩
			
	
		//?????????????
		public PersonController() {
			 try {
				 // 1.드라이버 로딩
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		// 고정적인 반복 -- DB 연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용!
		
		// 2. DB 연결
		public Connection getConnect() throws SQLException {
		return 	DriverManager.getConnection("jdbc:mysql://localhost:3306/sample");
		}
		
		// 5. 자원반납
		public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
			ps.close();
			conn.close();
}
		public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn) throws SQLException {
			rs.close();
			closeAll(ps, conn);
		}
		
		
			// 변동적인 반복 -- 비즈니스 로직 DAO(Datavase Access Object)
			
		// person 테이블에 데이터 추가 - INSERT
		public int addPerson(String name, int age, String addr) {
			
			
			try {
				Class.forName(DRIVER_NAME);
				
				Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				
			/*	String query = "INSERT INTO Person(id, name, age, addr) VALUES(?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				
				ps.setInt(1, 1);
				ps.setString(2, "유영민");
				ps.setInt(3, 10);
				ps.setString(4, "강남");
				*/
				
				
				//강사님 코드* 
				String query = "INSERT INTO Person(name, age, addr) VALUES(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, name);
				ps.setInt(2, age);
				ps.setString(3, addr);
				//4. 쿼리 실행
			int result = ps.executeUpdate();
				
			
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
			
			
		}
		
		// person 테이블에 데이터 수정 - UPDATE
		public String updatePerson(Person person) throws SQLException {
		
			// 강사님
			Connection conn = getConnect();
			
			String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?  ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, person.getName());
			ps.setInt(1, person.getAge());
			ps.setString(1, person.getAddr());
			ps.setInt(1, person.getId());
			
			String name = null;
			if(ps.executeUpdate()==1) {
			return person.getName();
			}
			
			
			closeAll(ps, conn);
			return name;
		}
		/*	try {
				Class.forName(DRIVER_NAME);
				
				Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				
				String query = "UPDATE person SET name = ?, age = ?, addr = ? WHERE id = ?  ";
				PreparedStatement ps = conn.prepareStatement(query);
				
			while(true) {	
				System.out.println("데이터 수정 : ");
				System.out.printf("수정할 번호 : \n수정할 이름 : \n수정할 나이 : \n수정할 주소 :");

				int selact = Integer.parseInt(sc.nextLine());
				switch (selact) {

				case 4:
				System.out.println("수정할 번호를 입력해주세요");
				int number = Integer.parseInt(sc.nextLine());
				ps.setInt(5, number);
				ps.executeUpdate();
				break;
		
				case 1:
				System.out.println("수정할 이름을 입력해주세요");
				String name = sc.nextLine();
				ps.setString(2, name);
				ps.executeUpdate();
				break;
				
				case 2:
				System.out.println("수정할 나이를 입력해주세요");
				int age = Integer.parseInt(sc.nextLine());
				ps.setInt(3, age);
				ps.executeUpdate();
				break;
				
				case 3:
				System.out.println("수정할 주소를 입력해주세요");
				String addr = sc.nextLine();
				ps.setString(4, addr);
				ps.executeUpdate();
				break;
				
				case 6:
				System.out.println("전체 데이터 수정 : ");
				
				System.out.println("수정할 ID를 입력해주세요");
				int id2 = Integer.parseInt(sc.nextLine());
				ps.setInt(1, id2);
				System.out.println("수정할 이름을 입력해주세요");
				String name2 = sc.nextLine();
				ps.setString(2, name2);
				System.out.println("수정할 나이를 입력해주세요");
				int age2 = Integer.parseInt(sc.nextLine());
				ps.setInt(3, age2);
				System.out.println("수정할 주소를 입력해주세요");
				String addr2 = sc.nextLine();
				ps.setString(4, addr2);
				ps.executeUpdate();
				break;
				
				default:
				System.out.println("잘못 선택했습니다");
				
			}} }catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}*/
		
		// person 테이블에 데이터 삭제 - DELETE
		public String removePerson(int id) throws SQLException {
			
			// 강사님 코드
			Connection conn = getConnect();
			
			Person person = searchPerson(id);
			String name = null;
			
			String query = "DELETE FROM person WHERE DATA = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			if(ps.executeUpdate() == 1) {
				name = person.getName();
			}

			closeAll(ps,conn);
			
			return name;
			
			/*
			try {
				Class.forName(DRIVER_NAME);
				
				Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				
				String query = "DELETE FROM person WHERE DATA = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				System.out.println("삭제할 번호를 입력해주세요");
				int selact = Integer.parseInt(sc.nextLine());
				ps.setInt(1, selact);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
		}
		
		// person 테이블에 있는 데이터 전체 보여주기 - SELECT
		public ArrayList<Person> searchAllPerson() throws SQLException {
			
			Connection conn = getConnect();
			String query = "SELECT * FROM person";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Person>list = new ArrayList<>();
			
		
			
			while(rs.next()) {
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setAddr(rs.getString("addr"));
				list.add(person);
				
			}
			return list;
			
			/*
			try {
				
				
				Class.forName(DRIVER_NAME);
				
				Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
				
				String query = "SELECT * FROM person";
				PreparedStatement ps = conn.prepareStatement(query);
				System.out.println(ps);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			
		}
		
		// person 테이블에서 데이터 한개만 가져오기 - SELECT
		public Person searchPerson(int id) throws SQLException {
			
			Connection conn = getConnect();
			
			String query = "SELECT * FROM person Where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Person person = null;
			
			if(rs.next()) {
			
				person = new Person(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("addr"));
				
				
			}
			
			closeAll(rs, ps, conn);
			
			return person;
			
			/*
			try {
				Class.forName(DRIVER_NAME);
				
				
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}*/
			
		}
	
	
	
}
