package com.kh.stream.intermediate;

import java.util.Arrays;

/*
 * 반복
 * - 요소 정체를 반복하는 역할
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * 
 * */

public class D_Looping {

	public static void main(String[] args) {

		
		int[] values = {1, 2, 3, 4, 5};
		
		// 1 ~ 5중 짝수의 합계 
		
		
		// 중간처리라 중간이면 어디든 사용 가능
		int sum1 = Arrays.stream(values)
		.filter(num -> num % 2 ==0)
		.peek(num -> System.out.println(num))
		.sum();
		System.out.println(sum1);

		
		// foreach
	
		Arrays.stream(values)
		.filter(num -> num % 2 ==0)
		.forEach(num -> System.out.println(num));
	
		int sum2 = Arrays.stream(values)
				.filter(num -> num % 2 ==0)
				.sum();
		System.out.println(sum2);
		
		
		
		
		/*	int sum2 = Arrays.stream(values)
		.filter(num -> num % 2 ==0)
		.forEach(num -> System.out.println(num))
		.sum();
		System.out.println(sum2);*/
		
		
		
	}

}
