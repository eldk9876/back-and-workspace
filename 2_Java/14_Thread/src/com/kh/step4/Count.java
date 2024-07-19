package com.kh.step4;

import javax.swing.JOptionPane;

public class Count extends Thread{

	public void run() {
		
	// 2. 카운팅 작업
			for(int i = 10; i > 0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
				if(i == 1) {
					System.out.println("시간이 다 되었습니다");
					JOptionPane.showInputDialog("시간이 다 되었습니다..");
				}
			}
	
	
	
	}
}
