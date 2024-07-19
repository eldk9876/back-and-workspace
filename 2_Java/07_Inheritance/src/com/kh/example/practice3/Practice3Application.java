package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.controller.Practice3EmployeeController;
import com.kh.example.practice3.model.Employee;
import com.kh.example.practice3.model.Practice3Employee;
// import com.kh.inheritance.child.SmertPhone;

public class Practice3Application {
	
	Scanner sc = new Scanner(System.in);
	Practice3Employee viewEmployee = new Practice3Employee();
	Practice3EmployeeController employeeController = new Practice3EmployeeController();
	
	public static void main(String[] args) {
		
		Practice3Application app = new Practice3Application();
		
		
		while(true) {
		 int select = app.employeeMenu();
		 switch(select) {
		 case 1:
			 app.insertEmp();
			 break;
		 case 2:
			 app.updateEmp();
			 break;
		 case 3:
			 app.printEmp();
			 break;
		 case 9:
			 System.out.println("프로그램을 종료합니다");
			 boolean check = false;
			 break;
		 default:
			 System.out.println("잘못입력하셨습니다. 다시 입력해주세요 ~");
		 
		 
		}}
		
	//	a.printEmp();
		//a.insertEmp();
		
	}
	
	
	// 메인 메뉴를 출력하는 메서드
	public int employeeMenu() {
		System.out.print("1.사원 정보 추가 \n2. 사원 정보 수정 \n3. 사원 정보 출력 \n9.프로그램 종료");
		System.out.println("\n메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {
		System.out.println("사원 번호 : ");
		 int empNo = Integer.parseInt(sc.nextLine());
		viewEmployee.setEmpNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 이름 : ");
		String Name = sc.nextLine();
		viewEmployee.setName = sc.nextLine();
		System.out.println("사원 성별 : ");
		char Gender = sc.nextLine().charAt(0);
		viewEmployee.setGender = sc.nextLine().charAt(0);
		System.out.println("전화 번호 : ");
		String Phone = sc.nextLine();
		viewEmployee.setPhone = sc.nextLine();
		System.out.println("\n추가정보를 더 입력하시겠습니까?(y/n) : ");
		char add = sc.nextLine().charAt(0);
		// 사원 정보의 추가 정보
		if(add == 'y') {
			System.out.println("사원 부서 : ");
			String Dept = sc.nextLine();
			
			System.out.println("사원 연봉 : ");
			int Salary = Integer.parseInt(sc.nextLine());
			
			System.out.println("보너스 율 : ");
			double Bonus = Double.parseDouble(sc.nextLine());
			
			employeeController.add(viewEmployee.getEmpNo(), viewEmployee.getName(), viewEmployee.getGender(), viewEmployee.getPhone(), Dept, Salary, Bonus);
		
		}else {employeeController.add(viewEmployee.getEmpNo(), viewEmployee.getName(), viewEmployee.getGender(), viewEmployee.getPhone());}
		
		
		
	}
	
	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("\n사원의 어떤 정보를 추가하시겠습까?");
		System.out.print("1.전화 번호 \n2. 사원 연봉 \n3. 보너스 율 \n9.돌아가기");
		System.out.println("\n메뉴 번호를 누르세요 : ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		 case 1:
			 System.out.println("전화 번호 : ");
				String Phone = sc.nextLine();
				employeeController.modify(Phone);
			 break;
		 case 2:
			 System.out.println("사원 연봉 : ");
				int Salary = Integer.parseInt(sc.nextLine());
				employeeController.modify(Salary);
			 break;
		 case 3:
			 System.out.println("보너스 율 : ");
				double Bonus = Double.parseDouble(sc.nextLine());
				employeeController.modify(Bonus);
			 break;
		 case 9:
			 break;


		}	
		
	}
	// 데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println(employeeController.info());
		
			}	
		}


