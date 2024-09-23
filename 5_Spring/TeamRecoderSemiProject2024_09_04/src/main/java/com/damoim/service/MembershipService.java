package com.damoim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.damoim.model.dto.MemberListDTO;
import com.damoim.model.dto.MemberLocTypeDTO;
import com.damoim.model.dto.SearchDTO;
import com.damoim.model.vo.BasicRoomListVo;
import com.damoim.model.vo.LocationCategory;
import com.damoim.model.vo.Member;
import com.damoim.model.vo.Membership;
import com.damoim.model.vo.MembershipLocation;
import com.damoim.model.vo.MembershipType;
import com.damoim.model.vo.MembershipUserList;
import com.damoim.model.vo.Paging;
import com.damoim.model.vo.TypeCategory;
import com.damoim.model.vo.UserInfoPaging;

import mapper.MembershipMapper;

@Service
public class MembershipService {

	@Autowired
	private MembershipMapper mapper;

	public List<MembershipUserList> allMembership() {
		// 08-21 14:30 채승훈 지움 (Paging paging)
		// paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		return mapper.allMembership();
	}

	public List<MembershipUserList> MembershipAllInfo(int membershipCode) {

		return mapper.MembershipAllInfo(membershipCode);
	}

	public List<MembershipUserList> MembershipAllRegular(int membershipCode) {

		return mapper.MembershipAllRegular(membershipCode);
	}

	public MembershipUserList main(Integer membershipCode) {

		return mapper.main(membershipCode);
	}

	public int membershipUserCount(int count) {
		return mapper.membershipUserCount(count);
	}

	public void membershipApply(MemberListDTO member) {
		mapper.membershipApply(member);

	}
	// 클럽 생성
	public void makeMembership(Membership membership) {
		mapper.makeMembership(membership);
	}
	
	// 지역 추가
	public void makeLocationMembership(MembershipLocation membershipLocation) {
		mapper.makeLocationMembership(membershipLocation);
	}

	// 유형 추가
	public void makeTypeMembership(MembershipType membershipType) {
		mapper.makeTypeMembership(membershipType);
	}
			
	// 지역- 이름으로 찾기
	public int findLocationCode(LocationCategory locationCategory) {
		return mapper.findLocationCode(locationCategory);	
	}
			
	// 유형- 이름으로 찾기
	public int findTypeCode(TypeCategory typeCategory) {
		return mapper.findTypeCode(typeCategory);	
	}
	

	public void membershipImg(Membership membership) {
		mapper.membershipImg(membership);
	}

	public void host(MemberListDTO list) {
		mapper.host(list);
	}

	// 로그인 회원 가입한 클럽처리
	public List<MemberListDTO> grade(Member member) {
		return mapper.grade(member);
	}

	public void agreeMemeber(MemberListDTO member) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Member mem = (Member) authentication.getPrincipal();

		ArrayList<MemberListDTO> list = (ArrayList<MemberListDTO>) mem.getMemberListDTO();

		if (member.getListGrade().equals("delete")) {
			mapper.expelMember(member);

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getMembershipCode() == member.getMembershipCode()) {
					list.remove(i);
				}

			}

		} else if (member.getListGrade().equals("host")) {

			mapper.hostChange(member.getMembershipCode());
			mapper.agreeMemeber(member);

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getMembershipCode() == member.getMembershipCode()) {
					list.get(i).setListGrade("admin");

				}

			}

		} else if (member.getListGrade().equals("admin")) {
			mapper.agreeMemeber(member);

		}
	}




	public List<BasicRoomListVo> roomlist() {
		return mapper.roomlist();
	}

	public void updateMembershipInfo(Membership membershipInfo) {
		mapper.updateMembershipInfo(membershipInfo);
	}

	public Membership selectMembership(int membershipCode) {
		return mapper.selectMembership(membershipCode);
	}

	// public List<MembershipUserList> list(Paging paging) {

	// return mapper.allMembership(paging);
	// }

	// public MemberListDTO checkMember(MemberListDTO memberListDTO) {

	// return mapper.checkMember(memberListDTO);
	// }

	public Membership membershipNameCheck(Membership membership) {
		return mapper.membershipNameCheck(membership);
	}

	public int makeMembershipCode(String membername) {
		return mapper.makeMembershipCode(membername);
	}

	public int meetCount(String id) {
		return mapper.meetCount(id);
	}

	public List<MembershipUserList> selectMemberUserList(String id) {

		return mapper.selectMemberUserList(id);
	}

//	public List<MembershipUserList> list(Paging paging) {
//		
//		return mapper.allMembership(paging);
//	}

	public List<MemberListDTO> adminUser(int membershipCode) {

		return mapper.adminUser(membershipCode);
	}

	public MemberListDTO ifHost(String id) {

		return mapper.ifHost(id);

	}

}
