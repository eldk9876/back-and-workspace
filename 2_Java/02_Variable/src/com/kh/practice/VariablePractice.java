package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		VariablePractice Variable = new VariablePractice();
	
				
		System.out.println("----------method1----------\n");
		Variable.method1();
		
		System.out.println("----------method2----------\n");
		Variable.method2();
		
		System.out.println("----------method3----------\n");
		Variable.method3();
		
		System.out.println("----------method4----------\n");
		Variable.method4();
		
		System.out.println("----------method5----------\n");
		Variable.method5();
		
		System.out.println("----------method6----------\n");
		Variable.method6();
		
		System.out.println("----------method7----------\n");
		Variable.method7();
		
		
		
		
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		
		
		
		int big = 10000;
		int smoll = 7000;

		
		System.out.println(" 성인 : " + big * 2);
		System.out.println(" 청소년 : " + smoll * 3);
		System.out.printf(" 성인 %d원 청소년 %d원 총 %d원 입니다. \n\n",(big * 2),(smoll *3),(big * 2 + smoll *3));


		
		
	}
	
	// 강사님 코드
	/*
	int adultPrice = 10000;
	int teenCount = 7000;
	int sum;
	int	asd;
	
	
	System.out.println(" 성인 : " + big * 2);
	System.out.println(" 청소년 : " + smoll * 3);
	
	
	*/
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7	
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	
	
	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		int t = 2;
		
		
		x = x + t;
		y = y + t;
		z = z - t * 2;
		
		System.out.printf("x=%d\ny=%d\nz=%d\n\n", x, y, z);
			
		
	}
/*
 * 강사님 코드
 *		int x = 5;
		int y = 7;
		int z = 9;
		
		int t = x;
 * 		x = y;
 * 		y = z;
 * 		z = t;
 * 		System.out.printf("x=%d\ny=%d\nz=%d\n\n", x, y, z);
 * */		

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {

		System.out.print("첫 번째 정수 :");
		int a = Integer.parseInt(sc.nextLine());
		
		
		System.out.print("두 번째 정수 :");
		int b = Integer.parseInt(sc.nextLine());
		
		System.out.printf("첫 번째 정수: %d\n 두 번째 정수: %d\n 두 정수 더하기: %d\n 두 정수 빼기: %d\n 두 정수 곱하기: %d\n 두 정수 나누기: %d \n\n",a ,b ,(a + b), (a - b), (a * b), (a / b) );

	}
	
	/*	System.out.print("첫 번째 정수 :");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 :");
		int num2 = sc.nextInt();
		
		
		
	 * 	System.out.println("더하기 : " + (num1 + num2));
	 * 	System.out.println("빼기 : " + (num1 - num2));
	 * 	System.out.println("곱하기 : " + (num1 * num2));
	 * 	System.out.println("나누기 몫 : " + (num1 / num2));
	 * */

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {

	
		
		System.out.print("가로 : ");
		double a = Double.parseDouble(sc.nextLine());
		
		System.out.print("세로 : ");
		double b = Double.parseDouble(sc.nextLine());
		
		double area = a * b;
		double Round =(a + b)*2; 		
				
		
		System.out.printf("가로 :%.1f \n세로 :%.1f \n면적 :%.2f \n둘레 :%.1f \n",a , b ,area , Round );

	
		
		
		
	}
	
	/*	
	 *  System.out.print("가로 : ");
	 *  float num1 = sc.nextLine();
	 *  System.out.print("세로 : ");
	 *  float num2 = sc.nextLine();
	 * 
	 *  double area = num1 * num2;
		double Round =(num1 + num2)*2;
	 * 
	 * System.out.printf("가로 :%.1f \n세로 :%.1f \n면적 :%.2f \n둘레 :%.1f \n",a , b ,area , Round );
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
	

		System.out.println("문자열을 입력하세요 : ");
		String message = sc.nextLine();
		char a = message.charAt(0);
		char b = message.charAt(1);
		char c = message.charAt(message.length()-1);

		
		
		System.out.printf("첫번째 문자: %c  \n두번째 문자: %c \n마지막 문자: %c \n", a , b, c);
		//System.out.println("첫번째 문자:"+ a);
	    //System.out.println("두번째 문자:"+ b);
		//System.out.println("마지막 문자:"+ c);
		
	}
// String message = sc.nextLine(); 대신 char message = sc.nextLine().charAt(0); 사용가능
	
	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		
		
		System.out.println("문자 : ");
		String uni = sc.nextLine();
		int a = uni.charAt(0);
		// System.out.printf("A unicode: %c  \nB unicode: %c \n", a , b);
		System.out.println(uni +" unicode:"+ a);
		System.out.println(uni +" unicode:"+ (a+1));
		
	
	}
	
	/*
	 * System.out.println("문자 : ");
		char ch = sc.nextLine().charAt(0);
	 * 
	 * int num = ch;
	 * 
	 * char ch2 = (char) (num + 1);
	 * */
	
	
	/*
	 * 
	 * 
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		
		/*
		System.out.println("국어 : ");
		int ko = Integer.parseInt(sc.nextLine());
		System.out.println("영어 : ");
		int en = Integer.parseInt(sc.nextLine());
		System.out.println("수학 : ");
		int ma = Integer.parseInt(sc.nextLine());
		
		int sum = ko+en+ma;
		double ave = ((double)ko+en+ma)/3;
		System.out.printf("국어 : %d\n영어 : %d\n수학 : %d\n총점 : %d\n평균 : %.2f\n", ko, en, ma, sum, ave);
		
		*
		*
		*/
		System.out.println("국어 : ");
		double ko = Double.parseDouble(sc.nextLine());
		System.out.println("영어 : ");
		double en = Double.parseDouble(sc.nextLine());
		System.out.println("수학 : ");
		double ma = Double.parseDouble(sc.nextLine());
		
		double sum = ko+en+ma;
		double ave = (ko+en+ma)/3;
		System.out.printf("국어 : %.0f\n영어 : %.0f\n수학 : %.0f\n총점 : %.0f\n평균 : %.2f\n", ko, en, ma, sum, ave);
	}

}
