package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;
// import com.kh.inheritance.child.SmertPhone;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	Employee viewEmployee = new Employee();
	EmployeeController employeeController = new EmployeeController();
	
	public static void main(String[] args) {
		
		Application a = new Application();
		a.printEmp();
		

		
	}
	
	/*public int employeeMenu() {
		
	}*/
	
	public void insertEmp() {
		

		
		/*
		viewEmployee.setEmpNo(1);
		viewEmployee.setName("사원 이름");
	//	viewEmployee.setGender("사원 성별");
		viewEmployee.setPhone("전화 번호");
		viewEmployee.setDept("사원 부서");
		viewEmployee.setSalary(3000000);
		viewEmployee.setBonus(0.5);
	*/
		System.out.println(viewEmployee);
	}
	public void updateEmp() {
		
		
	}
	
	public void printEmp() {
		Employee Employee = new Employee();
		while(true) {
		System.out.print("1.사원 정보 추가 \n2. 사원 정보 수정 \n3. 사원 정보 출력 \n9.프로그램 종료");
		
		System.out.println("\n메뉴 번호를 누르세요 : ");
		int manu = sc.nextInt();
		
		
		// 사원 정보의 출력
					 if(manu == 3) {
						System.out.println(Employee);
						sc.nextLine();
						
					}else if(manu == 9) {
						sc.nextLine();
						
					return ;
					}
		// 사원 정보 추가
					else if(manu == 1) {
		System.out.println("사원 번호 : ");
		int empNo = sc.nextInt();
		
		System.out.println("사원 이름 : ");
		String Name = sc.nextLine();
		
		sc.nextLine();
		
		System.out.println("사원 성별 : ");
		char Gender = sc.nextLine().charAt(0);
		
		System.out.println("전화 번호 : ");
		String Phone = sc.nextLine();
		
		
		
		System.out.println("\n추가정보를 더 입력하시겠습니까?(y/n) : ");
		String add = sc.nextLine();
		
		// 사원 정보의 추가 정보
		if(add.equals("y")||add.equals("Y")) {
			System.out.println("사원 부서 : ");
			String Dept = sc.nextLine();
			
			System.out.println("사원 연봉 : ");
			int Salary = sc.nextInt();
			
			System.out.println("보너스 율 : ");
			double Bonus = sc.nextDouble();
			sc.nextLine();
			 
			employeeController.add(empNo, Name, Gender, Phone, Dept, Salary, Bonus);
		}else  {
			employeeController.add(empNo, Name, Gender, Phone);
		}
		
		
		// 사원 정보 수정
		}else if(manu == 2){
			System.out.println("\n사원의 어떤 정보를 추가하시겠습까?");
			
			System.out.print("1.전화 번호 \n2. 사원 연봉 \n3. 보너스 율 \n9.돌아가기");
			
			System.out.println("\n메뉴 번호를 누르세요 : ");
			int manu2 = sc.nextInt();
			
			if(manu2 == 1) {
			System.out.println("전화 번호 : ");
			String setPhone = sc.nextLine();
			
			sc.nextLine();
			
			}else if(manu2 == 2) {
			System.out.println("사원 연봉 : ");
			int setSalary = sc.nextInt();
			
			
			}else if(manu2 == 3){
			System.out.println("보너스 율 : ");
			double setBonus = sc.nextDouble();
			
			} else if(manu2 == 9) {
				sc.nextLine();
			}	
			}	
		}
	}
		}

//}
