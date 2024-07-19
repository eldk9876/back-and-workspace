package com.kh.example.practice1;

import java.util.Arrays;

import com.kh.example.practice1.rottonumber.Rottonumber;

public class Application {

	
	public static void main(String[] args) {
		
		
	
		
		 double random1 = Math.random();
		 random1 = Math.random() * 44 + 1;
		 int num1 = (int)random1; // 1 ~ 45까지의 랜덤값
		 
		 double random2 = Math.random();
		 random2 = Math.random() * 44 + 1;
		 int num2 = (int)random2; // 1 ~ 45까지의 랜덤값
		 
		 double random3 = Math.random();
		 random3 = Math.random() * 44 + 1;
		 int num3 = (int)random3; // 1 ~ 45까지의 랜덤값
		 
		 double random4 = Math.random();
		 random4 = Math.random() * 44 + 1;
		 int num4 = (int)random4; // 1 ~ 45까지의 랜덤값
		 
		 double random5 = Math.random();
		 random5 = Math.random() * 44 + 1;
		 int num5 = (int)random5; // 1 ~ 45까지의 랜덤값
		 
		 double random6 = Math.random();
		 random6 = Math.random() * 44 + 1;
		 int num6 = (int)random6; // 1 ~ 45까지의 랜덤값
		 
		 int[] arr = {num1,num2,num3,num4,num5,num6 };
		 int[] copy = arr.clone();
		 System.out.println(Arrays.toString(copy));
		 System.out.println("-------------");
		 		 
		int Count = 0;
		for (int i = 1; i <= 6; i++) {
				Count = i; // 6번 반복 실행
				 
				
				
				 double random7 = Math.random();
				 random7 = Math.random() * 44 + 1;
				 int num7 = (int)random7; // 1 ~ 45까지의 랜덤값
				 
				 double random8 = Math.random();
				 random8 = Math.random() * 44 + 1;
				 int num8 = (int)random8; // 1 ~ 45까지의 랜덤값
				 
				 double random9 = Math.random();
				 random9 = Math.random() * 44 + 1;
				 int num9 = (int)random9; // 1 ~ 45까지의 랜덤값
				 
				 double random10 = Math.random();
				 random10 = Math.random() * 44 + 1;
				 int num10 = (int)random10; // 1 ~ 45까지의 랜덤값
				 
				 double random11 = Math.random();
				 random11 = Math.random() * 44 + 1;
				 int num11 = (int)random11; // 1 ~ 45까지의 랜덤값
				 
				 double random12 = Math.random();
				 random12 = Math.random() * 44 + 1;
				 int num12 = (int)random12; // 1 ~ 45까지의 랜덤값
				 
				
				 int[] arr2 = {num7,num8,num9,num10,num11,num12 }; 
				 int[] copy2 = arr2.clone();
	 
				 
				System.out.println(Arrays.toString(copy2));
				
		}
		System.out.println(Count);
		
		
		// 만약 로또번호와 내 번호가 틀리다면 계속 
		//if()
		
		// 만약 로또 번호와 내 번호가 같다면 중지하고 횟수 출력
		
		
		
		}
		
	}


