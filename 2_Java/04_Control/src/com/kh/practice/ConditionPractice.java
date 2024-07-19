package com.kh.practice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConditionPractice {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ConditionPractice Co = new ConditionPractice();
		
//		System.out.println("----------method1----------\n");
//		Co.method1(); 
//		System.out.println("----------method2----------\n");
//		Co.method2();
//		System.out.println("----------method3----------\n");
//		Co.method3(); 
//		System.out.println("----------method4----------\n");
//		Co.method4();
		System.out.println("----------method5----------\n");
		Co.method5();
		System.out.println("----------method6----------\n");
		Co.method6();
		System.out.println("----------method7----------\n");
		Co.method7();
		System.out.println("----------method8----------\n");
		Co.method8();
		System.out.println("----------method9----------\n");
		Co.method9();
		System.out.println("----------method10----------\n");
		Co.method10();
		System.out.println("----------method11----------\n");
		Co.method11();//작성중
	
		
		
	}

    /*
       입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고 짝수가 아니면 "홀수다"를 출력하세요.
       양수가 아니면 "양수만 입력해주세요."를 출력하세요.
    
       숫자를 한 개 입력하세요 : -8
       양수만 입력해주세요.
     */
    public void method1() {
    	
    	
    	System.out.println("입력 : ");
    	int num = sc.nextInt();	
    	
    	if(num > 0 && num %2 == 0) {
    		
    		System.out.println("짝수다");
    	} else if (num > 0 && num %2 != 0) {
    		
    		System.out.println("홀수다");
    	} else {
    		
    		System.out.println("양수만 입력해 주세요");
    	}
    }
    
    // 강사님 코드
    /*case 1 
    System.out.print("숫자를 한 개 입력하세요 : ");
	int num = sc.nextInt();
	
	if(num > 0 && num % 2 ==0) {
		System.out.println("짝수다");
	} else if(num > 0 && num %2 != 0) {
		System.out.println("홀수다");
	}else {
		System.out.println("양수만 입력해 주세요");
	}
	
	*/
    /* case 2 
    if(num > 0) {
    	if(num % 2 == 0 ) {
    		
    		System.out.println("짝수다");
    	} else {
    		System.out.println("홀수다");	
    	} }else {
    		System.out.println("양수만 입력해 주세요");
    	}
    */	
    	
    
    
   /* case 3 
    if(num <=0 ) { // 양수가 아닌것들부터 처리
    	System.out.println("양수만 입력해 주세요");
    } else if (num % 2 == 0) {
    	System.out.println("짝수다");
    }else {
    	System.out.println("홀수다");	
    }
   */ 
    
    
    

    /*
        정수 num1과 num2를 입력 받아서 두 수가 같으면 1 다르면 -1을 출력하세요.

        num1 : 2
        num2 : 3
        -1

        num1 : 11
        num2 : 11
        1
     */
    public void method2() {
    	
    	System.out.println("첫번째 수:");
    	int num1 = sc.nextInt();
    	
    	System.out.println("두번째 수:");
    	int num2 = sc.nextInt();
    	
    	String result = num1 != num2 ? "-1" : "1";
    	
    	System.out.println(result);
    	
    	
    	
    	
    	
    	// 강사님 코드
    	
    	/*
    	System.out.println("num1 :");
    	int num1 = sc.nextInt();
    	
    	System.out.println("num2 :");
    	int num2 = sc.nextInt();
    
    //	if(num1 == num2) System.out.println(1);
    //	else System.out.println(-1);
   
    	
    	int result = -1;
    	if(num1 == num2)result = 1;
    	System.out.println(result);
    	*/
    	  	
    }
    
 
    

    /*
        A 피자가게는 피자를 두 조각에서 열 조각까지 원하는 조각 수로 잘라준다.
        피자 조각 수와 피자를 먹는 사람의 수를 입력받아 한 사람 당 최소 한 조각 이상 
        피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지 출력하세요.

        피자 조각 수 : 7
        피자 먹는 사람 수 : 10
        2

     */
    public void method3() {
    	
    /*
    	System.out.println("피자 조각 수 : ");
    	double num1 =  Double.parseDouble(sc.nextLine());
    	
    	System.out.println("피자를 먹는 사람의 수 : ");
    	double num2 =  Double.parseDouble(sc.nextLine());
    	
    	
    	
    	String result =  2 <= num1 && num1 <= 10 && num1 > num2
				? String.format("피자 조각의 수 %.0f \n피자를 먹는 사람의 수 : %.0f \n시켜야되는 피자의 수 :%.0f ", num1, num2, Math.ceil(num2 / num1))
				:   2 <= num1 && num1 <= 10 && num1 < num2
					? String.format("피자 조각의 수 %.0f \n피자를 먹는 사람의 수 : %.0f \n시켜야되는 피자의 수 :%.0f ", num1, num2, Math.ceil(num2 / num1))
					: "잘못";
    	
    	System.out.println(result);
    	*/
    	   // 강사님 코드
    	
    	System.out.println("피자 조각 수 : ");
    	int pizza =  sc.nextInt();
    	
    	System.out.println("피자를 먹는 사람의 수 : ");
    	int person =  sc.nextInt();
    	
    	int result = person / pizza;
    	
    	if(person % pizza != 0) {
    		result++;
    		System.out.println(result);
    	}
 
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    /*
    	if(2 <= num1 && num1 <= 10 && num1 > num2) {
    		
    		System.out.printf("피자 조각의 수 %.0f \n피자를 먹는 사람의 수 : %.0f \n시켜야되는 피자의 수 :%.0f "  , num1 ,num2, (num2*num1)/100 );
    		
   
    	} else if(2 <= num1 && num1 <= 10 && num1 < num2) {
    		System.out.printf("피자 조각의 수 %.0f \n피자를 먹는 사람의 수 : %.0f \n시켜야되는 피자의 수 :%.0f "  , num1 ,num2, String.format("%d",num2/num1) );	
    	} 
    	else {
    		
    		System.out.println("피자 조각수가 잘못되었습니다");
    	}

    	*/
        
    }
    
  	/*	
	String result = num1 > num2
			? String.format("피자 조각의 수 %d \n피자를 먹은 사람의 수 : %d \n시켜야되는 피자의 수 :%d "  , num1 ,num2, num1%num2 )
			: num1 < num2
			?String.format("피자 조각의 수 %d \n피자를 먹은 사람의 수 : %d \n시켜야되는 피자의 수 :%d",  num1 , num2, num1%num2)
					: "부족하지 않습니다";
		*/	

    /*
        국어, 영어, 수학 세 과목의 점수를 입력 받고 합계와 평균을 계산하고 합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
        (합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
        합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고 불합격인 경우에는 “불합격입니다.”를 출력하세요.
    
        국어점수 : 88 
        수학점수 : 50 
        영어점수 : 40 
        불합격입니다.

        국어점수 : 88
        수학점수 : 50
        영어점수 : 45
        합계 : 183
        평균 : 61.0
        축하합니다, 합격입니다!
     */
    public void method4() {
    	
    	System.out.println("국어점수 : ");
    	int ko = sc.nextInt();
    	System.out.println("수학점수 : ");
    	int ma = sc.nextInt();
    	System.out.println("영어점수 : ");
    	int en = sc.nextInt();
    	
    	
    	if(40 <= ko && 40 <= ma && 40 <= en && ((ko + ma + en)/3 >= 60)) {
    		
    		System.out.printf("국어점수: %d \n수학점수: %d \n영어점수: %d \n합계: %d \n평균: %.1f \n 축하합니다, 합격입니다!",ko,ma,en,(ko + ma + en),((double)(ko + ma + en)/3) );
    		
    	}else {
    		
    		System.out.printf("국어점수: %d \n수학점수: %d \n영어점수: %d \n불합격입니다.",ko,ma,en );
    	}
    	
    	 // 강사님 코드
    	System.out.println("국어점수 : ");
    	int korea = sc.nextInt();
    	System.out.println("수학점수 : ");
    	int math = sc.nextInt();
    	System.out.println("영어점수 : ");
    	int english = sc.nextInt();
    	
    	int sum = korea + math + english ;
    	double avg = (double) sum / 3;
    	
    	if(korea >= 40 && math >= 40 && english >= 40 && avg >= 60) {
   
    		System.out.println("합계 :" + sum);
    		//System.out.printf("평균 : %.1f\n",avg);
    		System.out.println("평균 :"+String.format("%.1f", avg));
    		System.out.println("축하합니다, 합격입니다!");
    		
    	}else {
    		System.out.println("불합격입니다");
    	}
    	
    	
 
    }
    
 

    /*
        B 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만원 이상 사면 20%를 할인해준다.
        구매한 옷의 가격을 입력했을 때, 지불해야 할 금액을 출력하세요.
        
        구매한 옷 가격 : 580000
        464000
     */
    public void method5() {
    	System.out.println("구매한 옷 가격: ");
    	double num =  Double.parseDouble(sc.nextLine());
	

    	/*
    	String result = num == (num <= 100000 && num <300000)
				? String.format("구매한 옷 가격은: %d\n 지불할 금액: %d ", num, num*0.05)
				: num == (num <= 300000 && num <500000)
					? String.format("구매한 옷 가격은: %d\n 지불할 금액: %d ", num, num*0.1)
					: num == 500000 <=num
							? String.format("구매한 옷 가격은: %d\n 지불할 금액: %d ", num, num * 0.2);*/
    
    	if(num <= 100000 && num <300000) {
    		System.out.printf("구매한 옷 가격은: %.0f\n 지불할 금액: %.0f ", num, num-(num*0.05) );
    		
    	}else if (num <= 300000 && num <500000) {
    		System.out.printf("구매한 옷 가격은: %.0f\n 지불할 금액: %.0f ", num, num-(num*0.1));
    		
    	}else if(num <=500000){
    		System.out.printf("구매한 옷 가격은: %.0f\n 지불할 금액: %.0f ", num, num-(num*0.2));
    		
    	}else {
    		System.out.println(num);
    	}

    	  // 강사님 코드
    	/*
    	System.out.println("구매한 옷 가격: ");
    	int price =  sc.nextInt();
    	
    	if(price >= 500000) {
    		price = (int) (price * 0.8);
    	}else if(price >= 300000) {
    		price = (int) (price * 0.9);
    	}else if(price >= 100000) {
    		price = (int) (price * 0.95);
    	}
    	
    	DecimalFormat df= new DecimalFormat ("###,###");
    	System.out.println(df.format(price));
    	
    	System.out.println(price);
    	*/
    	
    	
    	
    }
    
  
    
    


    /*
        각에서 0도 초과 90도 미만은 예각, 90도는 직각, 90도 초과 180도 미만은 둔각 180도는 평각으로 분류한다.
        입력받은 각에 따라 예각일 때 1, 직각일 때 2, 둔각일 때 3, 평각일 때 4를 출력하세요.
     */
    public void method6() {
    	System.out.print("각도 입력 : ");
    	int num = Integer.parseInt(sc.nextLine());
    	
    	if( 0 < num && num <90 ) {
    		System.out.println("예각 = 1");
    	} else if ( num == 90 ) {
    		System.out.println("직각 = 2");
    	} else if ( 90< num && num <180 ) {
    		System.out.println("둔각 = 3");
    	}else if ( num == 180 ) {
    		System.out.println("평각 = 4");
    	}else {
    		System.out.println("포함 되지 않음");
    	}
    	 
    	
    	// 강사님 코드
    /*	System.out.print("각도 입력 : ");
    	int angle = sc.nextInt();
    	int result = 0;
    	
    	
    	if(0 < angle && angle < 90) {
    			result =1;	
    	}else if(angle == 90) {
			result =2;	
    	}else if(90 < angle && angle < 180) {
			result =3;	
    	}else if(angle == 180) {
			result =4;	
    	}
    	System.out.println(result);
    	*/
    	
    	
    	
    }

 

    /*
       아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요.
       로그인 성공 시 "로그인 성공", 
       아이디가 틀렸을 시 "아이디가 틀렸습니다.",
       비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다.",
       아이디와 비밀번호 둘 다 틀렸을 시 "로그인 실패" 를 출력하세요.

       아이디 : happy
       비밀번호 : 1234
       로그인 성공!

       아이디 : happy
       비밀번호 : 23467
       비밀번호가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 1234
       아이디가 틀렸습니다.

       아이디 : happy222
       비밀번호 : 23456
       로그인 실패
    */
    public void method7() {

    	System.out.println("아이디 : ");
    	String id = sc.nextLine();
    	
    	System.out.println("비밀번호 : ");
    	int pass = sc.nextInt();
    	
    	if (id.equals("happy") && pass == 1234) {
    		System.out.println("로그인 성공!");	
    	}else if (id.equals("happy") && pass != 1234) {
    		System.out.println("비밀번호가 틀렸습니다");	
    	}else if (id != "happy" && pass == 1234) {
    		System.out.println("아이디가 틀렸습니다");	
    	}else {
    		System.out.println("로그인 실패!");
    	}
    	
    	
    	//System.out.println("id의 주소값 : " + System.identityHashCode(id));
		//System.out.println("아이디 주소값 : " + System.identityHashCode("happy"));
    	
    // 강사님 코드	
    	System.out.println("아이디 : ");
    	String iid = sc.nextLine();
    	
    	System.out.println("비밀번호 : ");
    	String pwd = sc.nextLine();
    	
    	String idCheck = "happy";
    	String pwdCheck = "1234";
    	
    	if(id.equals(idCheck)&& pwd.equals(pwdCheck)) {
    		System.out.println("로그인 성공!");
    	}else if(!id.equals(idCheck) && !pwd.equals(pwdCheck)) {
    		System.out.println("로그인 실패");		
    	}else if(!id.equals(idCheck) && pwd.equals(pwdCheck)) {
    		System.out.println("아이디가 틀렸습니다");
    	}else {
    		System.out.println("비밀번호가 틀렸습니다.");
    		
    	}
    	
    }
    
   
    
    
    

    /*
        키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라 저체중 / 정상체중 / 과체중 / 비만을 출력하세요.
        BMI = 몸무게 / (키(cm) * 키(cm)) * 10000 
        BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
        BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
        BMI가 30이상일 경우 고도 비만

        키(cm)를 입력해 주세요 : 162
        몸무게(kg)를 입력해 주세요 : 46
        BMI 지수 : 17.527815881725342
        저체중

     */
    public void method8() {
    	
    	System.out.println("키(cm)를 입력해 주세요 : ");
    	double num1 = sc.nextDouble();
    	
    	System.out.println("몸무게(kg)를 입력해 주세요 : ");
    	double num2 = sc.nextDouble();
    	
    	
    	
    	
    	
    	
    	
    	// 강사님 코드
    	System.out.println("키(cm)를 입력해 주세요 : ");
    	double cm = sc.nextDouble();
    	
    	System.out.println("몸무게(kg)를 입력해 주세요 : ");
    	double kg = sc.nextDouble();
    	
    	double bmi = kg / (cm * cm) * 10000;
    	System.out.println("BMI 지수 : " + bmi);
    	
    	String result = "저체중";
    	
    	if (bmi >= 30) {
    		result = "고도비만";
    	} else if (bmi >= 25) {
    		result = "비만";
    	}else if (bmi >= 23) {
    		result = "과체중";
    	}else if (bmi >= 18.5) {
    		result = "정상체중";
    	}
    	System.out.println(result);
    	
    }

    /*
        두 개의 양수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
        (단, 양수가 아닌 값을 입력하거나 제시되어 있지 않은 연산 기호를 입력 했을 시 
        "잘못 입력하셨습니다. 프로그램을 종료합니다." 출력)

        숫자 입력 : 15
        숫자 입력 : 4
        연산자를 입력(+,-,*,/,%) : /
        15 / 4 = 3

     */
    public void method9() {
    /*
    	System.out.print("첫번째 수 >");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 수 >");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("연산자를 입력 (+,-,*,/,%) >");
		char select = sc.nextLine().charAt(0);
		
    	
		String result = select == '+' 
				? String.format("%d + %d = %d ", num1, num2,(num1 + num2))
				: select == '-'
					? String.format("%d - %d = %d", num1, num2, (num1 - num2))
					: select == '*'
							? String.format("%d * %d = %d", num1, num2, (num1 * num2))
									: select == '/'
											? String.format("%d / %d = %d", num1, num2, (num1 / num2))
													: select == '%'
															? String.format("%d % %d = %d", num1, num2, (num1 % num2))
																	: "잘못 입력했습니다. 프로그램을 종료합니다";
    	
		System.out.println(result);
    	*/

		// 강사님 코드
    	/*
			System.out.println("숫자 입력 : ");
			int num1 = Integer.parseInt(sc.nextLine());
			
			System.out.println("숫자 입력 : ");
			int num2 = Integer.parseInt(sc.nextLine());
		
			System.out.print("연산자를 입력 (+,-,*,/,%) :");
			char op = sc.nextLine().charAt(0);
			
			if(num1 <= 0 || num2 <= 0){
				System.out.println("잘못 입력했습니다. 프로그램을 종료합니다");
				return;
			}
			
			int result = 0;
			
			switch(op) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				case '%':
					result = num1 % num2;
					break;
				default:
					System.out.println("잘못 입력했습니다. 프로그램을 종료합니다");
					return; // 키워드를 만나면 종료
			}

			
			System.out.printf("%d %c %d = %d", num1, op, num2, result);
		
		*/
    }

    /*
      아래 예시와 같이 메뉴를 출력하고 메뉴 번호를 누르면 “OO메뉴입니다“를, 종료 번호를 누르면 “프로그램이 종료됩니다.”를 출력하세요

        1. 입력
        2. 수정
        3. 조회
        4. 삭제
        9. 종료
        메뉴 번호를 입력하세요 : 3
        조회 메뉴입니다.
     */
    public void method10() {
    	
    	System.out.print("1. 입력 \n2. 수정 \n3. 조회 \n4. 삭제 \n9. 종료 \n");
    	
    	System.out.println("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
			System.out.println("1. 입력 메뉴입니다");
			break;
			case 2:
			System.out.println("2. 수정 메뉴입니다");
			break;
			case 3:
			System.out.println("3. 조회 메뉴입니다");
			break;
			case 4:
			System.out.println("4. 삭제 메뉴입니다");
			break;
			case 9:
			System.out.println("9. 프로그램이 종료됩니다");
			break;
				

			default : 
			System.out.println("메뉴가 없습니다. 재시작 후 다른 번호를 입력해 주세요 ");
		
	}
		
		//강사님 코드
		/*
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		System.out.println("메뉴 번호를 입력하세요 : ");
		
		int num = sc.nextInt();
		String result = "";
			
		switch(num) {
		
				case 1:
					result = "입력 메뉴입니다";
					break;
				case 2:
					result = "수정 메뉴입니다";
					break;
				case 3:
					result = "조회 메뉴입니다";
					break;
				case 4:
					result = "삭제 메뉴입니다";
					break;
				case 9:
					result = "프로그램이 종료됩니다";
					break;
				
				default:
					result = "잘못된 번호입니다"; 
			}
		System.out.println("");
		
		
		*/

    }

    /*
        중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
        총점 100점 중 배점으로는 다음과 같다.
        중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
100 1.2%
        이때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력

        총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
        아니면 Fail을 출력하세요.

        중간 고사 점수 : 80
        기말 고사 점수 : 90
        과제 점수 : 50
        출석 횟수 : 15
        ===========결과==========
        중간 고사 점수(20) : 16.0
        기말 고사 점수(30) : 27.0
        과제 점수 (30) : 15.0
        출석 점수 (20) : 15.0
        총점 : 73.0
        PASS

        중간 고사 점수 : 80
        기말 고사 점수 : 30
        과제 점수 : 60
        출석 횟수 : 18
        ===========결과==========
        FAIL [점수 미달] (총점 61.0)

        중간 고사 점수 : 90
        기말 고사 점수 : 100
        과제 점수 : 80
        출석 횟수 : 13
        ===========결과==========
        FAIL [출석 횟수 부족] (13/20)

        중간 고사 점수 : 100
        기말 고사 점수 : 80
        과제 점수 : 40
        출석 횟수 : 10
        ===========결과==========
        FAIL [출석 횟수 부족] (10/20)
        FAIL [점수 미달] (총점 66.0)

     */
    public void method11() {
   
    	
    /*	System.out.println("중간 고사 점수 : ");
		double num1 = Double.parseDouble(sc.nextLine());
    	
		System.out.println("기말 고사 점수 : ");
		double num2 =  Double.parseDouble(sc.nextLine());
		
		System.out.println("과제 고사 점수 : ");
		double num3 =  Double.parseDouble(sc.nextLine());
		
		System.out.println("출석 고사 점수 : ");
		double num4 =  Double.parseDouble(sc.nextLine());
    	*/
	/*	
		double percent = 100*0.2; // 20%
		double percent2 = 100*0.3; // 30%
		*/
	/*	
		if(0 <= num4 && num4 <=20) {
			String result = num4 == num4*0.2 
					? String.format("%d + %d = %d ", num1, num2,(num1 + num2))
					: num4 == '-'
						? String.format("%d - %d = %d", num1, num2, (num1 - num2))
						: num4 == '*'
								? String.format("%d * %d = %d", num1, num2, (num1 * num2))
										: num4 == '/'
												? String.format("%d / %d = %d", num1, num2, (num1 / num2))
														: num4 == '%'
																? String.format("%d % %d = %d", num1, num2, (num1 % num2))
																		: "잘못 입력했습니다. 프로그램을 종료합니다";
			
		} else {
			
			System.out.println("틀림 ");
			
		}
    	
    	*/
		/*
    	
    	if(0 <= num4 && num4 <=20) {
			String result = num4 == num4
					? String.format("출석 점수 (%.0f) : %.0f ", percent * 0.2, ((percent * 0.2) - num4))
					: "확인";
			System.out.println(result);
    	}else {
    		
    		System.out.println("틀림 ");
    	}
    	*/
    	//출석점수 =  (0 <= num4 && num4 >=20);
    	
    	/*	
    	중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
        총점 100점 중 배점으로는 다음과 같다.
        중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)

        이때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 입력

        총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
        아니면 Fail을 출력하세요.

        중간 고사 점수 : 80
        기말 고사 점수 : 90
        과제 점수 : 50
        출석 횟수 : 15
        ===========결과==========
        중간 고사 점수(20) : 16.0
        기말 고사 점수(30) : 27.0
        과제 점수 (30) : 15.0
        출석 점수 (20) : 15.0
        총점 : 73.0
        PASS

        중간 고사 점수 : 80
        기말 고사 점수 : 30
        과제 점수 : 60
        출석 횟수 : 18
        ===========결과==========
        FAIL [점수 미달] (총점 61.0)

        중간 고사 점수 : 90
        기말 고사 점수 : 100
        과제 점수 : 80
        출석 횟수 : 13
        ===========결과==========
        FAIL [출석 횟수 부족] (13/20)

        중간 고사 점수 : 100
        기말 고사 점수 : 80
        과제 점수 : 40
        출석 횟수 : 10
        ===========결과==========
        FAIL [출석 횟수 부족] (10/20)
        FAIL [점수 미달] (총점 66.0)
    	
    	*/
    	// 강사님 코드
    
    	System.out.println("중간 고사 점수 : ");
		int num1 = sc.nextInt();
    	
		System.out.println("기말 고사 점수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("과제 점수 : ");
		int num3 = sc.nextInt();
		
		System.out.println("출석 점수 : ");
		int num4 = sc.nextInt();
    	
    	System.out.println("========결과=========");
    	
    	double score1 = num1 * 0.2;
    	double score2 = num2 * 0.3;
    	double score3 = num3 * 0.3;
    	double sum = score1+ score2+ score3+ num4;
    	
    	if (sum >= 70 && num4 >= 20 * 0.7) {
    		
    		System.out.println("중간 고사 점수(20) : " + score1);
    		System.out.println("기말 고사 점수(30) : " + score2);
    		System.out.println("과제 점수 (30) : " + score3 );
    		System.out.println("출석 점수 (20) : " + num4);
    		System.out.println("총점 : " + sum);
    		System.out.println("PASS");
    		} else {
    			
    			if(num4 < 20 * 0.7) {
    				System.out.println("FAIL [출석횟수 부족](" + num4 + "/20)");
    		} if(sum <70) {
    			System.out.println("FAIL [점수 미달] (총점 " + sum + ")");
    		}
    				
    			}
    			

   	
    	
    }
    
}