package com.kh.step3;

import java.awt.Toolkit;

/*
 * 스레드 생성하는 방법2
 * 
 * 1. Runnable 인터페이스를 구현한다.
 * 2. run() 메서드를 오버라이딩한다.
 * 3. Thread 객체 생성 시 생성자의 Runnable 인터페이스를 구현한 객체를
 * 	  매개값으로 전달 후 start() 메서드를 호출한다.
 * 
 * 
 * 
 * 
 * */


public class SoundThread2 implements Runnable {

					@Override
					public void run() {
		
	
					
					Toolkit tool = Toolkit.getDefaultToolkit();
					
					for(int i = 0; i < 5; i++) {
						tool.beep();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			
			
			
		
		
		
	}


