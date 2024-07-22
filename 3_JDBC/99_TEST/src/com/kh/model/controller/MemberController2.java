package com.kh.model.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Member2;
import com.kh.model.vo.Rent;

public class MemberController2 {
	
	private MemberDAO member = new MemberDAO();
	private RentDAO rent = new RentDAO();
	
	// .4 회원가입
	public boolean registerMember(String id, String password, String name) {
		try {
			member.registerMember(id, password, name);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	// 5. 로그인
	public Member2 login(String id, String password) {
		try {
			Member2 m = member.login(id,password);
			if(m.getStatus() == 'N') return m;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	// 5. 회원탈퇴
	public void deleteMember() {
		// 회원탈퇴할 때 대여중인 책들을 
		
	}
	
	
	// 5. 회원탈퇴
	public boolean deleteMember(int memberNo) {
	// 회원탈퇴할 때 대여중인 책 있으면 탈퇴 못하게 막을까요?
	try {
		//ArrayList<Rent> bookList = rent.printRentBook(memberNo);
		//if(bookList.size() > 0) return true;
		
		
	//	if(member.deleteMember(memberNo) == 1 ) return true;
		
	// 아님 회원 탈퇴시 대여중인 책들 모두 기록 삭제할까요? DELETE 조건 CADCADE!
		if(member.deleteMember(memberNo) == 1 ) return true;
						
		} catch (Exception e) {
			e.printStackTrace();
		}
					
		return false;
					
					
				}
	
	
	
	
	
}
