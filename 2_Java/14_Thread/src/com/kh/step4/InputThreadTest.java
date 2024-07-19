package com.kh.step4;

import javax.swing.JOptionPane;

// 프로세스 - 두 스레드간의 Communication은 프로세스의 자원으로 해야 한다.
public class InputThreadTest {

	boolean check = false;
	
	public static void main(String[] args) {
		
		InputThreadTest process = new InputThreadTest();
		
		
		
		InputThread input = new InputThread(process);
		input.start();
		
		
		/* 내가 한거
		Count count = new Count();
		count.start();
		
		// 1. 데이터 입력 작업
		String input = JOptionPane.showInputDialog("시간이 다 되기 전에 최종 로또 번호를 입력하세요..");
		System.out.println("입력하신 숫자는 " + input + "입니다.");
		*/
		
		// 강사님 코드
		/*
		 * for(int i = 10; i > 0; i--) {
			if(process.check) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		if(!process.check) {
			System.out.println("10초 경과! 값 입력 중지!!");
			System.exit(0); // 강제 종료
			
		}
		
*/
		
		CountThread count = new CountThread(process);
		count.start();
		
	}

}
