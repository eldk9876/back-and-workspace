package com.kh.practice.controller;

import java.util.Arrays;

import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Member;


public class MemberController {

	private Member member = new Member();
	private Member[] mArr = new Member[3];
	
	public int count = 0;

	// 멤버추가
	public void insertMember(Member m) throws DuplicateNameException, RecordNotFoundException {
		
		int index = checkUpdateId(m.getId());
		
		if(index == -1) {
			mArr[count++] = new Member(m.getId(), m.getName(),m.getPwd(),
					m.getEmail(),m.getGender(),m.getAge());
			
		} else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException();
		}
		
		
		
		//System.out.println(Arrays.toString(mArr));
	}
	
	// 멤버 아이디 검색 -> 멤버 index를 아이디로 조회
	public int checkUpdateId(String id) throws RecordNotFoundException {
		for(int i = 0; i < mArr.length; i++) {
			if(mArr[i]!=null && mArr[i].getId().equals(id)) {
				// 기존 멤버 배열에 아이디가 있는 경우!
				return i;
			}else {
				throw new RecordNotFoundException();
			}
		}
		// 아이디가 없는 경우
		return -1;
	}
	
	
	public void updateMember(String id,String name,String pwd,String email) throws RecordNotFoundException {
		// 멤버의 index 찾기!
		int index = checkUpdateId(id);
		mArr[index].setName(name);
		mArr[index].setEmail(email);
		mArr[index].setPwd(pwd);
	}
	
	/*완전 자유롭게*/

	
	public void add(String id, String name,String pwd,String email, char gender, int age) {
		
		member.setId(id);
		member.setName(name);
		member.setPwd(pwd);
		member.setEmail(email);
		member.setGender(gender);
		member.setAge(age);
	}
	
	public void add(String id, String name,String pwd,String email) {
		member.setId(id);
		member.setName(name);
		member.setPwd(pwd);
		member.setEmail(email);
		
	}
	// 멤버 조회
	public Member[] printAll() {
		return mArr;
	}
	
		// 아이디 변경
		public void modify(String id) {

			member.setEmail(id);
				
	}
		// 이름 변경
		public void modify1(String name) {

			member.setEmail(name);
			
	}
		// Email 변경
		public void modify2(String email) {

			member.setEmail(email);
			
	}
	
	// 비밀변호 변경
	public void modify3(String pwd) {

		member.setEmail(pwd);
		
	}
	
	
	
	
	
	/*
	public Member info() {
		
		return member;
	}
	
	*/
	 	

	
	
	
}
