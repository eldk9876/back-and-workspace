package com.kh.step3;

import java.awt.Toolkit;

import com.kh.step3.SoundThread2;
import com.kh.step3.GoThread2;

public class BeepPrintTest {

	public static void main(String[] args) {

		BeepThread beep = new BeepThread();
		beep.start();
		
		/* implements Runnable
		BeepThread beep = new BeepThread();
		Thread thread = new Thread(beep); 
		thread.start();
		*/

		// 1. Thread 생성
		/*
				GoThread2 go = new GoThread2();
				SoundThread2 sound = new SoundThread2();
				
				Thread tGo = new Thread(go, "GoThread");
				Thread tSound = new Thread(sound, "SoundThread2");
				
				
				// 2. start 호출
				tGo.start();
				tSound.start();
		*/

		
		
		
			// 경고음 5번 울리는 작업
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*
		// 띵띵띵띵띵을 5번 출력하는 작업
		for(int i = 0; i < 5; i++) {
			System.out.println("띵~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
		}
		*/
		
	}

}
