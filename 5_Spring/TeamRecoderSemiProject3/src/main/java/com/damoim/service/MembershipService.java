package com.damoim.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoim.model.dto.MemberListDTO;
import com.damoim.model.vo.Member;
import com.damoim.model.vo.Membership;
import com.damoim.model.vo.MembershipUserList;


import mapper.MembershipMapper;

@Service
public class MembershipService {
	
	@Autowired
	private MembershipMapper mapper;
	
	public List<MembershipUserList> allMembership(){
		
		return mapper.allMembership();
	}
	public List<MembershipUserList> MembershipAllInfo(int membershipCode){
		
		return mapper.MembershipAllInfo(membershipCode);
		
	}

	
   public MembershipUserList main(Integer membershipCode){
		
		return mapper.main(membershipCode);
	}
   public int membershipUserCount(int count){
		return mapper.membershipUserCount(count);
 	}
   
   
   
   public void membershipApply(MemberListDTO member) {
	   mapper.membershipApply(member);
	   
   }
   
   public MemberListDTO checkMember(MemberListDTO member) {
	   return mapper.checkMember(member);
	   
   }
	

	public void makeMembership(Membership membership) {

		mapper.makeMembership(membership);
	}
	
	public void host(MemberListDTO list) {
		mapper.host(list);
	}
	
	public List<MembershipUserList> grade(Member member){
		return mapper.grade(member);
	}
	
	public void agreeMemeber(MemberListDTO member) {
		mapper.agreeMemeber(member);
		
	}

	
	public void createclub(Membership membership) {
		mapper.createclub(membership);
	}
	public void createclub2(Membership membership) {
		mapper.createclub2(membership);
	}


	
	
}
