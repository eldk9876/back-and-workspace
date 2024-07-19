package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    
	public static void main(String[] args) {

		
		OperatorPractice op = new OperatorPractice();
		System.out.println("----------method1----------\n");
		op.method1(); 
		System.out.println("----------method2----------\n");
		op.method2();
		System.out.println("----------method3----------\n");
		op.method3();
		System.out.println("----------method4----------\n");
		op.method4();
		System.out.println("----------method5----------\n");
		op.method5();
		System.out.println("----------method6----------\n");
		op.method6();
		System.out.println("----------method7----------\n");
		op.method7();
		
		
		
	}
	Scanner sc = new Scanner(System.in);  
	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		
	
		System.out.println("인원 수: ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("연필 개수: ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		//int sum1 = num1 + num2 ;
		//int sum2 = 
		
		
		/*
		
		int test1 = num2 > num1 ;
		int test2 = num1 - num2;
		String result = num1 = num2 ? num1 : num2 ;
		
		
		int result1 = num1 % num2 ;
		int result2 = num1 - num2 ;
		
		int result3 = result2 + result1  ;

		
	
		
		System.out.println("동일하게 나눠가진 연필개수 : "+ result +"\n남은 연필 개수 : " + result1 + "\n부족한 연필 개수 : " + result2 + "\n"+ result2 + (result3));
	
		*/
		String result = num1 > num2 
				? String.format("동일하게 나눠가진 연필개수 : %d \n남은 연필 개수 %d \n부족한 연필 개수 : %d ", (num1 / num2),(num1 % num2),(num2 / num1))
				: num1 < num2
					? String.format("동일하게 나눠가진 연필개수 : %d \n남은 연필 개수 %d \n부족한 연필 개수 : %d ", (num2 / num1), (num2 % num1), (num1 / num2))
					: "모두가 공평히 나눠가졌습니다";

		System.out.println(result);
		
		// 시간남으면 부족한 개수도 만들어보기
			
		/* 강사님 코드
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("입력 받은 숫자 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		// 두 자리수는 버리기
		int result  = num1 - num1 %100 ;
		
		System.out.println(result);
		
		
		
		
		
		/*
		 * 강사님 코드
		 * 만약 뒷 자리를 버릴때
		 * System.out.print("숫자 입력 (100의 자리 이상) : ");
			int num = sc.nextInt();
			System.out.println( num1 - num1 %100);
		 * 다른 방법1
		 * 	System.out.println( num / 100 * 100);
		 * 
		 * */
		
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		
		System.out.println("첫번째 숫자 : \n");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("두번째 숫자 : \n");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("세번째 숫자 : \n");
		int num3 = Integer.parseInt(sc.nextLine());
		
		String result =  num1 == num2 && num1 == num3 && num2 == num3 ? "true": "false" ;
		
		System.out.println(result);
		
		/* 강사님 코드
		 * ystem.out.println("첫번째 숫자 : \n");
			int num1 = Integer.parseInt(sc.nextLine());
		
			System.out.println("두번째 숫자 : \n");
			int num2 = Integer.parseInt(sc.nextLine());
		
			System.out.println("세번째 숫자 : \n");
			int num3 = Integer.parseInt(sc.nextLine());
		 * 
		 * boolean result =  num1 == num2 && num2 == num3 ;
		 * System.out.println(result);
		 * 
		 * 
		 * */
		
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("입력 할 정수 : ");		
		int num1 = Integer.parseInt(sc.nextLine());
		
		String result =  num1 % 2 == 0 ? "짝수다": "짝수가 아니다";
		
		System.out.println(result);
		
		/* 강사님 코드
		 * System.out.println("입력 할 정수 : ");	
		 * int num1 = Integer.parseInt(sc.nextLine());
		 * 
		 *String str = num % 2 == 0 ? "짝수다": "짝수가 아니다";
		 * System.out.println(str);
		 * 
		 * 
		 * */
		
		
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요 000000-0000000
	public void method5() {
		System.out.println("주민등록 번호 입력 : ");
		String min = sc.nextLine();
		char minch = min.charAt(7);
		String result =  minch == '1' ||  minch == '3'? "남자" : minch == '2' ||  minch == '4' ? "여자": "잘못된 주민등록 번호입니다" ;
		System.out.println(result);
		
		
		
		/* 강사님 코드
		 * System.out.print("주민번호(-포함) : ");
		 * char no = sc.nextLine().charAt(7);
		 * System.out.println(minch == '1' ||  minch == '3'? "남자" : "여자");
		 * 
		 * 
		 * 
		 * */
		
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method6() {
		
		System.out.println("나이를 써 주세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		String result =  (age <= 13 ? "어린이" : age > 13 && age <= 19 ? "청소년" :"성인") ;
		System.out.println(result);
		
		
		/* 강사님 코드
		 * System.out.print("나이 입력 : ");
		 * int age = sc.nextInt();
		 * 
		 * String str = age <= 13 ? "어린이" : age <= 19 ? "청소년":"성인";
		 * System.out.println(str);
		 * 
		 * 
		 * */
	}

	
	
	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.println("사과의 개수 : ");
		//int ap = Integer.parseInt(sc.nextLine());
		double ap = Double.parseDouble(sc.nextLine());
		
		System.out.println("바구니의 크기 : ");
		double bp = Double.parseDouble(sc.nextLine());
/*
		//int app = ap*5; // 사과 1개당 크기 = 5
		//int	ba	= bp/app;	// 바구니 1개당 크기 = 20
	// 바구니 1개당 크기 = 20
	//	int result =  ;// 사과 4개에 바구니 1개  
								// 바구니에 사과가 1개라도 안(char) 담기면 바구니 하나추가 
		//int result = (bp = 20) % (ap = 4) ;
	//	String result = ap > bp ? ap - bp : bp - ap ;
*/			
		
		String result = ap > bp 
				? String.format("사과의 개수 : %.0f \n바구니의 크기는 %.0f \n필요한 바구니의 수 : %.0f ", ap, bp,(ap / bp))
				: ap < bp
					? String.format("사과의 개수 : %.0f\n 바구니의 크기는 %.0f \n필요한 바구니의 수 : %.0f ", ap, bp, (ap / bp))
					: "0";

		System.out.println(result);
		
		
		
		
		//System.out.println("사과의 개수 : "+ ap +"\n필요한 바구니의 수 : " + result + "\n 만약 " + (result+1) );
		//System.out.printf("사과의 개수는 : %d\n 바구니의 크기는 %d\n 필요한 바구니의 수는 %d",ap,bp,result );
	/*	
		System.out.print("비교 연산자 입력 (< 또는 >) >");
		char bott = sc.nextLine().charAt(0);
		
		String result = bott == '>' 
				? ap + ">" + bp + "=" + (ap - bp)
				: bott == '<'
					? ap + "<" + bp + "=" + (bp - ap)
					: "0\n";
		
		
		
		result = bott == '>' 
				? String.format("사과의 개수 : %d 바구니의 크기는 %d 필요한 바구니의 수 : %d ", ap, bp,(ap - bp))
				: bott == '<'
					? String.format("사과의 개수 : %d 바구니의 크기는 %d 필요한 바구니의 수 : %d ", ap, bp, (bp-ap))
					: "0";
		*/
		
		
		//System.out.println();
		
		
		
		/* 강사님 코드
		 * System.out.print("사과의 개수 :");
		 * int apple = sc.nextInt();
		 * 
		 * System.out.print("바구니 1개당 들어가는 사과의 개수 : ");
		 * int count = sc.nextInt();
		 * 
		 * System.out.println(apple / count + (apple % count == 0 ? 0 : 1));
		 * 
		 * 
		 * */
		
		
	}
	
}