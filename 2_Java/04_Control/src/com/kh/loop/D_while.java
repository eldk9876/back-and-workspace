package com.kh.loop;

import java.util.Scanner;

public class D_while {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * 
	 * While문
	 * 
	 * while(조건식)
	 * 		조건이 true일때 계속 실행
	 * 
	 * 
	 * 
	 * */
	// 1 ~ 5까지 출력 : for -> while // 숫자나 index 문제에는 for문이 좋음
	public void method1() {
		for(int i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println();
		
		int i = 1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
		
	}
	
	/*
	 * 무한루프 & break 문
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다. 
	 * 
	 * 
	 * */
	
	public void method2() {
		while(true) {
			System.out.println("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
		}
		
		
	}
	
	/*
	 * 거의 쓰지 않음
	 * do  {
	 * 		실행코드
	 * }	while(조건식);
	 * 
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * - 거의 쓸일이 없음...
	 * 
	 * 
	 * */
	
	public void method3() {
		int number =1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		}while(number ==0);
		
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값을 입력해서 임의로 지정한 (Random)값을 맞히면 게임 끝!
	 * 게임이 끝나면 몇 번만에 맞혔는지 출력!
	 * 
	 * (예 : 57)
	 * 1과 100 사이의 값 입력 > 35
	 * 더 큰 수를 입력하세요
	 * 1과 100 사이의 값 입력 > 70
	 * 더 작은 수를 입력하세요
	 * 1과 100 사이의 값 입력 > 57
	 * 3번 만에 맞혔습니다.
	 * 
	 * */
	
	public void method4() {
		
		int random = (int)(Math.random() * 100 +1);
		int num2 = 0;
		while(true) {
		System.out.println("1과 100 사이의 값 입력 > ");
		int num = sc.nextInt();
			num2 ++;
		if(1 <= num && num <=100 && random < num) {
			System.out.println("더 작은 수를 입력하세요");	
		}
		else if(1 <= num && num <=100 && random > num) {
			System.out.println("더 큰 수를 입력하세요");
		}
		else if(1 <= num && num <=100 && random == num) {
			System.out.printf("%d번 만에 맞혔습니다", num2  );
			break;
		}
		}
		}
	
			
		/*
		
		 int random = (int)(Math.random() * 100 +1);
			 // System.out.println(random);
			  int num = 0;
			  int count = 0;
			  while(random != num){
			  	count ++;
			  	System.out.print("1과 100 사이의 값 입력 > ");
			  num = sc.nextInt();
			 if(random > num){
			 	System.out.println(" 더 큰 수를 입력하세요 ");
			 }else if(random < num) {
			System.out.println("더 작은 수를 입력하세요");
			 }
			 }
			 System.out.println( count + "번 만에 맞혔습니다");
	}
		*/
		
		/*
		int aa = (int)random; // 1 ~ 10까지의 랜덤값
		int sum = 0;
	
		for (int i = 1; i <= aa; i++) {
			sum += i;*/			
	
	
	/*
	 * ---------------------------------
	 * 1. 예금 | 2.출금 | 3.잔고 | 4.종료
	 * ---------------------------------
	 * 선택 >1
	 * 예금액 > 5000
	 * ---------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------
	 * 선택 > 2
	 * 출금액 > 2000
	 * ---------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------
	 * 선택 > 3
	 * 잔고 > 3000
	 * ---------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ---------------------------------
	 * 선택 > 4
	 * 프로그램 종료
	 * 
	 * */

	public void method5() {
		System.out.println("선택 : ");
		int num1 = sc.nextInt();
		
		for(int i =0; i <=1; i++) {
			System.out.println("------------------------------------------");
			
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			switch(num1) {
			case 1 :
				System.out.printf("선택 >1 \n예금액 :");
				
			break;
			case 2 :
				System.out.println("선택 >2\n 출금액 2000");
			break;
			case 3 :
				System.out.println("선택 >3\n 잔고 3000");
			break;
			case 4 :
				System.out.println("선택 >4\n 프로그램 종료");
			break;
			}
			
			System.out.println("------------------------------------- ");
			}

			
		
	
		
	}

	/*int balance = 0;
	 * boolean check = true;
	 * 
	 * while(check){
	 * System.out.println("---------------------------------------- ");
	 * System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
	 * System.out.println("---------------------------------------- ");
	 * System.out.print("선택");
	 * int select = sc.nextInt();
	 * 
	 * if(select == 1) {
	 * 		System.out.print("예금액 >");
	 * 		balance += sc.nextInt();
	 * 
	 * }else if(select == 2){
	 * 		System.out.print("출금액 >");
	 * 		balance += sc.nextInt();
	 * }else if(select == 3){
	 * 		System.out.print("잔고 >" + balance);
	 * 
	 * }else if(select == 4){
	 * 		System.out.print("프로그램 종료");
	 * 
	 * */
	
	
	/*
	 * switch(select){
	 * 		case 1 :
				System.out.print("예금액 >");
	 * 		balance += sc.nextInt();
			break;
			case 2 :
				System.out.print("출금액 >");
	 * 		int ex = sc.nextInt();
	 * 		if(ex > balance)System.out.print("잔고가 부족합니다 ㅠㅠ");
	 * 		else balance -= ex
			break;
			case 3 :
				System.out.print("잔고 >" + balance);
			break;
			case 4 :
				System.out.print("프로그램 종료");
				check = false;
			break;
	 * }
	 * 	//if (select == 4) break;
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		D_while d = new D_while();
		//d.method1();
		//d.method2();
		//d.method3();
		//d.method4();
		d.method5();
		
	}

}
