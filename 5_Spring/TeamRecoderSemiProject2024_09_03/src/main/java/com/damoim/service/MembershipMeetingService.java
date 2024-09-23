package com.damoim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoim.model.vo.MembershipMeetings;

import mapper.MembershipMeetingMapper;



@Service
public class MembershipMeetingService {
 
	
	@Autowired
	private MembershipMeetingMapper mapper;
	
	public void addMeeting(MembershipMeetings meetings) {
		
		mapper.addMeeting(meetings);
	}
	
public List<MembershipMeetings> allMeetings( int membershipCode) {
		
	 return mapper.allMeetings(membershipCode);
	}
	 
	 
}
