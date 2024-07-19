package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kh.example.practice1.rottonumber.Rottonumber;

public class Application2 {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		// while(lotto.size() < 6) { // 기존 로또 번호는 6개 보너스번호가 필요해서 -> 1개 더 추가
		while(lotto.size() < 7) {
		int num = (int) (Math.random() * 45 + 1) ;
		if(!lotto.contains(num)) {
			lotto.add(num);	
		}
		
		}
		
		// 0 ~ 6까지 범위 지정해서 로또 번호 6개 따로, 보너스 번호 따로!
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = lotto.get(6);
		
		
		
		int count = 0;
		while(true) {
			
			count ++;
			
			ArrayList<Integer> myLotto = new ArrayList<>();
			
			while(myLotto.size() < 6) {
				int num = (int)(Math.random() * 45 + 1);
				if(!myLotto.contains(num)) {
					myLotto.add(num);	
				}
				
			}
			
			//System.out.println("로또 번호 : " + lotto); // 기존 6개
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("내 번호 : " + myLotto);
			
			//Collections.sort(lotto);
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			// 멈추는 조건! 로또 번호와 내 번호가 정확히 일치! 1등 당첨!
			//if(lotto.equals(myLotto)) { // 기존 6개
			if(lottoList.equals(myLotto)) {
				System.out.println("1등 당첨!하기전 갯수 : " + count);
				break;
			}
			int match = 0;
			
			for(Integer num : lottoList) {
				if(myLotto.contains(num)) {
					match ++;
				}
			}
			// 사실상 3등 당첨
			/*if(match == 5) {
				System.out.println("횟수 : " + count);
				break;*/
				
				if(match == 5) {
					if(myLotto.contains(bonus)) {
					System.out.println("2등 당첨!보너스 번호:"+bonus + ", 횟수 : " + count + "사용한 금액" + count*1000);
					break;
					} else {
						System.out.println("3등 당첨! 횟수 : "+ count + "사용한 금액" + count*1000);
						break;
					}
					} else if(match == 4) {
						System.out.println("4등 당첨! 횟수 : "+ count + "사용한 금액" + count*1000);
						break;
					}else if(match == 3) {
						System.out.println("5등 당첨! 횟수 : "+ count + "사용한 금액" + count*1000);
						break;
					}
			}
			
			
		}
	
		
		
		}
		
	

