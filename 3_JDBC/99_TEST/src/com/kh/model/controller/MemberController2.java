package com.kh.model.controller;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member2;

public class MemberController2 {
	
	private MemberDAO member = new MemberDAO();
	
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
	
	
	
	
	
	
	
	
}
