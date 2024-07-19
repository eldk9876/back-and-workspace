package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		LoopPractice L = new LoopPractice();
//		System.out.println("-------------method1-------------");
//		L.method1(); // 완
//		System.out.println("-------------method2-------------");
//		L.method2(); // 검토
//		System.out.println("-------------method3-------------");
//		L.method3(); // 완
//		System.out.println("-------------method4-------------");
//		L.method4(); // 완
//		System.out.println("-------------method5-------------");
//		L.method5(); // 완
//		System.out.println("-------------method6-------------");
//		L.method6(); // 작
		

		
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.println("사용자 입력 : ");
    	int num = sc.nextInt();
    	
    	for(int i =num; i >= 1; i--) {
    		
    		System.out.println(i);
    	}
    }
    
    // 강사님 코드와 같음
  

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int ap = 0;
		int bp = 0;
		int sum = 0;
    	for(int i = 0 ; i <= 100000; i+=1) {
    	
    	//ap +=2;
    	//bp -=2;
    			if(i % 2 ==0) {
    				ap += 2;
    			} else {
    				bp -= 2;
    			}
    			sum = ap + (bp);
    		//	sum = ap+=2 + (bp-=2);
    			
    		if(sum >= 100) {
    			System.out.println("\nap == " + i);
    			System.out.println("\nap == " + ap);
    			System.out.println("bp == " + bp);
    			System.out.println("\n총합 == " + sum );
    			break;
    		} 
    	
    		//강사님 코드
    	// 코드1	
    	/*int sum = 0;
    		int num = 1;
    		
    		while(true) {
    			if(num % 2 ==0) {
    				sum -= num;
    			} else {
    				sum += num;
    			}
    			
    			if(sum >= 100) {
    				System.out.println(num);
    				break;
    			}
    			num++;
    		}
    		*/
    /*	int sum = 0;
		int num = 0;
		
		while(sum < 100) {
			num++;
			
			if(num % 2 ==0) {
				sum -= num;
			} else {
				sum += num;
			}
			
		}System.out.println(num);
    	
    	*/
    		
    		
    		
    		
   }	{{
    		
    		/*else if(sum >= 100) {

    			System.out.println("\nap == " + ap);
    			System.out.println("bp == " + bp);
    			System.out.println("\n총합은 ! == " + sum);
    			
    			break;
    		}*/	}}
//    			System.out.println("i + j ==" + ( i + j ));
    		/*	
    			System.out.println("입력 : ");
    			int num =sc.nextInt();
    			int sum = 0;
    			
    			for (int i = 1; i <= num; i++) {
    					sum += i;			
    			}
    			System.out.println(sum);
    			
    		}*/
    			
	//	for(int i = 1; i <= num; i+=2) {	System.out.println("i ==" + i);	}
	//	for(int j = 2; j <= num; j+=2) {     System.out.println("j ==" + j);  	}
    	
		//	System.out.println("i + j ==" + ( i + j ));
	
    	
    	
    	
    	
	}
    
    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.println("문자열 : ");
    	String text = sc.nextLine();
 
    	System.out.println("문자 : ");
    	char text1 = sc.nextLine().charAt(0);
    	int num = 0;
    	
    	for (int i = 0; i <= text.length()-1; i++ ) {
    		
    		/*if (text = text.charAt(0)) {
		
    		}*/
			// System.out.println(text.charAt(i) == text1 );
			if(text.charAt(i) == text1 ) {
				num	= num + 1;	
			}
		}
    	System.out.println("banana 안에 포함된 "+ text1 + "개수 = " + num);	
		}
    	
    // 강사님 코드
   /* {
    	System.out.println("문자열 : ");
    	String str = sc.nextLine();

    	System.out.println("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	/*
    	 * for(int i = 0; i < str.length(); i++) {
    		if( ch == str.charAt(i)) count++; 	
    	}
    	 * 
    	 * */
    	// 향상된 for문 
    /*	for(char s : str.toCharArray()) {
    		if(ch == s) count++;
    	}
   
    	
    	
    	System.out.println("banana 안에 포함된 "+ ch + "개수 = "+ count );	
    }*/
    	
    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    

  	for (int i = 0; i <= 100; i++ ) {	
  		int random = (int)(Math.random()*11);

  		if(random != 0) {
  		System.out.println(random);
  		
  		}else if(random == 0) {
  			System.out.println("random은 : " + random);
  			break;
  		}
  		/*
  		switch(random) {
		case  0:
		System.out.println("1 : " + random);
		break;
		
		default : 
			System.out.println("잘못입력했습니다");
  	*/	
  	}}
  	
  	//}}
 

    // 강사님 코드
   /* while(true) {
    	int random = (int)(Math.random() * 11);
    	System.out.println(random);
    	if(random == 0) break;
    	
    }}*/
    
    
    
	

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	
    
    	
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		
		
		for(int i = 1; i <= 10; i++) {
			int random = (int)(Math.random() * 6+1 );
			
		
		if(random == 1) {
			num1 = num1+1;
		}	
		else if(random == 2) {
			num2 = num2+1;
		}
		else if(random == 3) {
			num3 = num3+1;
		}
		else if(random == 4) {
			num4 = num4+1;
		}
		else if(random == 5) {
			num5 = num5+1;
			
		}
		else if(random == 6) {
			num6 = num6+1;
		}	
		}
		System.out.println("1 : "+num1+"\n2 : "+num2+"\n3 : "+num3+"\n4 : "+num4+"\n5 : "+num5+"\n6 : "+num6);
		}
    {
    // 강사님 코드
   /* int[] dice = new int[6];
    		// 이 부분 이해가지 않으시다면 switch나 if 조건문 활용하시고 나서!
    		for(int i = 0; i < 10; i++) {
    			int random = (int)(Math.random() * 6); // 1 ~ 6 -> 0 ~ 5
    			// --> random : 1(0) --> dice[0]
    			// --> random : 2(1) --> dice[1]
    			dice[random]++; // (dice[random]++) 
    			
    			
    		}
    		for(int i = 0; i < dice.length; i++) {
    			System.out.println((i+1) + " : " + dice[i]);
    		}*/
    		
    }
    

    	
			 /*
		switch(random) {
		
		case  1:
			  num1 = num1+1;
			System.out.println("1 : " + num1);	
		break;
		
		case 2:
			num2 = num2+1;
			System.out.println("2 : " + num2);	
		break;
		
		case 3:
			num3 = num3+1;
			System.out.println("3 : " + num3);
		break;
		
		case 4:
			num4 = num4+1;
			System.out.println("4 : " + num4);
			break;
			
		case 5:
			num5 = num5+1;
			System.out.println("5 : " + num5);
			break;
			
		case 6:
			num6 = num6+1;
			System.out.println("6 : " + num6);
			break;
	
	
		
} *///} }
    	
    	
    	/*	
    	int random = (int)(Math.random() * 6 +1);
		int num2 = 0;
		while(true) {
		System.out.println("주사위 10번 값 입력 > ");
		int num = sc.nextInt();
			num2 ++;
		if(num == 1) {
			System.out.println("1 : " + num2);	
		}
		else if(num == 2) {
			System.out.println("2 : " + num2);	
		}
		else if(num == 3) {
			System.out.println("3 : " + num2);	
		}
		else if(num == 4) {
			System.out.println("4 : " + num2);	
		}
		else if(num == 5) {
			System.out.println("5 : " + num2);	
			
		}
		else if(num == 6) {
			System.out.println("6 : " + num2);	
		}}
*/
   

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {

    	System.out.println("당신의 이름을 입력하세요 : ");
    	String name = sc.nextLine();
    	
    	System.out.println("가위바위보 : ");
    	String MY = sc.nextLine();
    	
    	
    	
    	char 가위 = 1;
    	char 바위 = 2;
    	char 보 = 3;
    	
    	int win = 0;
    	int draw = 0;
    	int lose = 0;
    	
    	while(true) {  
    	int random = (int)(Math.random()*3+1); 
    	if(가위 == random) {
    		draw = draw+1;
		}	
		else if(바위 == random) {
			lose = lose+1;
		}
		else if(보 == random) {
			win = win+1;
			 break;
		}
    	
    }System.out.println("비긴 횟수 : "+draw+"\n진 횟수 : "+lose+"\n이긴 횟수 : "+win);}}
    	
    // 강사님 코드 ------------------------------------------
  /*  
    String [] rps = {"가위","바위","보"};
    int win = 0;
	int lose = 0;
	int draw = 0;
	
    System.out.println("당신의 이름을 입력하세요 : ");
	String name = sc.nextLine();
	
	
    
    while(true) {
    	System.out.println("가위바위보 : ");
    	String input = sc.nextLine();
    	
    	// 0 - 가위, 1 - 바위, 2 - 보
    	int computer = (int)(Math.random()*3);
    	System.out.println("컴퓨터 : " + rps[computer]);
    	
    	System.out.println(name + " : " + input);
    	
    	// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로!
    	int number = Arrays.asList(rps).indexOf(input);
    	
    	if(computer == number) {
    		// 비겼을 경우
    		System.out.println("비겼습니다.");
    		draw++;
    	} else if((number == 0 && computer == 2)
    			||(number == 1 && computer == 0)
    			|| (number == 2 && computer == 1)){
    		// 이겼을 경우
    		System.out.println("이겼습니다.");
    		win++;
    		 break;
    	} else {
    		// 졌을 경우
    		System.out.println("졌습니다ㅠㅠ");
    		lose++;
    	}
    }
    System.out.println("비긴 횟수 : "+draw+", 진 횟수 : "+lose+", 이긴 횟수 : "+win);
    }

}*/