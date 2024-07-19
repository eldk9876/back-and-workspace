package com.kh.example.practice2;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;
import com.kh.example.practice2.model.Snack;

public class Application {
	

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		SnackController controller = new SnackController();
		
		
		Snack snack = new Snack();
		snack.setkind("빵");
		//String kind = sc.nextLine();
		snack.setname("케이크");
		snack.setflavor("블루베리");
		snack.setnumOf(1);
		snack.setprice(15000);
		
		
		System.out.printf("스넥류를 입력하세요. \n종류: "+snack.getkind() + "\n이름 : "+ snack.getname() + "\n맛 : "+ snack.getflavor() + "\n개수 : "+ snack.getnumOf() + "\n가격 : "+ snack.getprice() + ""
				+ "\n저장 완료되었습니다.\n" );
		System.out.printf(snack.getkind()+"(" +snack.getname() + " - " + snack.getflavor()+") "+ snack.getnumOf()+"개 "+snack.getprice()+"원" );
		*/
		
		
		// 강사님 코드
		// ----------------------------화면---------------------------
		Scanner sc = new Scanner(System.in);
		
		System.out.println("스넥류를 입력하세요");
		System.out.println("종류 : ");
		String kind = sc.nextLine();
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.println("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine());
		
		System.out.println("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		// ---------------------------------------------------------
		// --> 즉, 여기까지는 controller나 model에 직접 접근 X
		
		// 데이터들을 서버한테 요청! 서버한테 전달할 때는 controller로!
		SnackController controller = new SnackController();
		
		//System.out.println("저장 완료되었습니다");
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로!
	//	System.out.println(controller.saveData(kind,name,flavor,numOf,price));
		
	//	System.out.println(controller.confirmData());
		/*	Snack snack = new Snack();
		snack.setkind(kind);
		snack.setname(name);
		snack.setflavor(flavor);
		snack.setnumOf(numOf);
		snack.setprice(price);
		*/
		
		
		
	//	System.out.println(kind+"("+ name + " - " + flavor + ") "+ numOf +"개 "+price +"원" );
		
	}

}
