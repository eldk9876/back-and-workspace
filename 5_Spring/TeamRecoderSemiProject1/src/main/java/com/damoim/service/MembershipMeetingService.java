package com.damoim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.damoim.model.vo.MeetingsAgree;
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

public MembershipMeetings meetSelect (int meetCode) {
	
	return mapper.meetSelect(meetCode);
}
public void yesOrNo(MeetingsAgree ma) {
	
	mapper.yesOrNo(ma);
}

public List<MeetingsAgree> meetMember(int meetCode){
	
	return mapper.meetMember(meetCode);
}

public void participation (MeetingsAgree ma) {
	
	mapper.participation(ma);
}


public void participationCancle (MeetingsAgree ma) {
	
	mapper.participationCancle(ma);
}

public void meetingDelete(MembershipMeetings meetings) {
	
	mapper.meetingDelete(meetings);
}

	 public void meetingUpdate(MembershipMeetings meetings) {
		 mapper.meetingUpdate(meetings);
	 }
	 
	 public List<MembershipMeetings> allMeetings1(String id){
		 
		return  mapper.allMeetings1(id);
	 }
	 
}
